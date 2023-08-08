package com.skb.graphql.service;

import com.skb.graphql.entity.ContentEuxp;
import com.skb.graphql.entity.ContentEuxpInput;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@Service
public class EuxpApiService {
	private final RestTemplate restTemplate;

	public EuxpApiService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ContentEuxp getContentEuxp(ContentEuxpInput input) {

		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
		defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

		restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);

		String baseUrl = "https://agw-stg.sk-iptv.com:8087/euxp/v5/contents/synopsis";

		UriComponents uriComponents = UriComponentsBuilder.fromUriString(baseUrl)
				.queryParam("IF", input.getIF())
				.queryParam("search_type", input.getSearch_type())
				.queryParam("yn_recent", input.getYn_recent())
				.queryParam("menu_stb_svc_id", input.getMenu_stb_svc_id())
				.queryParam("epsd_id", input.getEpsd_id())
				.queryParam("stb_id", "%7B660D7F55-89D8-11E5-ADAE-E5AC4F814417%7D")
				.build();

		// Construct the request body using the input data
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

		ResponseEntity<ContentEuxp> response = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, entity, ContentEuxp.class);


		return response.getBody();
	}
}