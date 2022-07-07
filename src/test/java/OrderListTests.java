import Sprint_3.builders.OrderBuilder;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import static org.apache.http.HttpStatus.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;

public class OrderListTests {

    OrderBuilder orderBuilder = new OrderBuilder();

    @DisplayName("Check status code after the order list request")
    @Description("Проверка наличия кода ответа 200 на запрос GET /api/v1/orders")
    @Test
    public void ValidRequestOrderListStatusCode() {
        Response response = orderBuilder.getOrderList();

        Assert.assertEquals(SC_OK, response.getStatusCode());
    }

    @DisplayName("Check response body is not empty or null for order list request")
    @Description("Проверка наличия body в ответе на запрос GET /api/v1/orders")
    @Test
    public void OrderIdIsInTheOrderList() {
        String responseBody = orderBuilder.getOrderList().getBody().asString();

        assertThat(responseBody, CoreMatchers.not(emptyOrNullString()));
    }
}