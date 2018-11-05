package com.filedownloader.proxy_server.model;

public class FileDetails {
 private String fileName;
 private String fileUrl;
 private String fileType;
 private String fileDownloadLocation;
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}
public String getFileUrl() {
	return fileUrl;
}
public void setFileUrl(String fileUrl) {
	this.fileUrl = fileUrl;
}
public String getFileType() {
	return fileType;
}
public void setFileType(String fileType) {
	this.fileType = fileType;
}
public String getFileDownloadLocation() {
	return fileDownloadLocation;
}
public void setFileDownloadLocation(String fileDownloadLocation) {
	this.fileDownloadLocation = fileDownloadLocation;
}
 
}
