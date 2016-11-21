package com.augustoteixeira.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfiguration {
	@Value("${torznab.host}")
	private String server;

	@Value("${torznab.port}")
	private String port;

	@Value("${torznab.apikey}")
	private String apikey;

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}

}
