package com.skb.graphql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skb.graphql.entity.ContentScs;
import com.skb.graphql.entity.input.ContentScsInput;
import com.skb.graphql.entity.input.SynopsisInput;
import com.skb.graphql.entity.input.SynopsisPageInput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

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

	public String getScsViewPage(SynopsisPageInput input) throws UnsupportedEncodingException {

		HttpHeaders headers = new HttpHeaders();
		ObjectMapper objectMapper = new ObjectMapper();
		headers.setContentType(MediaType.APPLICATION_JSON);

		ContentScsInput requestBody = new ContentScsInput();

		requestBody.setSynopsis_type(input.getSynopsisSearchType());
		requestBody.setVer("5.4.0");
		requestBody.setHash_id(input.getHashId());
		requestBody.setSris_id(input.getSeriesId());
		requestBody.setStb_id(URLDecoder.decode(input.getStbId()));
		List<ContentScsInput.PpvProduct> ppvProducts = new ArrayList<>();
		for (SynopsisPageInput.PpvProductInput ppvProductInput : input.getPpvProducts()) {
			ContentScsInput.PpvProduct ppvProduct = objectMapper.convertValue(ppvProductInput, ContentScsInput.PpvProduct.class);
			ppvProducts.add(ppvProduct);
		}
		requestBody.setPpv_products(ppvProducts);

		HttpEntity<ContentScsInput> requestEntity = new HttpEntity<>(requestBody, headers);

		String response = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity, String.class).getBody();

		return response;
	}
}