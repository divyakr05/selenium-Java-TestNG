package selTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class APITest2 {
    String baseURI = "https://reqres.in/api/";
    @Test
    public void testGet(){
        given().get(baseURI+"users?page=2").then().
                statusCode(200).
                body("data[1].id",equalTo(8)).
                body("data.email",hasItems("lindsay.ferguson@reqres.in","michael.lawson@reqres.in")).
                log().all();


    }

    @Test
    public void testPost(){
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","morpheus");
//        map.put("job","leader");
//        System.out.println(map);
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","leader");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON). //content I am sending is Json
                accept(ContentType.JSON). // Response I will accept is in the form of JSON
                body(request.toJSONString()).
                when().
                post(baseURI+"users").
                then().
                statusCode(201).
                body("name", equalTo("morpheus")).
                log().all();
    }

    @Test
    public void testPatch(){
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","leader");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON). //content I am sending is Json
                accept(ContentType.JSON). // Response I will accept is in the form of JSON
                body(request.toJSONString()).
                when().
                patch(baseURI+"users/2").
                then().
                statusCode(200).
                log().all();


    }

    @Test
    public void testPut(){
        JSONObject request = new JSONObject();
        request.put("name","morpheus");
        request.put("job","zion resident");
        System.out.println(request);
        System.out.println(request.toJSONString());
        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON). //content I am sending is Json
                accept(ContentType.JSON). // Response I will accept is in the form of JSON
                body(request.toJSONString()).
                when().
                put(baseURI+"users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testDelete(){
        when().
                delete(baseURI+"users/2").
                then().
                statusCode(204).
                log().all();

    }
}
