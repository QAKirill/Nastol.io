package nastolio.web.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.*;
import static io.restassured.http.ContentType.JSON;
import static nastolio.web.utils.CustomAllureListener.withCustomTemplates;

public class Specs {
    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().method()
            .log().headers()
            .log().body()
            .contentType(JSON);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(HEADERS)
            .log(COOKIES)
            //.log(BODY)
            .build();
}
