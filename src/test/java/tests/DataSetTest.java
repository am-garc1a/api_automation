package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import model.BankUserModel;

import util.tests.BaseTest;
import util.tests.RestAssuredUtil;
import util.repoter.Reporter;

import java.util.List;

import static org.apache.http.HttpStatus.*;

/**
 * Class for testing data set.
 */
public class DataSetTest extends BaseTest {

    @Test(priority = 1)
    public void emptyDataSet() {
        Reporter.info("TEST START, empty data set---------------");

        Reporter.info("Getting data set");
        List<BankUserModel> bankUsersData = workFlow.getAllDataSet(res, jsonPath);

        Reporter.info("Extracting ids if it exists");
        List<String> ids = workFlow.getDataIds(bankUsersData);

        Reporter.info("Deleting data if it exists");
        ids.forEach(id -> {
            res = RestAssuredUtil.deleteResponse(id);
            Assert.assertEquals(res.getStatusCode(), SC_OK, "Delete petition failed!");
        });

        Reporter.info("Validate data set is empty");
        bankUsersData = workFlow.getAllDataSet(res, jsonPath);
        Assert.assertEquals(bankUsersData.size(), 0, "Data set is not empty");

        Reporter.info("TEST FINISH, empty data set---------------");
    }

    @Test(priority = 2)
    public void dataSetInitialize() {
        Reporter.info("TEST START, data set initialize---------------");

        Reporter.info("Creating a list of 10 new BankUserModel objects");
        List<BankUserModel> newUserBank = workFlow.bankUserListCreation(10);

        Reporter.info("Creating 10 new users");
        newUserBank.forEach(user -> {
            res = RestAssuredUtil.postResponse(user);
            Assert.assertEquals(res.getStatusCode(), SC_CREATED, "Post petition failed!");
        });

        Reporter.info("Getting data set");
        List<BankUserModel> bankUsersData = workFlow.getAllDataSet(res, jsonPath);

        Reporter.info("Validate data set is not empty");
        Assert.assertTrue(bankUsersData.size() > 0, "Data set is empty");

        Reporter.info("TEST FINISH, data set initialize---------------");
    }

    @Test(priority = 3)
    public void getDataSetWithoutDuplicity() {
        Reporter.info("TEST START, get all data set---------------");
        Reporter.info("TEST FINISH, get all data set---------------");
    }

    @Test(priority = 4)
    public void updateDataSet() {
        Reporter.info("TEST START, update data set---------------");

       /* BankUserModel bankUser = workFlow.getBankUser(res, "/1");

        System.out.println("user " + bankUser);*/

        Reporter.info("TEST FINISH, update data set---------------");
    }
}
