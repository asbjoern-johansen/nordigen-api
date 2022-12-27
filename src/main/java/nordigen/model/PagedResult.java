package nordigen.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PagedResult<T> {

    @JsonProperty("count")
    private int count;

    @JsonProperty("next")
    //example: https://ob.nordigen.com/api/v2/agreements/enduser/?limit=100&offset=0
    private String next;

    @JsonProperty("previous")
    //example: https://ob.nordigen.com/api/v2/agreements/enduser/?limit=100&offset=0
    private String previous;

    @JsonProperty("results")
    private List<T> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "PagedResult{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous='" + previous + '\'' +
                ", results=" + results +
                '}';
    }
}
