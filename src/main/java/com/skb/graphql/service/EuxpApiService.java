package com.skb.graphql.service;

import com.skb.graphql.entity.ContentEuxp;
import com.skb.graphql.entity.input.ContentEuxpInput;
import com.skb.graphql.entity.input.SynopsisInput;
import com.skb.graphql.entity.input.SynopsisPageInput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.yaml.snakeyaml.util.UriEncoder;


@Service
public class EuxpApiService {
	private final RestTemplate restTemplate;
	private final HttpEntity<String> httpHeaders;


	@Value("${euxp.url}")
	private String baseUrl;

	public EuxpApiService(RestTemplate restTemplate, HttpEntity<String> httpHeaders) {
		this.restTemplate = restTemplate;
		this.httpHeaders = httpHeaders;
	}

	public ContentEuxp getContentEuxp(ContentEuxpInput input) {

		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
		defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

		restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);

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

	public ContentEuxp getContentEuxp2(ContentEuxpInput input, SynopsisInput synopsisInput) {

		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
		defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

		restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);

		UriComponents uriComponents = UriComponentsBuilder.fromUriString(baseUrl)
				.queryParam("yn_recent", input.getYn_recent())
				.queryParam("IF", input.getIF())

				.queryParam("search_type", synopsisInput.getSearch_type())
				.queryParam("menu_stb_svc_id", synopsisInput.getMenu_stb_svc_id())
				.queryParam("epsd_id", synopsisInput.getEpsd_id())
				.queryParam("stb_id", UriEncoder.encode(synopsisInput.getStb_id()))
				.build();

		ResponseEntity<ContentEuxp> response = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, httpHeaders, ContentEuxp.class);


		return response.getBody();
	}

	public String getEuxpViewPage(SynopsisPageInput input) {

		DefaultUriBuilderFactory defaultUriBuilderFactory = new DefaultUriBuilderFactory();
		defaultUriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);

		restTemplate.setUriTemplateHandler(defaultUriBuilderFactory);

		UriComponents uriComponents = UriComponentsBuilder.fromUriString(baseUrl)
				.queryParam("yn_recent", input.getLookupType())
				.queryParam("IF", "IF-EUXP-010")

				.queryParam("search_type", input.getSynopsisSearchType())
				.queryParam("menu_stb_svc_id", input.getMenuStbServiceId())
				.queryParam("epsd_id", input.getEpisodeId())
				.queryParam("stb_id", input.getStbId())
				.build();

		String response = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, httpHeaders, String.class).getBody();

		return response;
	}
}