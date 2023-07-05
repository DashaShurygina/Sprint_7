package org.example.courier;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
public class AuthorizationCouriers {
    @Step("Логин курьера в системе")
    public ValidatableResponse authorizationCourier(Authorization courier){
        return given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/")
                .body(courier)
                .when()
                .post("/api/v1/courier/login")
                .then();
    }
}
