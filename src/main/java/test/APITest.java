package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import restassured.apis.APIEndpoints;
import utils.APIUtility;
import utils.DataUtility;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class APITest extends BaseAPITest{
    @Test
    public void testDashboard() {
        Response response = given().spec(loginJsonSpec).param("status", "completed").when().get(APIEndpoints.dashboard);
        APIUtility.verifyStatusCodeSuccess(response);
        response.then().assertThat()
                .body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "DashboardAPISchema")));
    }

    @Test
    public void testUser() {
        Response response = given().spec(loginJsonSpec).when().get(APIEndpoints.me);
        APIUtility.verifyStatusCodeSuccess(response);
        response.then().assertThat().body(matchesJsonSchema(DataUtility.getDataFromExcel("Schemas", "UserAPISchema")));
    }

    @Test
    public void testConfig() {
        Response response = given().spec(commonJsonSpec).when().get(APIEndpoints.config);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void invalidCredTest() {
        String loginPayload = DataUtility.getDataFromExcel("Payloads", "IncorrectLoginPayload")
                .replace("$.username", "a@gmail.com").replace("$.password", "wrongpassword");
        Response response = given().spec(commonJsonSpec).body(loginPayload).when().post(APIEndpoints.login);
        assertNotEquals(response.getStatusCode(), 200);
    }
}
