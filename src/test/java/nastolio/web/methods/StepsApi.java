package nastolio.web.methods;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.Getter;
import nastolio.web.models.LoginBodyModel;
import nastolio.web.models.LoginResponseModel;
import nastolio.web.models.Token;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static nastolio.web.specs.Specs.*;

public class StepsApi {

    LoginBodyModel loginBodyModel = new LoginBodyModel();
    private LoginResponseModel authResponse;
    @Getter
    private String ntoken;
    @Getter
    private String authToken = "", session;
    Map<String, String> cookies, headers;

    public LoginResponseModel getAuthResponse() {
        return authResponse;
    }

    public StepsApi getTo() {
        gT();
        loginBodyModel.setToken(authToken);
        Response response = given(requestSpec)
                .header("User-Agent", "Chrome/119.0.0.0 Safari/537.36")
                .body(loginBodyModel.getAuthData())
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .extract().response();

        String redirectUrl = response.getHeader("Location");

        System.out.println("@@@@@@@@@@@@@@@@@" + redirectUrl);


        Response redirectedResponse = given()
                .urlEncodingEnabled(false)
                .when()
                .get(redirectUrl)
                .then()
                .statusCode(200)
                .extract().response();

        Map<String, String> cookies = redirectedResponse.getCookies();

        for (Map.Entry<String, String> cookie : cookies.entrySet()) {
            ntoken = "Bearer%2065965%" + cookie.getValue();
            System.out.println("Cookies:" + cookie.getValue());
        }

        System.out.println();
        return this;
    }

    public void gT() {
        Connection.Response response = null;
        try {
            response = Jsoup.connect("https://nastol.io")
                    .userAgent("Chrome/119.0.0.0 Safari/537.36")
                    .referrer("http://www.google.com")
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Document document = null;
        try {
            document = response.parse();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements tokenMeta = document.select("meta[name=csrf-token]");
        authToken = tokenMeta.attr("content");
        cookies = response.cookies();
        headers = response.headers();
        session = cookies.get("nastolio_session");
    }

    @Step("Логинимся")
    public StepsApi login() {
        gT();
        loginBodyModel.setToken(authToken);
        Response x = given(requestSpec)
                .header("User-Agent","Chrome/119.0.0.0 Safari/537.36")
                .header("Cookie", headers.get("Set-Cookie"))
                .body(loginBodyModel.getAuthData())
                .when()
                .post("/login")
                .then()
                .spec(responseSpec.expect().statusCode(302))
                .extract().response();

        x.prettyPrint();
        //System.out.println("#############" + x.pret);
        //System.out.println("@@@@@@@@@@@@@@" + x.headers());

        //authResponse.setHeaderValue("Bearer " + authResponse.getTo());
        return this;
    }
}
