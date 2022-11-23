package util.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

/**
 * Base class for Test classes.
 *
 * @author am.garcia
 */
public class BaseTest {
    protected Response res;
    protected JsonPath jsonPath;
    protected WorkFlow workFlow;

    /**
     * SetUp before to run suite of test.
     *
     * @author am.garcia
     */
    @BeforeMethod
    public void setup() {
        RestAssuredUtil.setBaseURI("https://637bb09f72f3ce38ea92c648.mockapi.io/am-garc1a/");
        RestAssuredUtil.setBasePath("bank");
        RestAssuredUtil.setContentType(ContentType.JSON);
        this.res = null;
        this.jsonPath = null;
        this.workFlow = new WorkFlow();
    }

    /**
     * Reset after completing the test.
     *
     * @author am.garcia
     */
    @AfterMethod
    public void afterTest() {
        RestAssuredUtil.resetBaseURI();
        RestAssuredUtil.resetBasePath();
    }

    /**
     * Method to check if status code of response is 200.
     *
     * @param res : response
     */
    public void isStatus200(Response res) {
        Assert.assertEquals(res.getStatusCode(), 200, "Status 200 Failed!");
    }

}
