package com.filedownloader.proxy_server.exceptions;

public class FileNotDownloadedCorrectlyException extends RuntimeException{

	public FileNotDownloadedCorrectlyException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public FileNotDownloadedCorrectlyException(String message) {
		super(message);
		
	}

}
