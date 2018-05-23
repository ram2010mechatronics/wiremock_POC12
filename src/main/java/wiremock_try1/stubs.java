package wiremock_try1;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.extension.Extension;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class stubs {


    private Response response;

    public stubs() {
      stubFor(get(urlEqualTo("/response-transform-with-params")).willReturn(
                aResponse()
                        .withTransformerParameter("name", "John")
                        .withTransformerParameter("number", 66)
                        .withTransformerParameter("flag", true)
                        .withBody("Original body")));

        response =  given()
                .contentType("application/json")
                .body("<var>101</var>")
                .get("/response-transform-with-params");
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody().asString());
        System.out.println(response.getContentType());
        System.out.println(RestAssured.baseURI + ":" + RestAssured.port + RestAssured.basePath );

    }


}
