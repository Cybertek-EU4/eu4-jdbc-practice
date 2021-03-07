package apitests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;

import static io.restassured.RestAssured.*;

public class hrApiWithJsonPath {

    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("hr_api_url");
    }

    @Test
    public void test1(){
        Response response = get("/countries");

        //assign to jsonpath
        JsonPath jsonPath = response.jsonPath();

        String secondCountryName = jsonPath.getString("items.country_name[1]");
        System.out.println("secondCountryName = " + secondCountryName);

        //get all country ids
        List<String> countryIDs = jsonPath.getList("items.country_id");
        System.out.println(countryIDs);

        //get all country names where their region id is equal to 2
        List<String> countryNamesWithRegionId2 =jsonPath.getList("items.findAll {it.region_id==3}.country_id");
        System.out.println(countryNamesWithRegionId2);
    }

    @Test
    public void test2(){
        Response response = given().queryParam("limit",107)
                            .when().get("/employees");

        JsonPath jsonPath = response.jsonPath();

        //get me all email of employees who is working as IT_PROG
        List<String> firstNames = jsonPath.getList("items.findAll {it.job_id==\"IT_PROG\"}.email");
        System.out.println(firstNames);

        //get me all firstname of emplyoees who is making more than 10000
        List<String> firstNames2 = jsonPath.getList("items.findAll {it.salary >10000}.first_name");
        System.out.println(firstNames2);

        //get me first name of who is making highest salary
        String kingName = jsonPath.getString("items.max {it.salary}.first_name");
        System.out.println("kingName = " + kingName);


    }

}
