package org.example.order;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class OrdersList {

    @Step("Создать новый заказ")
    public ValidatableResponse createNewOrder(Order order){
        return given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/")
                .body(order)
                .when()
                .post("/api/v1/orders")
                .then();
    }

    @Step("Получить список заказов")
    public ValidatableResponse getOrderList(){
        return given()
                .baseUri("http://qa-scooter.praktikum-services.ru/")
                .when()
                .get("/api/v1/orders")
                .then();
    }
    @Step("Отмена заказ")
    public ValidatableResponse cancelOrder(int track){
        return given()
                .header("Content-type", "application/json")
                .baseUri("http://qa-scooter.praktikum-services.ru/")
                .body(track)
                .when()
                .post("/api/v1/orders")
                .then();
    }
}