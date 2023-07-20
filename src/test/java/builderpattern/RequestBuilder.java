package builderpattern;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestBuilder {
    private String baseUrl;
    private String endpoint;
    private ContentType contentType;
    private String requestBody;

    public RequestBuilder(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public RequestBuilder setEndpoint(String endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    public RequestBuilder setContentType(ContentType contentType) {
        this.contentType = contentType;
        return this;
    }

    public RequestBuilder setRequestBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public RequestSpecification build() {
        return RestAssured.given()
                .baseUri(baseUrl)
                .basePath(endpoint)
                .contentType(contentType)
                .body(requestBody);
    }
}
