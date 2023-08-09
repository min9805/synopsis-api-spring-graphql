package com.skb.graphql.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

@Configuration
public class HttpHeadersConfig {

	@Value("${header.api_key}")
	private String apiKey;

	@Value("${header.auth_val}")
	private String authVal;

	@Value("${header.client_id}")
	private String clientId;

	@Value("${header.time_stamp}")
	private String timeStamp;

	@Value("${header.trace}")
	private String trace;

	@Value("${header.uuid}")
	private String uuid;

	@Bean
	public HttpEntity<String> httpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json;charset=utf-8");
		headers.set("Api_Key", apiKey);
		headers.set("Auth_Val", authVal);
		headers.set("Client_ID", clientId);
		headers.set("TimeStamp", timeStamp);
		headers.set("Trace", trace);
		headers.set("UUID", uuid);

		return new HttpEntity<>(headers);
	}
}