package com.skb.graphql.resolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsEnableDataFetcherInstrumentation;
import com.skb.graphql.entity.*;
import com.skb.graphql.entity.input.*;
import com.skb.graphql.exception.ApiBadResponseException;
import com.skb.graphql.service.EuxpApiService;
import com.skb.graphql.service.ScsApiService;
import com.skb.graphql.service.SmdApiService;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@DgsComponent
@Slf4j
public class SynopsisPageResolver {
	private final SmdApiService smdApiService;
	private final ScsApiService scsApiService;
	private final EuxpApiService euxpApiService;


	public SynopsisPageResolver(SmdApiService smdApiService, ScsApiService scsApiService, EuxpApiService euxpApiService) {
		this.smdApiService = smdApiService;
		this.scsApiService = scsApiService;
		this.euxpApiService = euxpApiService;
	}

	@DgsData(parentType = "Query", field = "synopsisPage")
	@DgsEnableDataFetcherInstrumentation(false)
	public ViewPage getSynopsisPage(SynopsisPageInput input) throws JsonProcessingException, UnsupportedEncodingException {
		String exup = euxpApiService.getEuxpViewPage(input);
		String smd = smdApiService.getSmdViewPage(input);
		String scs = scsApiService.getScsViewPage(input);

		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode exupNode = objectMapper.readTree(exup);
		JsonNode smdNode = objectMapper.readTree(smd);
		JsonNode scsNode = objectMapper.readTree(scs);

		ErrorApi.ErrorApiBuilder errorApiBuilder = ErrorApi.builder();

		if (exupNode.get("result") != null && !exupNode.get("result").asText().equals("0000")) {
			errorApiBuilder.exupError(ErrorApi.ExupError.builder()
					.reason(exupNode.get("reason").asText())
					.result(exupNode.get("result").asText())
					.build());

		}

		if (smdNode.get("result") != null && !smdNode.get("result").asText().equals("OK")) {
			errorApiBuilder.smdError(ErrorApi.SmdError.builder()
					.reason(smdNode.get("reason").asText())
					.result(smdNode.get("result").asText())
					.build());

		}

		if (scsNode.get("result") != null && !scsNode.get("result").asText().equals("0000")) {
			errorApiBuilder.scsError(ErrorApi.ScsError.builder()
					.reason(scsNode.get("reason").asText())
					.result(scsNode.get("result").asText())
					.build());
		}
		ErrorApi errorMessages = errorApiBuilder.build();


		if (errorMessages.getExupError() != null || errorMessages.getSmdError() != null || errorMessages.getScsError() != null) {
			throw new ApiBadResponseException(errorMessages);
		}


		JsonNode contentsNode = exupNode.get("contents");
		JsonNode purcharesNode = exupNode.get("purchares");

		JsonNode peopleNode = contentsNode.get("peoples");
		JsonNode siteReviewNode = contentsNode.get("site_review");
		JsonNode stillCutNode = contentsNode.get("stillCut");
		JsonNode aiInsideScenceNode = contentsNode.get("ai_inside_scence");
		JsonNode previewNode = contentsNode.get("preview");
		JsonNode cornerNode = contentsNode.get("corners");
		JsonNode specialNode = contentsNode.get("special");

		JsonNode prizeHistoryNode = siteReviewNode.get("prize_history");


		ViewPage viewPage = ViewPage.builder()
				.banners(ViewPage.VP_SynopsisBanner.builder()
						.textBanner(contentsNode.get("sris_evt_comt_exps_mthd_cd").asInt() == 10 ? ViewPage.VP_SynopsisTextBanner.builder()
								.text(contentsNode.get("sris_evt_comt_title").asText())
								.callTypeCode(contentsNode.get("sris_evt_comt_call_typ_cd").asText())
								.callUrl(contentsNode.get("sris_evt_comt_call_url").asText())
								.vasId(contentsNode.get("sris_evt_comt_call_objt_id").asText())
								.vasServiceId(contentsNode.get("sris_evt_vas_svc_id").asText())
								.build() : null)
						.imageBanner(contentsNode.get("sris_evt_comt_exps_mthd_cd").asInt() == 20 ? ViewPage.VP_SynopsisImageBanner.builder()
								.imagePath(contentsNode.get("sris_evt_comt_img_path").asText())
								.callTypeCode(contentsNode.get("sris_evt_comt_call_typ_cd").asText())
								.callUrl(contentsNode.get("sris_evt_comt_call_url").asText())
								.vasId(contentsNode.get("sris_evt_comt_call_objt_id").asText())
								.vasServiceId(contentsNode.get("sris_evt_vas_svc_id").asText())
								.build() : null)
						.plccBanner(contentsNode.get("sris_evt_comt_exps_mthd_cd").asInt() == 30 ? ViewPage.VP_SynopsisPlccBanner.builder()
								.imagePath(contentsNode.get("sris_evt_comt_img_path2").asText())
								.callTypeCode(contentsNode.get("sris_evt_comt_call_typ_cd2").asText())
								.callUrl(contentsNode.get("sris_evt_comt_call_url2").asText())
								.vasId(contentsNode.get("sris_evt_comt_call_objt_id2").asText())
								.vasServiceId(contentsNode.get("sris_evt_vas_svc_id2").asText())
								.build() : null)
						.build())
				.title(ViewPage.VP_ContentsTitle.builder()
						.textTitle(ViewPage.VP_ContentsTextTitle.builder()
								.text(contentsNode.get("title").asText())
								.build())
						.imageTitle(ViewPage.VP_ContentsImageTitle.builder()
								.isDark(contentsNode.get("dark_img_yn").asText().equals("Y"))
								.imagePath(contentsNode.get("title_img_path").asText())
								.build())
						.build())
				.comment(ViewPage.VP_ContentsComment.builder()
						.AIComment(contentsNode.get("ai_preview_comt").asText())
						.build())
				.details(ViewPage.VP_ContentsDetail.builder()
						.castInfos(StreamSupport.stream(peopleNode.spliterator(), false)
								.map(cast -> ViewPage.VP_Cast.builder()
										.birth(cast.get("brth_ymd").asText())
										.imagePath(cast.get("img_path").asText())
										.id(cast.get("prs_id").asText())
										.actorName(cast.get("prs_nm").asText())
										.castingName(cast.get("prs_plrl_nm").asText())
										.roleCode(cast.get("prs_role_cd").asText())
										.roleName(cast.get("prs_role_nm").asText())
										.build())
								.collect(Collectors.toList()))
						.prizeInfos(StreamSupport.stream(prizeHistoryNode.spliterator(), false)
								.map(prize -> ViewPage.VP_Prize.builder()
										.description(prize.get("prize_dts_cts").asText())
										.name(prize.get("awrdc_nm").asText())
										.year(prize.get("prize_yr").asInt())
										.build())
								.collect(Collectors.toList()))
						.summary(contentsNode.get("sris_snss_cts").asText())
						.build())
				.contentsAdditional(ViewPage.VP_ContentsAdditional.builder()
						.stillCut(StreamSupport.stream(stillCutNode.spliterator(), false)
								.map(stillCut -> ViewPage.VP_StillCut.builder()
										.imagePath(stillCut.get("img_path").asText())
										.build())
								.collect(Collectors.toList()))
						.similarContents(ViewPage.VP_SimilarContents.builder()
								.callId(contentsNode.get("cw_call_id_val").asText())
								.build())
						.build())
				.userPreference(ViewPage.VP_UserContentsPreference.builder()
						.likeInfo(ViewPage.VP_LikeInfo.builder()
								.likeTotal((smdNode != null && !smdNode.isNull() && smdNode.has("like_total")) ? smdNode.get("like_total").asInt() : null)
								.like(smdNode.get("like").asInt())
								.dislikeTotal(smdNode.get("dislike_total").asInt())
								.dislike(smdNode.get("dislike").asInt())
								.build())
						.bookmark(scsNode.get("is_bookmark").equals("Y"))
						.build())
				.purchaseInfo(ViewPage.VP_PurchaseInfo.builder()
						.products(StreamSupport.stream(purcharesNode.spliterator(), false)
								.map(product -> ViewPage.VP_Product.builder()
										.productTypeCode(product.get("prd_typ_cd").asText())
										.episodeId(product.get("epsd_id").asText())
										.episodeResolutionId(product.get("epsd_rslu_id").asText())
										.discountTypeCode(product.get("dsc_typ_cd").asText())
										.languageCaptionTypeCode(product.get("lag_capt_typ_cd").asText())
										.isNscreen(product.get("nscrn_yn").asText().equals("Y"))
										.isPossession(product.get("possn_yn").asText().equals("Y"))
										.isPpmFreeJoin(product.get("ppm_free_join_yn").asText().equals("Y"))
										.ppmGridIconImagePath(product.get("ppm_grid_icon_img_path").asText())
										.ppmProductName(product.get("ppm_prd_nm").asText())
										.productPriceId(product.get("prd_prc_id").asText())
										.productPriceVat(product.get("prd_prc_vat").asInt())
										.salePrice(product.get("sale_prc").asInt())
										.salePriceVat(product.get("sale_prc_vat").asInt())
										.purchasedWatchedCode(product.get("purc_wat_dd_fg_cd").asText())
										.purchasedWatchedCount(product.get("purc_wat_dd_cnt").asInt())
										.resolutionTypeCode(product.get("rslu_typ_cd").asText())
										.isUsed(product.get("use_yn").asText().equals("Y"))
										.isReservation(contentsNode.get("rsv_orgnz_yn").asText().equals("Y"))
										.build())
								.collect(Collectors.toList()))
						.build())
				.playInfo(ViewPage.VP_PlayInfo.builder()
						.mainPlay(ViewPage.VP_MainPlay.builder()
								.seriesId(contentsNode.get("sris_id").asText())
								.episodeId(contentsNode.get("epsd_id").asText())
								.build())
						.mainPreviewPlay(ViewPage.VP_MainPreviewPlay.builder()
								.seriesId(contentsNode.get("sris_id").asText())
								.episodeId(contentsNode.get("epsd_id").asText())
								.episodeResolutionId(contentsNode.get("epsd_rslu_info").asText())
								.build())
						.aiHighlightPlay(ViewPage.VP_AIHighlightPlay.builder()
								.seriesId(contentsNode.get("sris_id").asText())
								.episodeId(contentsNode.get("epsd_id").asText())
								.startTime((aiInsideScenceNode != null && !aiInsideScenceNode.isEmpty() && aiInsideScenceNode.get(0).has("tmtag_fr_tmsc")) ? aiInsideScenceNode.get(0).get("tmtag_fr_tmsc").asInt() : null)
								.previewTime(180)
								.build())
						.trailerPlay(ViewPage.VP_TrailerPlay.builder()
								.seriesId(contentsNode.get("sris_id").asText())
								.episodeId(contentsNode.get("epsd_id").asText())
								.productPriceId((previewNode != null && !previewNode.isEmpty() && previewNode.get(0).has("prd_prc_id")) ? previewNode.get(0).get("prd_prc_id").asText() : null)
								.build())
						.cornerPlays(StreamSupport.stream(cornerNode.spliterator(), false)
								.map(corner -> ViewPage.VP_CornerPlay.builder()
										.cornerBottomName(corner.get("cnr_btm_nm").asText())
										.cornerGroupName(corner.get("cnr_grp_id").asText())
										.cornerId(corner.get("cnr_id").asText())
										.cornerName(corner.get("cnr_nm").asText())
										.episodeResolutionId(corner.get("epsd_rslu_id").asText())
										.imagePath(corner.get("img_path").asText())
										.build())
								.collect(Collectors.toList()))
						.specialPlays(StreamSupport.stream(specialNode.spliterator(), false)
								.map(special -> ViewPage.VP_SpecialPlay.builder()
										.episodeId(special.get("epsd_id").asText())
										.episodeResolutionId(special.get("epsd_rslu_id").asText())
										.imagePath(special.get("img_path").asText())
										.productPriceId(special.get("prd_prc_id").asText())
										.title(special.get("title").asText())
										.build())
								.collect(Collectors.toList()))
						.build())
				.build();
		log.info("return viewPage");
		return viewPage;
	}
}