package com.skb.graphql.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ContentSmd(String result,
                         String reason,
                         String IF,
                         String like,
                         String dislike,
                         String updateDate,
                         String like_total,
                         String dislike_total,
                         String updateDate_total) {
	@JsonCreator
	public void ContentScsInput(
			@JsonProperty("response_format") String response_format,
			@JsonProperty("ver") String ver,
			@JsonProperty("stb_id") String stb_id,
			@JsonProperty("hash_id") String hash_id,
			@JsonProperty("ui_name") String ui_name,
			@JsonProperty("sris_id") String sris_id,
			@JsonProperty("synopsis_type") String synopsis_type,
			@JsonProperty("ppv_products") List<SCSProductInput> ppv_products
	) {
	}
}