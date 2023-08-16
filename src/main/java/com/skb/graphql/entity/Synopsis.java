package com.skb.graphql.entity;

import com.skb.graphql.entity.input.SynopsisInput;
import lombok.Data;

@Data
public class Synopsis {
	private ContentScs scs;
	private ContentEuxp euxp;
	private ContentSmd smd;

	private SynopsisInput input;
}