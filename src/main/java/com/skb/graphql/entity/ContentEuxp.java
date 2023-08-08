package com.skb.graphql.entity;

import java.util.List;

public record ContentEuxp(
		String result,
		String reason,
		String request_time,
		Content contents,
		List<Purchase> purchares,
		List<Series> series,
		List<Banner> banners,
		Float total_banner_count,
		String response_time,
		String IF
) {
}

record Content(
		String title_img_path,
		String next_sris_id,
		String sris_sales_vas_svc_id,
		String brcast_chnl_nm,
		String epsd_id,
		String orgn_epsd_id,
		String sris_poster_filename_v,
		String mob_mda_file_path,
		String seeking_img_path,
		String audio_lag_typ_cd,
		List<AiInsideScene> ai_inside_scenes,
		List<AllAiInsideScenes> all_ai_inside_scenes,
		List<EpsdRsluInfo> epsd_rslu_info,
		String epsd_snss_cts,
		String sris_sales_comt_cts,
		String aprc_pt_cts,
		String wat_lvl_cd,
		String sris_sales_comt_call_url,
		List<People> peoples,
		String open_yr,
		String epsd_evt_comt_call_url,
		String sris_poster_filename_h,
		String brcast_tseq_nm,
		String epsd_sales_vas_svc_id,
		String sris_id,
		String sris_typ_cd,
		String svc_typ_cd,
		String epsd_sales_comt_cts,
		String director,
		String epsd_sales_comt_call_typ_cd,
		String epsd_evt_vas_itm_id,
		String aprc_pt_cts_colr_val,
		String sris_sales_comt_call_typ_cd,
		String sris_evt_comt_call_objt_id,
		String sris_sales_comt_call_objt_id,
		String cacbro_cts,
		String sris_evt_comt_cts,
		List<StillCut> stillCut,
		String snd_typ_cd,
		String epsd_sales_comt_exps_mthd_cd,
		String next_epsd_id,
		String play_tms_val,
		String play_time,
		String sris_sales_comt_exps_mthd_cd,
		String sris_sales_comt_title,
		String mob_sris_sales_comt_title,
		String mob_sris_sales_comt_cts,
		String mob_sris_sales_comt_exps_mthd_cd,
		List<Genre> genres,
		String rslu_typ_cd,
		String epsd_evt_comt_cts,
		SiteReview site_review,
		String kids_yn,
		String guest,
		String sris_evt_comt_call_typ_cd,
		String mtx_capt_yn,
		String epsd_sales_comt_img_path,
		String cacbro_yn,
		String cacbro_cd,
		List<Preview> preview,
		String sris_evt_comt_exps_mthd_cd,
		String sris_evt_comt_title,
		String sris_sales_comt_img_path,
		String mob_sris_evt_comt_title,
		String mob_sris_evt_comt_cts,
		String mob_sris_evt_comt_exps_mthd_cd,
		String mob_sris_evt_comt_scn_mthd_cd,
		String mob_sris_evt_comt_img_path,
		String mob_sris_evt_comt_call_typ_cd,
		String mob_sris_evt_comt_call_url,
		String mob_sris_evt_comt_call_objt_id,
		String mob_sris_evt_comt_img_bagr_colr_val,
		String bg_img_path,
		String title,
		String epsd_evt_comt_img_path,
		String sris_evt_vas_svc_id,
		String chrtr,
		String tpcc_comt,
		String sris_evt_comt_scn_mthd_cd,
		String sris_sales_comt_scn_mthd_cd,
		String epsd_evt_comt_scn_mthd_cd,
		String epsd_sales_comt_scn_mthd_cd,
		String lag_capt_typ_exps_yn,
		String brcast_avl_perd_yn,
		List<Product> products,
		String epsd_sales_comt_call_objt_id,
		List<Corners> corners,
		String prev_sris_id,
		String epsd_sales_comt_title,
		String epsd_evt_comt_title,
		String epsd_sales_comt_call_url,
		String meta_title_colr_val,
		String brcast_dy,
		String adlt_lvl_cd,
		String epsd_poster_filename_h,
		String sris_evt_comt_call_url,
		String epsd_evt_comt_call_typ_cd,
		String epsd_evt_vas_svc_id,
		String epsd_evt_comt_call_objt_id,
		String mob_epsd_sales_comt_title,
		String mob_epsd_sales_comt_cts,
		String mob_epsd_sales_comt_exps_mthd_cd,
		String meta_typ_cd,
		String thtr_ver_yn,
		String btv_pplr_yn,
		String sub_title,
		String brcast_exps_dy,
		String sris_evt_vas_itm_id,
		String epsd_poster_filename_v,
		String sris_sales_vas_itm_id,
		String sris_evt_comt_title2,
		String sris_evt_comt_cts2,
		String sris_evt_comt_exps_mthd_cd2,
		String sris_evt_comt_img_path2,
		String sris_evt_comt_call_typ_cd2,
		String sris_evt_comt_call_url2,
		String mob_epsd_evt_comt_title,
		String mob_epsd_evt_comt_cts,
		String mob_epsd_evt_comt_exps_mthd_cd,
		String mob_epsd_evt_comt_scn_mthd_cd,
		String mob_epsd_evt_comt_img_path,
		String mob_epsd_evt_comt_call_typ_cd,
		String mob_epsd_evt_comt_call_url,
		String mob_epsd_evt_comt_call_objt_id,
		String mob_epsd_evt_comt_img_bagr_colr_val,
		String rcmd_yn,
		String nscrn_yn,
		String prev_epsd_id,
		String sris_snss_cts,
		String actor,
		String epsd_evt_comt_exps_mthd_cd,
		List<Special> special,
		String epsd_sales_vas_itm_id,
		String sris_evt_comt_img_path,
		String sson_choic_nm,
		List<SeriesInfo> series_info,
		List<PossBgImg> poss_bg_img,
		String dark_img_yn,
		String vc_bg_img_path,
		String vc_dark_img_yn,
		String combine_product_yn,
		String session_id,
		String cw_call_id,
		String track_id,
		String cw_call_id_val,
		String pcim_dimn_cd,
		String svc_ft_dt,
		String svc_to_dt,
		String gstn_yn,
		String dist_sts_cd,
		String epsd_dist_sts_cd,
		String has_inside_meta,
		String menu_id,
		String ending_cw_call_id_val,
		String sris_cmpt_yn,
		String meta_sub_typ_cd,
		String chrtr_ai_typ_cd,
		String first_sris_id,
		String last_sris_id,
		String has_scene_meta,
		String pre_exam_yn,
		String trailer_view_yn,
		String quiz_yn,
		String quiz_call_url,
		String epsd_exps_typ_cd,
		String pblsr_nm,
		String vod_svc_yn,
		String rsv_orgnz_yn,
		String smtn_wat_abl_yn,
		String contrp_id,
		String ocean_prd_prc_fr_dt,
		String ocean_prd_prc_to_dt,
		String playz_prd_prc_fr_dt,
		String playz_prd_prc_to_dt,
		Float pcim_fr_tmsc,
		String pcim_lvl_exps_yn,
		String pcim_lvl_cls_no,
		String pcim_lvl_cls_dy,
		String pcim_lvl1_exps_yn,
		String pcim_lvl2_exps_yn,
		String pcim_lvl3_exps_yn,
		String pcim_lvl4_exps_yn,
		String pcim_lvl5_exps_yn,
		String pcim_lvl6_exps_yn,
		String pcim_lvl7_exps_yn,
		String pcim_lvl1_wat_age_cd,
		String pcim_lvl2_wat_age_cd,
		String pcim_lvl3_wat_age_cd,
		String pcim_lvl4_wat_age_cd,
		String pcim_lvl5_wat_age_cd,
		String pcim_lvl6_wat_age_cd,
		String pcim_lvl7_wat_age_cd,
		String mob_mda_capt_yn,
		String wat_lvl_phrs,
		String manufco_nm,
		List<Ott> otts
) {
}

record AiInsideScene(
		String scene_id,
		String scne_title,
		Float tmtag_to_tmsc,
		Float scne_dts_seq,
		Float tmtag_fr_tmsc,
		String scne_typ_code,
		String img_path,
		String img_file_nm,
		String tag_val,
		Float scne_rank
) {
}

record AllAiInsideScenes(
		String epsd_id,
		List<Scene> scenes
) {
}

record Scene(
		String scene_id,
		String scne_title,
		Float tmtag_to_tmsc,
		Float scne_dts_seq,
		Float tmtag_fr_tmsc,
		String scne_typ_code,
		String img_path,
		String img_file_nm,
		String tag_val,
		Float scne_rank
) {
}

record EpsdRsluInfo(
		String epsd_rslu_id,
		String rslu_typ_cd,
		String lag_capt_typ_cd,
		String pcim_addn_typ_cd,
		String possn_yn,
		Float openg_tmtag_tmsc,
		Float endg_tmtag_tmsc,
		String capt_yn,
		String capt_svc_file_path,
		String mtx_capt_yn,
		String mtx_capt_svc_file_path,
		String ai_capt_yn,
		String ai_capt_svc_file_path,
		String preview_time,
		String rtsp_cnt_url,
		String mda_file_path,
		String prd_prc_fr_dt,
		String prd_prc_to_dt,
		String matl_sts_cd,
		String encd_piqu_typ_cd,
		List<CaptLans> capt_lans
) {
}

record CaptLans(
		String capt_lag_fg_cd,
		String mtx_capt_bas_yn
) {
}


record People(
		String prs_id,
		String img_path,
		String prs_nm,
		String prs_role_nm,
		String prs_plrl_nm,
		String brth_ymd,
		Float sort_seq,
		String prs_role_cd
) {
}

record StillCut(
		String img_path
) {
}

record Genre(
		String gnr_id,
		String meta_gnr_nm,
		String req_gnr_yn
) {
}

record SiteReview(
		String sris_id,
		TmdbPntInfo tmdb_pnt_info,
		List<Site> sites,
		List<BtvPntInfo> btv_pnt_info,
		List<PrizeHistory> prize_history
) {
}

record TmdbPntInfo(
		Float tmdb_pnt,
		Float tmdb_pnt_user_ncnt
) {
}

record Site(
		Float bas_pnt,
		String site_cd,
		Float review_cnt,
		List<Review> reviews,
		List<DistInfo> dist_info,
		Float avg_pnt,
		String site_nm
) {
}

record Review(
		String prs_nm,
		Float pnt,
		String review_ctsc
) {
}

record DistInfo(
		Float pnt,
		Float dist_rate
) {
}

record BtvPntInfo(
		Float btv_like_ncnt,
		Float btv_like_rate,
		Float btv_ngood_ncnt,
		Float btv_ngood_rate,
		Float btv_pnt
) {
}

record PrizeHistory(
		String awrdc_nm,
		String prize_yr,
		String prize_dts_cts,
		String rep_yn
) {
}

record Preview(
		String prd_prc_id,
		String pcim_addn_typ_nm,
		String epsd_id,
		String epsd_rslu_id,
		String img_path,
		String title,
		String play_tms_val,
		String rtsp_cnt_url
) {
}

record Product(
		String epsd_id,
		String epsd_rslu_id,
		String rslu_typ_cd,
		String prd_typ_cd,
		String asis_prd_typ_cd,
		String prd_prc_id,
		Float prd_prc,
		Float prd_prc_vat,
		Float sale_prc,
		Float sale_prc_vat,
		String ppm_orgnz_fr_dt,
		String ppm_orgnz_to_dt,
		String svc_to_dt,
		String prd_prc_fr_dt,
		String prd_prc_to_dt,
		String expire_prd_prc_dt,
		String purc_wat_to_dt,
		String next_prd_prc_fr_dt,
		String next_free_prd_prc_fr_dt,
		String next_prd_prc_typ_cd,
		Float next_sale_prc_vat,
		String nscrn_yn,
		String possn_yn,
		String purc_pref_rank,
		String use_yn,
		String brcast_avl_perd_yn,
		String purc_wat_dd_fg_cd,
		Float purc_wat_dd_cnt,
		List<String> poc_det_typ_cd_list,
		String sale_tgt_fg_yn
) {
}

record Corners(
		String cnr_id,
		String cnr_nm,
		String epsd_rslu_id,
		String img_path,
		String wat_fr_byte_val,
		Float tmtag_fr_tmsc,
		Float sort_seq,
		String cnr_grp_id,
		String cnr_btm_nm,
		String cnr_typ_cd
) {
}

record Special(
		String prd_prc_id,
		String pcim_addn_typ_nm,
		String epsd_rslu_id,
		String img_path,
		String title,
		String play_tms_val,
		String rtsp_cnt_url
) {
}

record SeriesInfo(
		String poster_filename_h,
		String poster_filename_v,
		String epsd_id,
		String brcast_tseq_nm,
		String cacbro_yn,
		String svc_fr_dt,
		String svc_to_dt,
		String dist_sts_cd,
		String sub_title,
		String brcast_exps_dy,
		String play_tms_val,
		Float sort_seq,
		Float sale_prc_vat,
		String brcast_avl_perd_yn,
		String prd_prc_to_dt,
		String next_prd_prc_fr_dt,
		String next_free_prd_prc_fr_dt,
		String next_prd_prc_typ_cd,
		Float next_sale_prc_vat,
		String expire_prd_prc_dt
) {
}

record PossBgImg(
		String img_path
) {
}

record Ott(
		String ott_typ_cd,
		String ott_id,
		List<OttProduct> ott_products
) {
}

record OttProduct(
		String ott_prd_typ_cd,
		Float ott_sale_prc
) {
}

record Purchase(
		String prd_prc_id,
		String prd_typ_cd,
		String asis_prd_typ_cd,
		String dsc_typ_cd,
		Float sale_prc,
		String use_yn,
		String epsd_id,
		String ppm_orgnz_fr_dt,
		String purc_wat_to_dt,
		String nscrn_yn,
		String prd_prc_to_dt,
		String expire_prd_prc_dt,
		Float sale_prc_vat,
		Float prd_prc,
		String epsd_rslu_id,
		String rslu_typ_cd,
		String possn_yn,
		String prd_prc_fr_dt,
		String ppm_orgnz_to_dt,
		String purc_pref_rank,
		String next_prd_prc_fr_dt,
		String next_free_prd_prc_fr_dt,
		String next_prd_prc_typ_cd,
		Float next_sale_prc_vat,
		String lag_capt_typ_cd,
		Float prd_prc_vat,
		String sris_id,
		String lag_capt_typ_exps_yn,
		String brcast_avl_perd_yn,
		String purc_wat_dd_fg_cd,
		Float purc_wat_dd_cnt,
		List<String> poc_det_typ_cd_list,
		String sale_tgt_fg_yn,
		String ppm_free_join_yn,
		String ppm_free_join_perd_cd
) {
}

record Series(
		String sris_id,
		String sson_choic_nm,
		String epsd_id,
		String sort_seq
) {
}

record Banner(
		String menu_nm,
		String scn_mthd_cd,
		String lim_lvl_yn,
		String bnr_on_img_path,
		String bnr_off_img_path,
		String vas_svc_id,
		String vas_itm_id,
		String vas_id,
		String bnr_det_typ_cd,
		String call_typ_cd,
		String call_url,
		String cw_call_id_val,
		String synon_typ_cd,
		String cnts_typ_cd,
		String shcut_sris_id,
		String shcut_epsd_id,
		String shcut_menu_id,
		String bnr_expl,
		String exps_rslu_cd,
		String bnr_epsd_rslu_id,
		String epsd_id,
		String bnr_typ_cd,
		String prd_prc_id,
		String prd_typ_cd,
		String asis_prd_typ_cd,
		Float sale_prc,
		Float sale_prc_vat,
		Float prd_prc,
		Float prd_prc_vat,
		String is_compound_prd
) {
}