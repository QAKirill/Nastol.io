package nastolio.web.methods;

import io.qameta.allure.Step;
import nastolio.web.models.LoginBodyModel;
import nastolio.web.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static nastolio.web.specs.Specs.*;

public class StepsApi {
    LoginBodyModel loginBodyModel = new LoginBodyModel();
    private LoginResponseModel authResponse;

    public LoginResponseModel getAuthResponse() {
        return authResponse;
    }

    @Step("Логинимся")
    public StepsApi login(){
        authResponse = given(requestSpec)
                .body(loginBodyModel.getAuthData())
                .when()
                .post(loginBodyModel.getLoginPage())
                .then()
                .spec(responseSpec.expect().statusCode(200))
                .extract().as(LoginResponseModel.class);

        authResponse.setHeaderValue("Bearer " + authResponse.getToken());
        return this;
    }
}
