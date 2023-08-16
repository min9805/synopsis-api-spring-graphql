package com.skb.graphql.service;

import com.skb.graphql.entity.ContentScs;
import com.skb.graphql.entity.input.ContentScsInput;
import com.skb.graphql.entity.input.SynopsisInput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Service
public class ScsApiService {
	private final RestTemplate restTemplate;

	@Value("${scs.url}")
	private String baseUrl;

	public ScsApiService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ContentScs getContentScs(ContentScsInput input) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<ContentScsInput> requestEntity = new HttpEntity<>(input, headers);

		ResponseEntity<ContentScs> response = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, ContentScs.class);

		return response.getBody();
	}

	public ContentScs getContentScs2(ContentScsInput input, SynopsisInput synopsisInput) throws UnsupportedEncodingException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		input.setSynopsis_type(synopsisInput.getSearch_type());
		input.setVer(synopsisInput.getVersion_sw());
		input.setHash_id(synopsisInput.getHash_id());
		input.setSris_id(synopsisInput.getSeries_id());
		input.setStb_id(URLDecoder.decode(synopsisInput.getStb_id(), "UTF-8"));

		HttpEntity<ContentScsInput> requestEntity = new HttpEntity<>(input, headers);

		ResponseEntity<ContentScs> response = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, ContentScs.class);

		return response.getBody();
	}

}