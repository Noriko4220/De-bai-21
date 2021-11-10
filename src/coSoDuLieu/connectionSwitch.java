package coSoDuLieu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionSwitch {
    static String databaseName;

    public static void connect(String database) {
        databaseName = database;
        Connection dbConnection = null;
        try {
            String url = "jdbc:sqlite:db/" + database + ".db";
            dbConnection = DriverManager.getConnection(url);
            System.out.println("Ket noi toi database " + database + " thanh cong");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection connect() {
        Connection dbConnection = null;
        try {
            String url = "jdbc:sqlite:db/" + databaseName + ".db";
            dbConnection = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return dbConnection;
    }

    public static void disconnect() {
        try {
            String url = "jdbc:sqlite:db/" + databaseName + ".db";
            if (databaseName != null) {
                Connection dbConnection = DriverManager.getConnection(url);
                dbConnection.close();
                System.out.println("Da ngat ket noi toi database " + databaseName);
                databaseName = null;
            } else {
                System.out.println("Hien khong ket noi toi database nao");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkConnection() {
        return databaseName != null;
    }

    public static String connectedDatabase() {
        return databaseName;
    }
}
