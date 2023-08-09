package com.skb.graphql.resolver;

import com.netflix.graphql.dgs.*;
import com.skb.graphql.entity.*;
import com.skb.graphql.service.EuxpApiService;
import com.skb.graphql.service.ScsApiService;
import com.skb.graphql.service.SmdApiService;
import com.skb.graphql.service.SynopsisApiService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

@DgsComponent
public class ContentResolver {
	private final SynopsisApiService apiService;
	private final SmdApiService smdApiService;
	private final ScsApiService scsApiService;
	private final EuxpApiService euxpApiService;


	public ContentResolver(SynopsisApiService apiService, SmdApiService smdApiService, ScsApiService scsApiService, EuxpApiService euxpApiService) {
		this.apiService = apiService;
		this.smdApiService = smdApiService;
		this.scsApiService = scsApiService;
		this.euxpApiService = euxpApiService;
	}


	@DgsData(parentType = "Query", field = "Synopsis")
	public Synopsis getSynopsis(SynopsisInput input) {
		Synopsis synopsis = new Synopsis();
		synopsis.setInput(input);
		return synopsis;
	}


	@DgsData(parentType = "SynopsisContent", field = "SMD")
	public ContentSmd getSMD(ContentSmdInput input, DataFetchingEnvironment environment) {
		Synopsis synopsis = environment.getSource();
		SynopsisInput synopsisInput = synopsis.getInput();
		return smdApiService.getContentSmd(input);
	}

	@DgsData(parentType = "SynopsisContent", field = "SCS")
	public ContentScs getSCS(ContentScsInput input, DataFetchingEnvironment environment) {
		Synopsis synopsis = environment.getSource();
		SynopsisInput synopsisInput = synopsis.getInput();
		return scsApiService.getContentScs(input);
	}

	@DgsData(parentType = "SynopsisContent", field = "EUXP")
	public ContentEuxp getEUXP(ContentEuxpInput input, DataFetchingEnvironment environment) {
		Synopsis synopsis = environment.getSource();
		SynopsisInput synopsisInput = synopsis.getInput();
		return euxpApiService.getContentEuxp(input);
	}
}