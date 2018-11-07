package com.filedownloader.proxy_server.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filedownloader.proxy_server.exceptions.FileNotDownloadedCorrectlyException;
import com.filedownloader.proxy_server.exceptions.FileStorageException;
import com.filedownloader.proxy_server.model.FileDetails;
import com.filedownloader.proxy_server.model.FileStorageProperties;
import com.filedownloader.proxy_server.utils.Constants;

@Service
public class FileDownloadService {
	
	public String downloadFile(FileDetails fileDetails) {
		try {
			
			URL url = new URL(fileDetails.getFileUrl());
			URLConnection urlCon = url.openConnection();
			urlCon.addRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
		    InputStream is = urlCon.getInputStream();
		    BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
			String downloadedFile = fileDetails.getFileDownloadLocation()+"/"+fileDetails.getFileName()+"."+fileDetails.getFileType();
			File file = new File(downloadedFile);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			byte dataBuffer[] = new byte[1024];
			int bytesRead;
			while ((bytesRead = bufferedInputStream.read(dataBuffer)) != -1) {
				fileOutputStream.write(dataBuffer, 0, bytesRead);
			}
			fileOutputStream.flush();
			fileOutputStream.close();
			return downloadedFile;
		} catch (MalformedURLException e) {
			throw new FileNotDownloadedCorrectlyException(
					Constants.FILE_NOT_DOWNLOADED_CORRECTLY, e);
		} catch (IOException e) {
			throw new FileNotDownloadedCorrectlyException(
					Constants.FILE_NOT_DOWNLOADED_CORRECTLY, e);
		}

	}
}
