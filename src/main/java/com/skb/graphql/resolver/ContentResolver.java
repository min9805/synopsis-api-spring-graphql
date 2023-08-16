package com.skb.graphql.resolver;

import com.netflix.graphql.dgs.*;
import com.skb.graphql.entity.*;
import com.skb.graphql.entity.input.ContentEuxpInput;
import com.skb.graphql.entity.input.ContentScsInput;
import com.skb.graphql.entity.input.ContentSmdInput;
import com.skb.graphql.entity.input.SynopsisInput;
import com.skb.graphql.service.EuxpApiService;
import com.skb.graphql.service.ScsApiService;
import com.skb.graphql.service.SmdApiService;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class ContentResolver {
	private final SmdApiService smdApiService;
	private final ScsApiService scsApiService;
	private final EuxpApiService euxpApiService;


	public ContentResolver(SmdApiService smdApiService, ScsApiService scsApiService, EuxpApiService euxpApiService) {
		this.smdApiService = smdApiService;
		this.scsApiService = scsApiService;
		this.euxpApiService = euxpApiService;
	}


	@DgsData.List({
			@DgsData(parentType = "Query", field = "synopsis1"),
			@DgsData(parentType = "Query", field = "synopsis2")
	})
	public Synopsis getSynopsis(SynopsisInput input) {
		Synopsis synopsis = new Synopsis();
		synopsis.setInput(input);
		return synopsis;
	}


	@DgsData(parentType = "SynopsisContent1", field = "SMD")
	public ContentSmd getSMD(ContentSmdInput input, DataFetchingEnvironment environment) {
		Synopsis synopsis = environment.getSource();
		SynopsisInput synopsisInput = synopsis.getInput();
		return smdApiService.getContentSmd(input);
	}

	@DgsData(parentType = "SynopsisContent1", field = "SCS")
	public ContentScs getSCS(ContentScsInput input, DataFetchingEnvironment environment) {
		Synopsis synopsis = environment.getSource();
		SynopsisInput synopsisInput = synopsis.getInput();
		return scsApiService.getContentScs(input);
	}

	@DgsData(parentType = "SynopsisContent1", field = "EUXP")
	public ContentEuxp getEUXP(ContentEuxpInput input, DataFetchingEnvironment environment) {
		Synopsis synopsis = environment.getSource();
		SynopsisInput synopsisInput = synopsis.getInput();
		return euxpApiService.getContentEuxp(input);
	}
}