package Sprint_3.requests;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static Sprint_3.configs.EndPointList.*;
import static Sprint_3.configs.ListURL.*;
import static io.restassured.RestAssured.given;

public class PostCreateCourierRequest {
    @Step("Отправка запроса на endpoint POST /api/v1/courierCreate для создания учетной записи курьера")
    public Response CourierCreate(Object object) {
        return given()
                .spec(ScooterURL)
                .header("Content-type", "application/json")
                .body(object)
                .when()
                .post(COURIER_CREATE)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();
    }
}