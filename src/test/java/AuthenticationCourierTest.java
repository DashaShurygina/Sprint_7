import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.*;
import org.example.courier.AssertAuthorization;
import org.example.courier.Authorization;
import org.example.courier.AuthorizationCouriers;
import org.example.courier.CouriersData;
import org.example.courier.CreatingCouriers;

public class AuthenticationCourierTest {
    static CreatingCouriers creatingCourier = new CreatingCouriers();
    Authorization auth;
    static ValidatableResponse authBaseCourier;
    AuthorizationCouriers authCourier = new AuthorizationCouriers();
    AssertAuthorization assertsLogin = new AssertAuthorization();
    static CouriersData courierData = new CouriersData();
    static int courierId;

    @BeforeClass
    public static void createBaseCourier(){
        creatingCourier.createCourier(courierData.secondCourier());
    }

    @Test
    @DisplayName("Успешная авторизация")
    @Description("Успешная авторизация")
    public void successfulCourierAuth(){
        auth = Authorization.fromRegistrationCourier(courierData.secondCourier());
        authBaseCourier = authCourier.authorizationCourier(auth);
        assertsLogin.successfullyAuth(authBaseCourier);
    }

    @Test
    @DisplayName("Авторизация login null")
    @Description("Авторизация login null")
    public void courierAuthWithEmptyLogin(){
        auth = Authorization.fromRegistrationCourier(courierData.emptyLoginCourier());
        authBaseCourier = authCourier.authorizationCourier(auth);
        assertsLogin.filedAuthLoginOrPasswordNull(authBaseCourier);

    }

    @Test
    @DisplayName("Авторизация password null")
    @Description("Авторизация password null")
    public void courierAuthWithEmptyPassword(){
        auth = Authorization.fromRegistrationCourier(courierData.emptyPasswordCourier());
        authBaseCourier = authCourier.authorizationCourier(auth);
        assertsLogin.filedAuthLoginOrPasswordNull(authBaseCourier);
    }

    @Test
    @DisplayName("Авторизация не зарегистрированного курьера")
    @Description("Авторизация не зарегистрированного курьера")
    public void unregisteredCourierAuth(){
        auth = Authorization.fromRegistrationCourier(courierData.thirdCourier());
        authBaseCourier = authCourier.authorizationCourier(auth);
        assertsLogin.filedAuthUserNotFound(authBaseCourier);
    }

    @AfterClass
    public static void deleteCourier(){
        courierId = authBaseCourier.extract().path("id");
        creatingCourier.deleteCourier(courierId);
    }
}
