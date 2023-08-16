package com.skb.graphql.resolver;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.skb.graphql.entity.*;
import com.skb.graphql.entity.input.*;
import com.skb.graphql.service.EuxpApiService;
import com.skb.graphql.service.ScsApiService;
import com.skb.graphql.service.SmdApiService;
import graphql.schema.DataFetchingEnvironment;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@DgsComponent
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
	public ViewPage getSynopsisPage(SynopsisPageInput input) throws JsonProcessingException {
		String exup = euxpApiService.getEuxpViewPage(input);
		String smd = smdApiService.getSmdViewPage(input);

		ObjectMapper objectMapper = new ObjectMapper();

		JsonNode jsonNode = objectMapper.readTree(exup);

		JsonNode contentsNode = jsonNode.get("contents");

		JsonNode peopleNode = contentsNode.get("peoples");
		JsonNode siteReviewNode = contentsNode.get("site_review");
		JsonNode stillCutNode = contentsNode.get("stillCut");

		JsonNode prizeHistoryNode = siteReviewNode.get("prize_history");


		ViewPage viewPage = new ViewPage();

		ViewPage.VP_SynopsisBanner vp_synopsisBanner = new ViewPage.VP_SynopsisBanner();
		ViewPage.VP_ContentsTitle vp_contentsTitle = new ViewPage.VP_ContentsTitle();
		ViewPage.VP_ContentsComment vp_contentsComment = new ViewPage.VP_ContentsComment();
		ViewPage.VP_ContentsDetail vp_contentsDetail = new ViewPage.VP_ContentsDetail();
		ViewPage.VP_ContentsAdditional vp_contentsAdditional = new ViewPage.VP_ContentsAdditional();
		ViewPage.VP_UserContentsPreference vp_userContentsPreference = new ViewPage.VP_UserContentsPreference();
		ViewPage.VP_ContentsEpisodeList vp_contentsEpisodeList = new ViewPage.VP_ContentsEpisodeList();
		ViewPage.VP_PurchaseInfo vp_purchaseInfo = new ViewPage.VP_PurchaseInfo();
		ViewPage.VP_PlayInfo vp_playInfo = new ViewPage.VP_PlayInfo();

		ViewPage.VP_SynopsisImageBanner vp_synopsisImageBanner = new ViewPage.VP_SynopsisImageBanner();
		ViewPage.VP_SynopsisTextBanner vp_synopsisTextBanner = new ViewPage.VP_SynopsisTextBanner();
		ViewPage.VP_SynopsisPlccBanner vp_synopsisPlccBanner = new ViewPage.VP_SynopsisPlccBanner();
		ViewPage.VP_ContentsTextTitle vp_contentsTextTitle = new ViewPage.VP_ContentsTextTitle();
		ViewPage.VP_ContentsImageTitle vp_contentsImageTitle = new ViewPage.VP_ContentsImageTitle();
		ViewPage.VP_Cast[] vp_casts = new ViewPage.VP_Cast[peopleNode.size()];
		ViewPage.VP_Prize[] vp_prizes = new ViewPage.VP_Prize[prizeHistoryNode.size()];
		ViewPage.VP_StillCut[] vp_stillCuts = new ViewPage.VP_StillCut[stillCutNode.size()];
		ViewPage.VP_SimilarContents vp_similarContents = new ViewPage.VP_SimilarContents();

		vp_synopsisImageBanner.setImagePath(Optional.ofNullable(contentsNode.get("sris_evt_comt_img_path")).map(JsonNode::asText).orElse(null));
		vp_synopsisImageBanner.setCallTypeCode(Optional.ofNullable(contentsNode.get("sris_evt_comt_call_typ_cd")).map(JsonNode::asText).orElse(null));
		vp_synopsisImageBanner.setCallUrl(Optional.ofNullable(contentsNode.get("sris_evt_comt_call_url")).map(JsonNode::asText).orElse(null));
		vp_synopsisImageBanner.setVasId(Optional.ofNullable(contentsNode.get("sris_evt_comt_call_objt_id")).map(JsonNode::asText).orElse(null));
		vp_synopsisImageBanner.setVasServiceId(Optional.ofNullable(contentsNode.get("sris_evt_vas_svc_id")).map(JsonNode::asText).orElse(null));

		vp_synopsisTextBanner.setText(Optional.ofNullable(contentsNode.get("sris_evt_comt_title")).map(JsonNode::asText).orElse(null));
		vp_synopsisTextBanner.setCallTypeCode(Optional.ofNullable(contentsNode.get("sris_evt_comt_call_typ_cd")).map(JsonNode::asText).orElse(null));
		vp_synopsisTextBanner.setCallUrl(Optional.ofNullable(contentsNode.get("sris_evt_comt_call_url")).map(JsonNode::asText).orElse(null));
		vp_synopsisTextBanner.setVasId(Optional.ofNullable(contentsNode.get("sris_evt_comt_call_objt_id")).map(JsonNode::asText).orElse(null));
		vp_synopsisTextBanner.setVasServiceId(Optional.ofNullable(contentsNode.get("sris_evt_vas_svc_id")).map(JsonNode::asText).orElse(null));

		vp_synopsisPlccBanner.setImagePath(Optional.ofNullable(contentsNode.get("sris_evt_comt_img_path2")).map(JsonNode::asText).orElse(null));
		vp_synopsisPlccBanner.setCallTypeCode(Optional.ofNullable(contentsNode.get("sris_evt_comt_call_typ_cd2")).map(JsonNode::asText).orElse(null));
		vp_synopsisPlccBanner.setCallUrl(Optional.ofNullable(contentsNode.get("sris_evt_comt_call_url2")).map(JsonNode::asText).orElse(null));
		vp_synopsisPlccBanner.setVasId(Optional.ofNullable(contentsNode.get("sris_evt_comt_call_objt_id2")).map(JsonNode::asText).orElse(null));
		vp_synopsisPlccBanner.setVasServiceId(Optional.ofNullable(contentsNode.get("sris_evt_vas_svc_id2")).map(JsonNode::asText).orElse(null));

		vp_contentsImageTitle.setImagePath(contentsNode.get("title_img_path").asText());
		vp_contentsImageTitle.setIsDark(contentsNode.get("dark_img_yn").asText().equals("Y"));

		vp_contentsTextTitle.setText(contentsNode.get("title").asText());

		vp_contentsDetail.setSummary(contentsNode.get("sris_snss_cts").asText());

		for (int i = 0; i < peopleNode.size(); i++) {
			ViewPage.VP_Cast vp_cast = new ViewPage.VP_Cast();

			vp_cast.setBirth(Optional.ofNullable(peopleNode.get(i).get("brth_ymd")).map(JsonNode::asText).orElse(null));
			vp_cast.setImagePath(Optional.ofNullable(peopleNode.get(i).get("img_path")).map(JsonNode::asText).orElse(null));
			vp_cast.setId(Optional.ofNullable(peopleNode.get(i).get("prs_id")).map(JsonNode::asText).orElse(null));
			vp_cast.setActorName(Optional.ofNullable(peopleNode.get(i).get("prs_nm")).map(JsonNode::asText).orElse(null));
			vp_cast.setCastingName(Optional.ofNullable(peopleNode.get(i).get("prs_plrl_nm")).map(JsonNode::asText).orElse(null));
			vp_cast.setRoleCode(Optional.ofNullable(peopleNode.get(i).get("prs_role_cd")).map(JsonNode::asText).orElse(null));
			vp_cast.setRoleName(Optional.ofNullable(peopleNode.get(i).get("prs_role_nm")).map(JsonNode::asText).orElse(null));

			vp_casts[i] = vp_cast;
		}

		for (int i = 0; i < prizeHistoryNode.size(); i++) {
			ViewPage.VP_Prize vp_prize = new ViewPage.VP_Prize();

			vp_prize.setName(Optional.ofNullable(prizeHistoryNode.get(i).get("awrdc_nm")).map(JsonNode::asText).orElse(null));
			vp_prize.setDescription(Optional.ofNullable(prizeHistoryNode.get(i).get("prize_dts_cts")).map(JsonNode::asText).orElse(null));
			vp_prize.setYear(Optional.ofNullable(prizeHistoryNode.get(i).get("prize_yr")).map(JsonNode::asInt).orElse(null));

			vp_prizes[i] = vp_prize;
		}

		for (int i = 0; i < stillCutNode.size(); i++) {
			ViewPage.VP_StillCut vp_stillCut = new ViewPage.VP_StillCut();

			vp_stillCut.setImagePath(Optional.ofNullable(stillCutNode.get(i).get("img_path")).map(JsonNode::asText).orElse(null));

			vp_stillCuts[i] = vp_stillCut;
		}

		vp_similarContents.setCallId(Optional.ofNullable(stillCutNode.get("cw_call_id_val")).map(JsonNode::asText).orElse(null));

		vp_contentsTitle.setTextTitle(vp_contentsTextTitle);
		vp_contentsTitle.setImageTitle(vp_contentsImageTitle);
		vp_contentsDetail.setCastInfos(List.of(vp_casts));
		vp_contentsDetail.setPrizeInfos(List.of(vp_prizes));
		vp_contentsAdditional.setStillCut(List.of(vp_stillCuts));
		vp_contentsAdditional.setSimilarContents(vp_similarContents);

		viewPage.setTitle(vp_contentsTitle);
		viewPage.setDetails(vp_contentsDetail);
		viewPage.setContentsAdditional(vp_contentsAdditional);

		return viewPage;
	}
}