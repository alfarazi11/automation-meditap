package utils;

import java.io.File;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class DataUtility {

    static String dataFilePath = System.getProperty("user.dir") + File.separator + "resources" + File.separator
            + "TestDataStag.csv";

    public static String getDataFromExcel(String sheetName, String ID) {
        String result = "";
        Connection connection;
        try {
            Fillo fillo = new Fillo();
            connection = fillo.getConnection(dataFilePath);
            String strQuery = "Select * from " + sheetName + " where ID='" + ID + "'";
            Recordset recordset = connection.executeQuery(strQuery);
            while (recordset.next()) {
                result = recordset.getField("Value");
            }
            recordset.close();
            connection.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return result;
    }
}
