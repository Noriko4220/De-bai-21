package coSoDuLieu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static coSoDuLieu.createTable.newTable;

public class createDB {
    public static void newDB (String fileName) {

        String url = "jdbc:sqlite:db/" + fileName + ".db";

        try (Connection DBconnection = DriverManager.getConnection(url)) {
            if (DBconnection != null) {
                newTable(fileName);
                System.out.println("Da khoi tao thanh cong database");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}