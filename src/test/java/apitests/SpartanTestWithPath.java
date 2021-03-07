package apitests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class SpartanTestWithPath {

    @BeforeClass
    public void beforeclass(){
        baseURI="http://3.80.189.73:8000";
    }

    /*
   Given accept type is json
   And path param id is 10
   When user sends a get request to "api/spartans/{id}"
   Then status code is 200
   And content-type is "application/json;charset=UTF-8"
   And response payload values match the following:
           id is 10,
           name is "Lorenza",
           gender is "Female",
           phone is 3312820936
    */

    @Test
    public void getOneSpartan_path(){
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 10)
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json;charset=UTF-8");

        //response.prettyPrint();
        //printing each key value in the json body/payload
        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.body().path("gender").toString());
        System.out.println(response.body().path("phone").toString());

        //save json key values
        int id =  response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        //assert one by one
        assertEquals(id,10);
        assertEquals(name,"Lorenza");
        assertEquals(gender,"Female");
        assertEquals(phone,3312820936l);

    }

    @Test
    public void getAllSpartanWithPath(){

        Response response = given().accept(ContentType.JSON)
                        .when().get("/api/spartans");

        assertEquals(response.statusCode(),200);
        //verify content type
        assertEquals(response.getHeader("Content-Type"),"application/json;charset=UTF-8");

        int firstId = response.path("id[0]");
        System.out.println("firstId = " + firstId);

        String firstName = response.path("name[0]");
        System.out.println("firstName = " + firstName);

        String lastFirstName = response.path("name[-2]");
        System.out.println("lastFirstName = " + lastFirstName);

        int lastId = response.path("id[-1]");
        System.out.println("lastId = " + lastId);

        //print all names of spartans
        List<String> names = response.path("name");
        System.out.println("names = " + names);

        List<Object> phones = response.path("phone");
        for (Object phone : phones) {
            System.out.println(phone);
        }
    }



}
