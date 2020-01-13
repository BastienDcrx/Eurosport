package com.b2x.eurosport.presentation.error

class UnsupportedViewTypeException(private val type: String) : Exception() {

    override val message: String?
        get() = "Unsupported type :$type"

}
