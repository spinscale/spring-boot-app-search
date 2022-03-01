package de.spinscale.springbootappsearch;

import de.spinscale.springbootappsearch.query.Query;
import de.spinscale.springbootappsearch.query.QueryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "appsearch", url="${appsearch.url}")
public interface AppSearchClient {

    @GetMapping("/api/as/v1/engines/${appsearch.engine}/search")
    QueryResponse search(@RequestBody Query query);
}
