package com.skb.graphql.entity;

import java.util.List;

public record ContentScs(
		String IF,
		String ver,
		String ui_name,
		String svc_name,
		String result,
		String reason,
		String stb_id,
		String mobile_id,
		String is_bookmark,
		String yn_season_watch_all,
		List<PpvProduct> ppv_products,
		List<PpvProduct> pps_products,
		LastWatchInfo last_watch_info
) {}
 record PpvProduct(
		String prd_prc_id,
		String epsd_id,
		String yn_directview,
		String yn_purchase,
		String end_date,
		String end_date_hhmm,
		String period,
		String period_hour,
		String period_min,
		String yn_recv_gift,
		String recv_gift_sts_cd,
		String ppm_free_join_yn,
		String ppm_free_join_perd_cd,
		String ppm_free_join_perd_end_dt,
		List<OmniPpmInfo> use_ppv_omni_ppm_info
) {}

 record OmniPpmInfo(
		String omni_m_pid,
		String omni_m_pname,
		String omni_m_total_count,
		String omni_m_use_count,
		String omni_m_rest_count,
		String omni_m_rest_count_valid_date
) {}

 record LastWatchInfo(
		String sris_id,
		String epsd_id,
		String epsd_rslu_id,
		String trans_type,
		String watch_rt,
		String watch_time
) {}