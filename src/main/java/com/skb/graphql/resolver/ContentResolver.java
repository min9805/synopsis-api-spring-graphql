package com.skb.graphql.resolver;

import com.netflix.graphql.dgs.DgsQuery;
import com.skb.graphql.entity.ContentScs;
import com.skb.graphql.entity.ContentScsInput;
import com.skb.graphql.entity.ContentSmdInput;
import com.skb.graphql.entity.ContentSmd;
import com.skb.graphql.service.ScsApiService;
import com.skb.graphql.service.SmdApiService;
import org.springframework.stereotype.Component;

@Component
public class ContentResolver {
	private final SmdApiService apiService;
	private final ScsApiService scsApiService;

	public ContentResolver(SmdApiService apiService, ScsApiService scsApiService) {
		this.apiService = apiService;
		this.scsApiService = scsApiService;
	}

	@DgsQuery
	public ContentSmd getContentSmd(ContentSmdInput input) {
		return apiService.getContentSmd(input);
	}

	@DgsQuery
	public ContentScs getContentScs(ContentScsInput input) {
		return scsApiService.getContentScs(input);
	}
}