package com.skb.graphql.exception;

import com.skb.graphql.entity.ErrorApi;
import lombok.Getter;
import lombok.experimental.StandardException;

@StandardException
@Getter
public class ApiBadResponseException extends RuntimeException {
	private ErrorApi messages;

	public ApiBadResponseException(ErrorApi messages) {
		this.messages = messages;
	}

	// Custom fields, constructors, and methods can be added here
}