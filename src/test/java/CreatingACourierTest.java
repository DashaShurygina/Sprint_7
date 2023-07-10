import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.example.courier.Authorization;
import org.example.courier.AuthorizationCouriers;
import org.example.courier.AssertsRegistration;
import org.example.courier.CouriersData;
import org.example.courier.CreatingCouriers;


public class CreatingACourierTest {

    CouriersData courierData = new CouriersData();
    CreatingCouriers creatingCourier = new CreatingCouriers();
    AssertsRegistration assertsRegistration = new AssertsRegistration();
    AuthorizationCouriers authCourier = new AuthorizationCouriers();
    ValidatableResponse authBaseCourier;
    ValidatableResponse createBaseCourier;
    Authorization auth;
    int courierId;

    @Test
    @DisplayName("Создание новой УЗ курьера")
    @Description("Создается новая УЗ курьера с кодом 201")
    public void creatingCourier(){
        createBaseCourier = creatingCourier.createCourier(courierData.baseCourier());
        assertsRegistration.successfulCreation(createBaseCourier);
    }

    @Test
    @DisplayName("Создание курьера без заполнения обязательного поля логин")
    @Description("Проверяем код и описание ошибки при создание курьера с логином null")
    public void creatingCourierWithNullLogin(){
        createBaseCourier = creatingCourier.createCourier(courierData.emptyLoginCourier());
        assertsRegistration.failedCreation(createBaseCourier);
    }

    @Test
    @DisplayName("Создание курьера без заполнения обязательного поля пароль")
    @Description("Проверяем код и описание ошибки при создание курьера с паролем null")
    public void creatingCourierWithNullPassword(){
        createBaseCourier = creatingCourier.createCourier(courierData.emptyPasswordCourier());
        assertsRegistration.failedCreation(createBaseCourier);
    }


    @Test
    @DisplayName("Повторная регистрация УЗ курьера")
    @Description("Повторная регистрация УЗ курьера с теми же данными")
    public void reRegistrationOfCourier(){
        createBaseCourier = creatingCourier.createCourier(courierData.registeredCourier());
        assertsRegistration.creatingExistingAccount(createBaseCourier);
    }

    @After
    public void deleteCourier() {
        if (createBaseCourier.extract().statusCode() == 201) {
            auth = Authorization.fromRegistrationCourier(courierData.baseCourier());
            authBaseCourier = authCourier.authorizationCourier(auth);
            courierId = authBaseCourier.extract().path("id");
            creatingCourier.deleteCourier(courierId);
        }
    }
}
