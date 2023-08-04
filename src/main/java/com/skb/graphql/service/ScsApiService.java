package com.skb.graphql.service;

import com.skb.graphql.entity.ContentScs;
import com.skb.graphql.entity.ContentScsInput;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ScsApiService {
	private final RestTemplate restTemplate;

	public ScsApiService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ContentScs getContentScs(ContentScsInput input) {
		String baseUrl = "http://payperview.scs.svc.skb-doj-stg01.btvpaas.com/v5/directview";

		// Construct the request body using the input data
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Create the request entity with the input data as the request body
		HttpEntity<ContentScsInput> requestEntity = new HttpEntity<>(input, headers);

		// Send the POST request and receive the response
		ResponseEntity<ContentScs> response = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, ContentScs.class);

		// Extract and return the response body
		return response.getBody();
	}

}