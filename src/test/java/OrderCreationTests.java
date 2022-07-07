import Sprint_3.builders.OrderBuilder;
import Sprint_3.pojo.CreateOrderPojo;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static Sprint_3.configs.ValidFieldData.*;
import static org.apache.http.HttpStatus.*;

@RunWith(Parameterized.class)
public class OrderCreationTests {

    OrderBuilder orderBuilder = new OrderBuilder();
    private final List<String> input;

    public OrderCreationTests(List<String> input) {
        this.input = input;
    }

    @Parameterized.Parameters(name = "color{0}{1}")
    public static Object[][] changeColorInOrder() {
        return new Object[][]{
                {List.of("BLACK")},
                {List.of("GREY")},
                {List.of("BLACK", "GREY")},
                {List.of("")},
        };
    }

    @DisplayName("Check response Code after order creation with different colors")
    @Description("Возврат кода 201 в случае создания заказа с указанием цвета")
    @Test
    public void createValidOrderStatusCode() {
        CreateOrderPojo createOrderPojo = new CreateOrderPojo()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setMetroStation(metroStation)
                .setPhone(phone)
                .setRentTime(rentTime)
                .setDeliveryData(deliveryData)
                .setComment(comment)
                .setColor(input);

        Response response = orderBuilder.createOrder(createOrderPojo);

        Assert.assertEquals(SC_CREATED, response.getStatusCode());
    }

    @DisplayName("Check response message is contains word track after order creation with different colors")
    @Description("Возврат track в теле ответа в случае создания заказа с указанием цвета")
    @Test
    public void createValidOrderResponseMessage() {
        CreateOrderPojo createOrderPojo = new CreateOrderPojo()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .setMetroStation(metroStation)
                .setPhone(phone)
                .setRentTime(rentTime)
                .setDeliveryData(deliveryData)
                .setComment(comment)
                .setColor(input);

        orderBuilder.createOrder(createOrderPojo);
        String responseBody = orderBuilder.getCreateOrderResponseMessage(createOrderPojo);

        Assert.assertTrue(responseBody, responseBody.contains("track"));
    }
}