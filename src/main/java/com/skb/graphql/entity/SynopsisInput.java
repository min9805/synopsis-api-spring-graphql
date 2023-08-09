package com.skb.graphql.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SynopsisInput {
	private String stb_id;
	private String menu_stb_svc_id;
	private String version_sw;
	private String mac_address;
	private String hash_id;

	private String epsd_id;
	private String series_id;
	private String search_type;

}