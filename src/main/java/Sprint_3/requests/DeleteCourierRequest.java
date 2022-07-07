package Sprint_3.requests;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static Sprint_3.configs.EndPointList.*;
import static Sprint_3.configs.ListURL.*;
import static io.restassured.RestAssured.given;

public class DeleteCourierRequest {
    @Step("Отправка запроса на endpoint /api/v1/courier/{id} для удаления учетной записи курьера")
    public Response DeleteCourier(String id) {
        return given()
                .spec(ScooterURL)
                .header("Content-type", "application/json")
                .when()
                .delete(COURIER_DELETE,id);
    }
}