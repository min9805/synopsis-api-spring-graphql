package com.skb.graphql.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Synopsis {
	private ContentScs scs;
	private ContentEuxp euxp;
	private ContentSmd smd;

	private SynopsisInput input;
}