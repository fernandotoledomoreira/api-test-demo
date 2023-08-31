package api.test.demo.clients;

import api.test.demo.mocks.BodyUser;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.datafaker.Faker;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class Clients {

    Response response;
    RequestSpecification requestSpecification = new RequestSpecBuilder().build();
    BodyUser payload = new BodyUser();
    Faker faker = new Faker();

    public void setPayload() {
        requestSpecification.body(payload);
    }

    public void postRequest(String typeRequest, String path) {
        requestSpecification.baseUri("https://reqres.in/api/");
        response = given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .log().all()
                .when()
                .request(typeRequest, path)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public void patchRequest(String typeRequest, String path) {
        requestSpecification.baseUri("https://reqres.in/api/");
        payload.setName(faker.name().fullName() + " edited");
        payload.setJob(faker.job().position() + " edited");
        requestSpecification.body(payload);
        requestSpecification.pathParam("id", "1");
        response = given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .log().all()
                .when()
                .request(typeRequest, path)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public void getRequest(String typeRequest, String path) {
        requestSpecification.baseUri("https://reqres.in/api/");
        requestSpecification.pathParam("id", "1");
        response = given()
                .spec(requestSpecification)
                .contentType(ContentType.JSON)
                .filter(new AllureRestAssured())
                .log().all()
                .when()
                .request(typeRequest, path)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public void validateStatusCode(Integer code) {
        Assert.assertEquals(response.getStatusCode(), code);
    }

    public void validateSchemaApi(String schema) {
        response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + schema));
    }


}
