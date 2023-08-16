package com.skb.graphql.entity.input;

import lombok.Data;

import java.util.List;

@Data
public class ContentScsInput {
	private String response_format;
	private String ver;
	private String stb_id;
	private String hash_id;
	private String ui_name;
	private String sris_id;
	private String synopsis_type;
	private List<PpvProduct> ppv_products;

	@Data
	static class PpvProduct {
		private String prd_prc_id;
		private String yn_prd_nscreen;
		private String prd_typ_cd;
		private String purc_pref_rank;
		private String possn_yn;
		private String epsd_id;
	}
}