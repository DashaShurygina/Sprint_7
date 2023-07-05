import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.example.order.AssertOrders;
import org.example.order.OrdersList;

public class OrderListTest {
    OrdersList orderClient = new OrdersList();
    AssertOrders assertOrders = new AssertOrders();

    @Test
    @DisplayName("Получение списка заказов")
    @Description("Успешное получение списка заказов")
    public void getOrderList() {
        ValidatableResponse orderList =  orderClient.getOrderList();
        assertOrders.successfulGetListOrders(orderList);
    }
}
