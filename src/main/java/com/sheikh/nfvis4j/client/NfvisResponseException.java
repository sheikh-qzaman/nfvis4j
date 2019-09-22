package com.sheikh.nfvis4j.client;

/**
 * @author Sheikh Qumruzzaman
 * Sep 21, 2019
 */
public class NfvisResponseException extends RuntimeException {

	private static final long serialVersionUID = 7294957362769575271L;

	protected String message;

	protected int status;

	public NfvisResponseException(String message, int status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

}

