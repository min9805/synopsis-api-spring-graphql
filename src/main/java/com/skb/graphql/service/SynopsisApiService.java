package com.skb.graphql.service;

import com.skb.graphql.entity.ContentSmd;
import com.skb.graphql.entity.ContentSmdInput;
import com.skb.graphql.entity.Synopsis;
import com.skb.graphql.entity.SynopsisInput;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SynopsisApiService {
	private final RestTemplate restTemplate;

	public SynopsisApiService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Synopsis getSynopsis(SynopsisInput input) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json;charset=utf-8");
		headers.set("Api_Key", input.getApi_Key());
		headers.set("Auth_Val", input.getAuth_Val());
		headers.set("Client_ID", input.getClient_ID());
		headers.set("TimeStamp", input.getTimeStamp());
		headers.set("Trace", input.getTrace());
		headers.set("UUID", input.getUUID());

		// Create HttpEntity with headers
		HttpEntity<String> entity = new HttpEntity<>(headers);


		return null;
	}
}