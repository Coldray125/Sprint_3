package Sprint_3.requests;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Sprint_3.configs.EndPointList.*;
import static Sprint_3.configs.ListURL.*;
import static io.restassured.RestAssured.given;

public class GetOrderListRequest {
    @Step("Отправка запроса на endpoint GET /api/v1/order для создания заказа")
    public Response GetOrderList() {
        return given()
                .spec(ScooterURL)
                .header("Content-type", "application/json")
                .when()
                .get(ORDER_CREATE)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }
}