package com.skb.graphql;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.skb.graphql.resolver.ContentResolver;
import com.skb.graphql.entity.ContentScs;
import com.skb.graphql.entity.ContentScsInput;
import com.skb.graphql.entity.ContentSmdInput;
import com.skb.graphql.entity.ContentSmd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@DgsComponent
	public class QueryResolver {
		private final ContentResolver contentResolver;

		public QueryResolver(ContentResolver contentResolver) {
			this.contentResolver = contentResolver;
		}

		@DgsQuery
		public ContentSmd getContentSmd(ContentSmdInput input) {
			return contentResolver.getContentSmd(input);
		}
		@DgsQuery
		public ContentScs getContentScs(ContentScsInput input) {
			return contentResolver.getContentScs(input);
		}
	}
}