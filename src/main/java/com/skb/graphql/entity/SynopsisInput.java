package com.skb.graphql.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SynopsisInput {
	private String Api_Key;
	private String Auth_Val;
	private String Client_ID;
	private String TimeStamp;
	private String Trace;
	private String UUID;
}