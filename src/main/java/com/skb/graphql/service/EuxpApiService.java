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
	private final HttpEntity<String> httpHeaders;

	public EuxpApiService(RestTemplate restTemplate, HttpEntity<String> httpHeaders) {
		this.restTemplate = restTemplate;
		this.httpHeaders = httpHeaders;
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

		ResponseEntity<ContentEuxp> response = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, httpHeaders, ContentEuxp.class);


		return response.getBody();
	}
}