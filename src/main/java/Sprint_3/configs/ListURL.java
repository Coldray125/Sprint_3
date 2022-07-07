package Sprint_3.configs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public interface ListURL {
    RequestSpecification ScooterURL = new RequestSpecBuilder()
            .setBaseUri("https://qa-scooter.praktikum-services.ru")
            .build();
}

