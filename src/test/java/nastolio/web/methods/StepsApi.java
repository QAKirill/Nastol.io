package nastolio.web.methods;

import io.qameta.allure.Step;
import nastolio.web.models.LoginBodyModel;
import nastolio.web.models.LoginResponseModel;
import nastolio.web.models.Token;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static nastolio.web.specs.Specs.*;

public class StepsApi {

    LoginBodyModel loginBodyModel = new LoginBodyModel();
    private LoginResponseModel authResponse;
    private Token token;
    private String authToken = "", session;
    Map<String, String> cookies, headers;

    public LoginResponseModel getAuthResponse() {
        return authResponse;
    }

    public StepsApi getToken() throws IOException {
        Document doc = Jsoup.connect("https://nastol.io")
                .userAgent("Chrome/119.0.0.0 Safari/537.36")
                .referrer("http://www.google.com")
                .get();

        Elements tokenMeta = doc.select("meta[name=csrf-token]");
        authToken = tokenMeta.attr("content");
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
        String x = given(requestSpec)
                .header("User-Agent","Chrome/119.0.0.0 Safari/537.36")
                .header("Cookie", headers.get("Set-Cookie"))
                .body(loginBodyModel.getAuthData())
                .when()
                .post("/login")
                .then()
                .spec(responseSpec.expect().statusCode(302))
                .extract().headers().toString();

        System.out.println(x);

        //authResponse.setHeaderValue("Bearer " + authResponse.getToken());
        return this;
    }
}
