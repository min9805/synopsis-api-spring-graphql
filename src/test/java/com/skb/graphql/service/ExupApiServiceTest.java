package com.skb.graphql.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.junit.jupiter.api.Assertions.*;

class ExupApiServiceTest {
	public static void testZ(String[] args) {
		String url = "https://agw-stg.sk-iptv.com:8087/euxp/v5/contents/synopsis";

		// Set headers
		HttpHeaders headers = new HttpHeaders();
		headers.set("Api_Key", "l7xx159a8ca72966400b886a93895ec9e2e3");
		headers.set("Auth_Val", "0xb613679a0814d9ec772f939398gff");
		headers.set("Client_ID", "111");
		headers.set("TimeStamp", "111");
		headers.set("Trace", "MYTV^APIGW");
		headers.set("UUID", "123456789");

		// Set query parameters
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				.queryParam("stb_id", "{660D7F55-89D8-11E5-ADAE-E5AC4F814417}")
				.queryParam("IF", "IF-EUXP-010")
				.queryParam("search_type", "1")
				.queryParam("yn_recent", "N")
				.queryParam("menu_stb_svc_id", "BTVWEBV540")
				.queryParam("epsd_id", "CE1000778167");

		// Create RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Set request entity with headers
		HttpEntity<?> requestEntity = new HttpEntity<>(headers);

		// Make the GET request and receive the response
		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, requestEntity, String.class);

		// Check if the request was successful (2xx status code)
		if (response.getStatusCode().is2xxSuccessful()) {
			// Process the response data as needed
			String data = response.getBody();
			System.out.println(data);
		} else {
			System.out.println("Request failed with status code: " + response.getStatusCodeValue());
			System.out.println(response.getBody());
		}
	}
}