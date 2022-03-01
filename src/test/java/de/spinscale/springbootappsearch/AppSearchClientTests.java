package de.spinscale.springbootappsearch;

import de.spinscale.springbootappsearch.query.Query;
import de.spinscale.springbootappsearch.query.QueryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = SpringBootAppSearchApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
class AppSearchClientTests {

	@Autowired
	private AppSearchClient appSearchClient;

	@Test
	void testFeignAppSearchClient() {
		final QueryResponse queryResponse = appSearchClient.search(Query.of("seccomp"));
		assertThat(queryResponse.getResults()).hasSize(4);
		assertThat(queryResponse.getResults().stream().map(QueryResponse.Result::getTitle))
				.contains("Using seccomp - Making your applications more secure",
						  "Presentations",
						  "Elasticsearch - Securing a search engine while maintaining usability",
						  "Posts"
				);
		assertThat(queryResponse.getResults().stream().map(QueryResponse.Result::getUrl))
				.contains("https://spinscale.de/posts/2020-10-27-seccomp-making-applications-more-secure.html",
						"https://spinscale.de/presentations.html",
						"https://spinscale.de/posts/2020-04-07-elasticsearch-securing-a-search-engine-while-maintaining-usability.html",
						"https://spinscale.de/posts/"
				);
	}

}
