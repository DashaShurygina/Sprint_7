import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.example.order.OrdersData;
import org.example.order.AssertOrders;
import org.example.order.OrdersList;

@RunWith(Parameterized.class)
public class CreateOrdersTest {
    OrdersData ordersData = new OrdersData();
    OrdersList ordersList = new OrdersList();
    AssertOrders assertOrders = new AssertOrders();
    private final String[] colors;
    int track;


    public CreateOrdersTest(String[] colors) {
        this.colors = colors;
    }

    @Parameterized.Parameters(name = "Цвет самоката: {0}")
    public static Object[][] getData() {
        return new Object[][] {
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}}
        };
    }

    @Test
    @DisplayName("Создание заказа")
    @Description("Создание заказа с одним цветом/двумя цветами/без цвета")
    public void CreatingOrderWithDifferentColors() {
        ValidatableResponse createOrder = ordersList.createNewOrder(ordersData.baseOrderChangeableColor(colors));
        assertOrders.successfulCreation(createOrder);
        track = createOrder.extract().path("track");
    }

    @After
    public void CancelTestOrder() {
        ordersList.cancelOrder(track);
    }
}
