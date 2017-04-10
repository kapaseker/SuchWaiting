package com.azalea.suchwaiting.exception;

/**
 * Created by Panoo on 2017/4/10.
 */

public class UnsupportedValueSetException extends RuntimeException {

	private UnsupportedValueSetException() {
		super();
	}

	public UnsupportedValueSetException(String msg) {
		super(msg);
	}
}
