package org.example.courier;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
import static org.example.url.ScooterApiEndpoints.AUTH_COURIER;
import static org.example.url.ScooterApiEndpoints.BASE_URL;

public class AuthorizationCouriers {
    @Step("Логин курьера в системе")
    public ValidatableResponse authorizationCourier(Authorization courier){
        return given()
                .header("Content-type", "application/json")
                .baseUri(BASE_URL)
                .body(courier)
                .when()
                .post(AUTH_COURIER)
                .then();
    }
}
