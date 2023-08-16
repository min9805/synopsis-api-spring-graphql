package com.skb.graphql.entity.input;

import lombok.Data;

import java.util.List;

@Data
public class SynopsisPageInput {
	private String stbId;
	private String mac;
	private String hashId;
	private String menuStbServiceId;
	private Boolean isInspect;
	private String subscriberTypeCode;
	private String env;
	private String synopsisSearchType;
	private String seriesId;
	private String episodeId;
	private String lookupType;
	private String menuId;
	private String xImpressionType;
	private String profileId;
	private String profileTypeCode;
	private String deviceTypeCode;
	private String synopsisType;
	private String uiName;
	private String appTypeCode;
	private Boolean includeOmniPPM;
	private Boolean includePpmFreeJoin;
	private List<PpsProductInput> ppsProducts;
	private List<PpvProductInput> ppvProducts;

	@Data
	static class PpvProductInput {
		private String prd_prc_id;
		private String yn_prd_nscreen;
		private String prd_typ_cd;
		private String purc_pref_rank;
		private String possn_yn;
		private String epsd_id;
	}

	@Data
	static class PpsProductInput {
		private String prd_prc_id;
		private String yn_prd_nscreen;
		private String prd_typ_cd;
		private String purc_pref_rank;
		private String possn_yn;
	}
}