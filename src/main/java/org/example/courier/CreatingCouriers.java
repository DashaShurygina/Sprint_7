package org.example.courier;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;



public class CreatingCouriers {
    @Step("Создание курьера")
    public ValidatableResponse createCourier(Registration courier){
        return given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/")
                .body(courier)
                .when()
                .post("/api/v1/courier")
                .then();
    }
    @Step("Удаление курьера")
    public ValidatableResponse deleteCourier(int id){
        return given()
                .contentType(ContentType.JSON)
                .baseUri("http://qa-scooter.praktikum-services.ru/")
                .when()
                .delete("/api/v1/courier" + id)
                .then();
    }

}
