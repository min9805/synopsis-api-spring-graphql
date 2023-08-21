package com.skb.graphql.entity;

import lombok.*;

@Getter
@Builder
public class ErrorApi {
	ExupError exupError;
	SmdError smdError;
	ScsError scsError;


	@Builder
	@Getter
	public static class ExupError {
		String reason;
		String result;
	}

	@Builder
	@Getter
	public static class SmdError {
		String reason;
		String result;
	}

	@Builder
	@Getter
	public static class ScsError {
		String reason;
		String result;
	}
}