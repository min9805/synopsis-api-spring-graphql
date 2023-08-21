package com.skb.graphql.service;

import com.skb.graphql.entity.input.ContentSmdInput;
import com.skb.graphql.entity.ContentSmd;
import com.skb.graphql.entity.input.SynopsisInput;
import com.skb.graphql.entity.input.SynopsisPageInput;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import org.yaml.snakeyaml.util.UriEncoder;

@Service
public class SmdApiService {
	private final RestTemplate restTemplate;

	@Value("${smd.url}")
	private String baseUrl;

	public SmdApiService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ContentSmd getContentSmd(ContentSmdInput input) {
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

		ResponseEntity<ContentSmd> response = restTemplate.getForEntity(url, ContentSmd.class);
		return response.getBody();
	}

	public ContentSmd getContentSmd2(ContentSmdInput input, SynopsisInput synopsisInput) {
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

		ResponseEntity<ContentSmd> response = restTemplate.getForEntity(url, ContentSmd.class);
		return response.getBody();
	}

	public String getSmdViewPage(SynopsisPageInput input) {
		try {
			UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(baseUrl)
					.queryParam("IF", "IF-SMTDV-V5-005")
					.queryParam("m", "getLikeHate")
					.queryParam("total_yn", "Y")

					.queryParam("stb_id", input.getStbId())
					.queryParam("version_sw", "5.4.0.0")
					.queryParam("mac_address", input.getMac())
					.queryParam("series_id", input.getSeriesId())
					.build();

			String url = uriComponents.toUriString();

			String response = restTemplate.getForEntity(url, String.class).getBody();
			return response;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}