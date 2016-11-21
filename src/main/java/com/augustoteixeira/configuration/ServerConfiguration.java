package com.augustoteixeira.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfiguration {
	@Value("${torznab.host}")
	private String host;

	@Value("${torznab.port}")
	private String port;


	public String getHost() {
		return host;
	}

	public void setHost(String server) {
		this.host = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}
