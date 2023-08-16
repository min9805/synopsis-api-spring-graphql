package com.skb.graphql.entity.input;

import lombok.Data;

@Data
public class ContentSmdInput {
	private String IF;
	private String m;
	private String stb_id;
	private String version_sw;
	private String mac_address;
	private String series_id;
	private String total_yn;
	private SynopsisInput synopsisInput;
}