package selTest;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class APITest1 {

    @Test
    public void getSingleUser(){
        Response response = given().when().get("https://reqres.in/api/users/2");
        int actStatus = response.statusCode();
        ResponseBody responseBody = response.getBody();
        String actualResBody = responseBody.asString();
        System.out.println(actualResBody);
        Assert.assertEquals(actStatus,200,"Get operation failed!!");
        Assert.assertTrue(actualResBody.contains("Janet"),"Response verification failed!!");
    }
}
