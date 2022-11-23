package tests;

import org.testng.annotations.Test;

import model.BankUserModel;

import util.tests.BaseTest;
import util.tests.RestAssuredUtil;
import util.repoter.Reporter;

import java.util.List;

/**
 * Class for testing data set.
 */
public class DataSetTest extends BaseTest {

    @Test(priority = 1)
    public void emptyDataSet() {
        Reporter.info("TEST START, empty data set---------------");

        String path = "";

        res = RestAssuredUtil.getResponse();

        Reporter.info("Validate status of get data set");
        isStatus200(res);

        jsonPath = res.jsonPath();
        List<BankUserModel> bankUsersData = jsonPath.getList(path, BankUserModel.class);

        for (BankUserModel userBank : bankUsersData) {
            System.out.println(userBank);
        }

        Reporter.info("TEST FINISH, empty data set---------------");
    }

    @Test(priority = 2)
    public void dataSetInitialize() {
        Reporter.info("TEST START, data set initialize---------------");
        Reporter.info("TEST FINISH, data set initialize---------------");
    }

    @Test(priority = 3)
    public void getAllDataSet() {
        Reporter.info("TEST START, get all data set---------------");
        Reporter.info("TEST FINISH, get all data set---------------");
    }

    @Test(priority = 4)
    public void updateDataSet() {
        Reporter.info("TEST START, update data set---------------");
        Reporter.info("TEST FINISH, update data set---------------");
    }
}
