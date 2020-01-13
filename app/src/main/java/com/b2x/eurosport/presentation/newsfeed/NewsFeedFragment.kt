package com.b2x.eurosport.presentation.newsfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.b2x.eurosport.R
import com.b2x.eurosport.presentation.common.SpaceDecorator
import com.b2x.eurosport.presentation.model.News
import com.b2x.eurosport.presentation.model.Resource
import com.b2x.eurosport.presentation.model.ResourceStatus
import com.b2x.eurosport.presentation.newsfeed.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_newsfeed.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class NewsFeedFragment : Fragment() {

    val newsAdapter: NewsAdapter by inject()

    val newsFeedNewsViewModel: NewsFeedNewsViewModel by viewModel()

    private val feedRv get() = recycler_view_fragment_newsfeed

    private val loaderPb get() = progress_bar_view_fragment_newsfeed

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_newsfeed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()

        newsFeedNewsViewModel.getNewsLiveData().observe(this,
            Observer<Resource<List<News>>> {
                if (it != null) {
                    this.handleDataState(it)
                }
            })
        newsFeedNewsViewModel.fetchNews()
    }

    private fun initRecyclerview() {
        feedRv.setHasFixedSize(true)
        val layoutManager = LinearLayoutManager(activity)
        feedRv.layoutManager = layoutManager
        feedRv.addItemDecoration(
            SpaceDecorator(
                resources.getDimension(
                    R.dimen.spacing_normal
                ).toInt()
            )
        )
        feedRv.adapter = newsAdapter
    }

    private fun handleDataState(resource: Resource<List<News>>) {
        when (resource.resourceStatus) {
            ResourceStatus.LOADING -> setupScreenForLoadingState()
            ResourceStatus.SUCCESS -> setupScreenForSuccess(resource.data)
            ResourceStatus.ERROR -> setupScreenForError(resource.message)
        }
    }

    private fun setupScreenForLoadingState() {
        loaderPb.visibility = View.VISIBLE
        feedRv.visibility = View.GONE
    }

    private fun setupScreenForSuccess(data: List<News>?) {
        loaderPb.visibility = View.GONE
        if (data != null && data.isNotEmpty()) {
            newsAdapter.setData(data)
            feedRv.visibility = View.VISIBLE
        }
    }

    private fun setupScreenForError(message: String?) {
        loaderPb.visibility = View.GONE
        feedRv.visibility = View.GONE
        //todo display error
    }
}
