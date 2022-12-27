package nordigen.api.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import nordigen.api.NordigenApiException;

public class ErrorResponseException extends NordigenApiException {

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("detail")
    private String detail;

    @JsonProperty("status_code")
    private Integer statusCode;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
