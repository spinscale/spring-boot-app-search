package de.spinscale.springbootappsearch;

import de.spinscale.springbootappsearch.query.Query;
import de.spinscale.springbootappsearch.query.QueryResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class MainController {

    private final AppSearchClient appSearchClient;

    public MainController(AppSearchClient appSearchClient) {
        this.appSearchClient = appSearchClient;
    }

    @GetMapping("/")
    public String main(@RequestParam(value = "q", required = false) String q, Model model) {
        if (q != null && q.trim().isBlank() == false) {
            model.addAttribute("q", q);
            final QueryResponse response = appSearchClient.search(Query.of(q));
            model.addAttribute("results", response.getResults());
        }
        return "main";
    }

    // htmx based search using server side rendering for responses only without page reload
    @GetMapping("/htmx")
    public String htmx() {
        return "htmx-main";
    }

    @PostMapping("/htmx-search")
    public String htmxSearch(@RequestParam("q") String q, Model model) {
        if (q != null && q.trim().isBlank() == false) {
            final QueryResponse response = appSearchClient.search(Query.of(q));
            model.addAttribute("results", response.getResults());
        }
        return "htmx-search-results";
    }

    // client side search using alpine JS
    @GetMapping("/alpine")
    public String alpine() {
        return "alpine-js";
    }
}
