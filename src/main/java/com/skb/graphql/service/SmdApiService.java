package com.skb.graphql.service;

import com.skb.graphql.entity.ContentSmdInput;
import com.skb.graphql.entity.ContentSmd;
import com.skb.graphql.entity.SynopsisInput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.yaml.snakeyaml.util.UriEncoder;

@Service
public class SmdApiService {
	private final RestTemplate restTemplate;

	public SmdApiService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ContentSmd getContentSmd(ContentSmdInput input) {
		String baseUrl = "http://1.255.85.159:8080/delivery/UI5/sd-ui5service";

		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(baseUrl)
				.queryParam("IF", input.getIF())
				.queryParam("m", input.getM())
				.queryParam("stb_id", input.getStb_id())
				.queryParam("version_sw", input.getVersion_sw())
				.queryParam("mac_address", input.getMac_address())
				.queryParam("series_id", input.getSeries_id())
				.queryParam("total_yn", input.getTotal_yn())
				.build();

		String url = uriComponents.toUriString();

		// HTTP GET 요청을 보내고 결과를 ContentSmd 객체로 받아옵니다.
		ResponseEntity<ContentSmd> response = restTemplate.getForEntity(url, ContentSmd.class);
		return response.getBody();
	}

	public ContentSmd getContentSmd2(ContentSmdInput input, SynopsisInput synopsisInput) {
		String baseUrl = "http://1.255.85.159:8080/delivery/UI5/sd-ui5service";

		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(baseUrl)
				.queryParam("IF", input.getIF())
				.queryParam("m", input.getM())
				.queryParam("total_yn", input.getTotal_yn())

				.queryParam("stb_id", UriEncoder.encode(synopsisInput.getStb_id()))
				.queryParam("version_sw", synopsisInput.getVersion_sw())
				.queryParam("mac_address", synopsisInput.getMac_address())
				.queryParam("series_id", synopsisInput.getSeries_id())
				.build();

		String url = uriComponents.toUriString();

		// HTTP GET 요청을 보내고 결과를 ContentSmd 객체로 받아옵니다.
		ResponseEntity<ContentSmd> response = restTemplate.getForEntity(url, ContentSmd.class);
		return response.getBody();
	}
}