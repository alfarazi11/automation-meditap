package test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import restassured.apis.APIEndpoints;
import restassured.apis.JsonPaths;
public class BaseAPITest {
    RequestSpecification commonJsonSpec = new RequestSpecBuilder().setBaseUri("https://api-staging-builder.engineer.ai")
            .setContentType(ContentType.JSON).build().log().all();
    RequestSpecification loginJsonSpec;

    @BeforeMethod
    public void login() {
        RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
//        String loginPayload = DataUtility.getDataFromExcel("Payloads", "LoginPayload");
        String loginPayload = "{\"email\":\"jogidemo321@gmail.com\",\"password\":\"builder123\"}";
        Response response = RestAssured.given().contentType("application/json").body(loginPayload).when()
                .post(APIEndpoints.login);
        String token = response.jsonPath().get(JsonPaths.authToken);
        loginJsonSpec = new RequestSpecBuilder().setBaseUri("https://api-staging-builder.engineer.ai")
                .setContentType(ContentType.JSON).addHeader("authtoken", token).build().log().all();
    }

}
