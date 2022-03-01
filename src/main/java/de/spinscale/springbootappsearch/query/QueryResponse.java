package de.spinscale.springbootappsearch.query;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QueryResponse {

    private List<Result> results = Collections.emptyList();

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public static class Result {

        private String title;

        private String url;

        private String host;

        private String description;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        // this is a ugly work around to set a field from a nested object
        // I had hoped one can a specify a nested path in the property definition, but apparently
        // this is the way to go...
        @JsonProperty("title")
        private void unpackTitleFromNestedObject(Map<String, String> map) {
            this.title = map.get("raw");
        }

        @JsonProperty("url_host")
        private void unpackHostFromNestedObject(Map<String, String> map) {
            this.host = map.get("raw");
        }

        @JsonProperty("meta_description")
        private void unpackDescriptionFromNestedObject(Map<String, String> map) {
            this.description = map.get("raw");
        }

        @JsonProperty("url")
        private void unpackUrlFromNestedObject(Map<String, String> map) {
            this.url = map.get("raw");
        }
    }
}
