package com.skb.graphql.exception;

import com.netflix.graphql.types.errors.TypedGraphQLError;
import graphql.GraphQLError;
import graphql.execution.DataFetcherExceptionHandler;
import graphql.execution.DataFetcherExceptionHandlerParameters;
import graphql.execution.DataFetcherExceptionHandlerResult;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
public class ResolverExceptionHandler implements DataFetcherExceptionHandler {

	@Override
	public CompletableFuture<DataFetcherExceptionHandlerResult> handleException(DataFetcherExceptionHandlerParameters handlerParameters) {
		if (handlerParameters.getException() instanceof ApiBadResponseException) {
			Map<String, Object> debugInfo = new HashMap<>();
			debugInfo.put("error", ((ApiBadResponseException) handlerParameters.getException()).getMessages());
			GraphQLError graphqlError = TypedGraphQLError.newInternalErrorBuilder()
					.message("Bad Response from API")
					.debugInfo(debugInfo)
					.path(handlerParameters.getPath())
					.build();

			DataFetcherExceptionHandlerResult result = DataFetcherExceptionHandlerResult.newResult()
					.error(graphqlError)
					.build();

			return CompletableFuture.completedFuture(result);
		} else {
			return DataFetcherExceptionHandler.super.handleException(handlerParameters);
		}
	}
}