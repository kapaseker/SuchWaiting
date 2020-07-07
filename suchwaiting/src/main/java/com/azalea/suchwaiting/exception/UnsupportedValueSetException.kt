package com.azalea.suchwaiting.exception

/**
 * an exception for unsupported value
 */
class UnsupportedValueSetException : RuntimeException {
    private constructor() : super() {}
    constructor(msg: String?) : super(msg) {}
}