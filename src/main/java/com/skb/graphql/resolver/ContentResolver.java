package com.skb.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.skb.graphql.entity.*;
import com.skb.graphql.service.EuxpApiService;
import com.skb.graphql.service.ScsApiService;
import com.skb.graphql.service.SmdApiService;
import org.springframework.stereotype.Component;

@DgsComponent
public class ContentResolver {
	private final SmdApiService apiService;
	private final ScsApiService scsApiService;
	private final EuxpApiService euxpApiService;


	public ContentResolver(SmdApiService apiService, ScsApiService scsApiService, EuxpApiService euxpApiService) {
		this.apiService = apiService;
		this.scsApiService = scsApiService;
		this.euxpApiService = euxpApiService;
	}

	@DgsQuery
	public ContentSmd SMD(ContentSmdInput input) {
		return apiService.getContentSmd(input);
	}

	@DgsQuery
	public ContentScs SCS(ContentScsInput input) {
		return scsApiService.getContentScs(input);
	}

	@DgsQuery
	public ContentEuxp EUXP(ContentEuxpInput input) {
		return euxpApiService.getContentEuxp(input);
	}
}