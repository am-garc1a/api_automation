package util.tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.BankUserModel;

import java.util.ArrayList;
import java.util.List;

public class WorkFlow {

    /**
     * Get all date set method.
     *
     * @param res      : http response
     * @param jsonPath : json path
     * @return : all data as BankUserModel object
     */
    public List<BankUserModel> getAllDataSet(Response res, JsonPath jsonPath) {
        res = RestAssuredUtil.getResponse();
        jsonPath = res.jsonPath();
        return jsonPath.getList("", BankUserModel.class);
    }

    /**
     * Get data set ids.
     *
     * @param bankUsersData : List of bankUsersData
     */
    public List<String> getDataIds(List<BankUserModel> bankUsersData) {
        List<String> ids = new ArrayList<>();

        if (bankUsersData.size() > 0) {
            for (BankUserModel userBank : bankUsersData) {
                ids.add(userBank.getId());
            }
        }

        return ids;
    }

}
