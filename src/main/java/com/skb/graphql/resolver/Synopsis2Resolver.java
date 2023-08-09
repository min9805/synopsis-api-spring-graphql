package com.skb.graphql.resolver;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.skb.graphql.entity.*;
import com.skb.graphql.service.EuxpApiService;
import com.skb.graphql.service.ScsApiService;
import com.skb.graphql.service.SmdApiService;
import graphql.schema.DataFetchingEnvironment;

import java.io.UnsupportedEncodingException;

@DgsComponent
public class Synopsis2Resolver {
	private final SmdApiService smdApiService;
	private final ScsApiService scsApiService;
	private final EuxpApiService euxpApiService;


	public Synopsis2Resolver(SmdApiService smdApiService, ScsApiService scsApiService, EuxpApiService euxpApiService) {
		this.smdApiService = smdApiService;
		this.scsApiService = scsApiService;
		this.euxpApiService = euxpApiService;
	}

	@DgsData(parentType = "SynopsisContent2", field = "SMD")
	public ContentSmd getSMD(ContentSmdInput input, DataFetchingEnvironment environment) {
		Synopsis synopsis = environment.getSource();
		SynopsisInput synopsisInput = synopsis.getInput();
		return smdApiService.getContentSmd2(input, synopsisInput);
	}

	@DgsData(parentType = "SynopsisContent2", field = "SCS")
	public ContentScs getSCS(ContentScsInput input, DataFetchingEnvironment environment) throws UnsupportedEncodingException {
		Synopsis synopsis = environment.getSource();
		SynopsisInput synopsisInput = synopsis.getInput();
		return scsApiService.getContentScs2(input, synopsisInput);
	}

	@DgsData(parentType = "SynopsisContent2", field = "EUXP")
	public ContentEuxp getEUXP(ContentEuxpInput input, DataFetchingEnvironment environment) {
		Synopsis synopsis = environment.getSource();
		SynopsisInput synopsisInput = synopsis.getInput();
		return euxpApiService.getContentEuxp2(input, synopsisInput);
	}
}