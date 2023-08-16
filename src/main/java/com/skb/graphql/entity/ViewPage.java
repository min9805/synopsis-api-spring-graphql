package com.skb.graphql.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

enum VP_SynopsisType {
	SHORTS,
	SEASON
}

@Data
public class ViewPage {
	VP_SynopsisType type;
	VP_SynopsisBanner banners;
	VP_ContentsTitle title;
	VP_ContentsComment comment;
	VP_ContentsDetail details;
	VP_ContentsAdditional contentsAdditional;
	VP_UserContentsPreference userPreference;
	VP_ContentsEpisodeList episodeList;
	VP_PurchaseInfo purchaseInfo;
	VP_PlayInfo playInfo;

	@Data
	public static class VP_ContentsTitle {
		private VP_ContentsImageTitle imageTitle;

		private VP_ContentsTextTitle textTitle;

		private String title;
	}

	@Data
	public static class VP_ContentsTextTitle {
		private String text;
	}

	@Data
	public static class VP_ContentsImageTitle {
		private Boolean isDark;
		private String imagePath;
	}

	@Data
	public static class VP_SynopsisBanner {
		private VP_SynopsisImageBanner imageBanner;
		private VP_SynopsisTextBanner textBanner;
		private VP_SynopsisPlccBanner plccBanner;
	}

	@Data
	public static class VP_ContentsComment {
		private String comment;
		private String AIComment;
	}

	@Data
	public static class VP_ContentsDetail {
		private String summary;
		private List<VP_Cast> castInfos;
		private List<VP_Prize> prizeInfos;
	}

	@Data
	public static class VP_ContentsAdditional {
		private List<VP_StillCut> stillCut;
		private VP_SimilarContents similarContents;
	}

	@Data
	public static class VP_UserContentsPreference {
		private Boolean bookmark;
	}

	@Data
	public static class VP_ContentsEpisodeList {
		private List<VP_ContentsEpisode> list;
	}

	@Data
	public static class VP_PurchaseInfo {
		private List<VP_Product_test> products;
	}

	@Data
	public static class VP_PlayInfo {
		private VP_MainPlay mainPlay;
		private VP_MainPreviewPlay mainPreviewPlay;
		private VP_AIHighlightPlay aiHighlightPlay;
		private VP_TrailerPlay trailerPlay;
		private List<VP_CornerPlay> cornerPlays;
		private List<VP_SpecialPlay> specialPlays;
	}

	@Data
	public static class VP_SynopsisImageBanner {
		private String imagePath;
		private String callTypeCode;
		private String callUrl;
		private String vasId;
		private String vasServiceId;
	}

	@Data
	public static class VP_SynopsisTextBanner {
		private String text;
		private String callTypeCode;
		private String callUrl;
		private String vasId;
		private String vasServiceId;
	}

	@Data
	public static class VP_SynopsisPlccBanner {
		private String imagePath;
		private String callTypeCode;
		private String callUrl;
		private String vasId;
		private String vasServiceId;
	}

	@Data
	public static class VP_Cast {
		private String birth;
		private String imagePath;
		private String id;
		private String actorName;
		private String castingName;
		private String roleCode;
		private String roleName;
	}

	@Data
	public static class VP_Prize {
		private String name;
		private String description;
		private Integer year;
	}

	@Data
	public static class VP_StillCut {
		private String imagePath;
	}

	@Data
	public static class VP_SimilarContents {
		private String callId;
	}

	@Data
	public static class VP_ContentsEpisode {
		private String imagePath;
		private Integer episodeNumber;
		private String watchedProgress;
		private String isNotBroadcasted;
	}

	@Data
	public static class VP_Product_test {
		private String productTypeCode;
		private String episodeId;
		private String episodeResolutionId;
		private String discountTypeCode;
		private String languageCaptionTypeCode;
		private Boolean isNscreen;
		private Boolean isPossession;
		private Boolean isPpmFreeJoin;
		private String ppmGridIconImagePath;
		private String ppmProductName;
		private String productPriceId;
		private Integer productPriceVat;
		private Integer salePrice;
		private Integer salePriceVat;
		private String purchasePreferenceRank;
		private String purchasedWatchedCount;
		private String resolutionTypeCode;
		private Boolean isUsed;
		private Boolean isReservation;
	}

	@Data
	public static class VP_MainPlay {
		private String episodeId;
		private String seriesId;
	}

	@Data
	public static class VP_MainPreviewPlay {
		private String episodeId;
		private String seriesId;
		private String episodeResolutionId;
		private Integer startTime;
		private Integer previewTime;
		private Integer totalTime;
	}

	@Data
	public static class VP_AIHighlightPlay {
		private String episodeId;
		private String seriesId;
		private Integer startTime;
		private Integer previewTime;
	}

	@Data
	public static class VP_TrailerPlay {
		private String episode_id;
		private String seriesId;
		private String productPriceId;
	}

	@Data
	public static class VP_CornerPlay {
		private String cornerBottomName;
		private String cornerGroupName;
		private String cornerId;
		private String cornerName;
		private String episodeResolutionId;
		private String imagePath;
	}

	@Data
	public static class VP_SpecialPlay {
		private String episodeId;
		private String episodeResolutionId;
		private String imagePath;
		private String productPriceId;
	}
}