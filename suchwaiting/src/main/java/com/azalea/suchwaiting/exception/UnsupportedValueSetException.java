package com.azalea.suchwaiting.exception;


/**
 * an exception for unsupported value
 */
public class UnsupportedValueSetException extends RuntimeException {

	private UnsupportedValueSetException() {
		super();
	}

	public UnsupportedValueSetException(String msg) {
		super(msg);
	}
}
