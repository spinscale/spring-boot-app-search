package de.spinscale.springbootappsearch.query;

public class Query {

    private final String query;

    public Query(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public static Query of(String query) {
        return new Query(query);
    }
}
