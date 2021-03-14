package Day8;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;

public class SpartanFlow {

    int id;
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }

    @Test(priority = 1)
    public void POSTNewSpartan(){}

    @Test(priority = 2)
    public void PUTExistingSpartan(){}

    @Test
    public void PATCHExistingSpartan(){}

    @Test
    public void GETThatSpartan(){}

    @Test
    public void DELETEThatSpartan(){}

}
