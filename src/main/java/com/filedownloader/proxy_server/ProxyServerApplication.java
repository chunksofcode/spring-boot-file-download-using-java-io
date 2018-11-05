package com.filedownloader.proxy_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.filedownloader.proxy_server.model.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ProxyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyServerApplication.class, args);
	}
}
