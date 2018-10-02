package fr.afcepf.al32.service;

public class MyServiceException extends RuntimeException {
//public class MyServiceException extends Exception { 
	
	//+eventuels details avec get/set

	public MyServiceException() {
	}

	public MyServiceException(String message) {
		super(message);
	}

	public MyServiceException(Throwable cause) {
		super(cause);
	}

	public MyServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
