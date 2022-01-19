package coSoDuLieu;

import java.sql.*;
import java.sql.SQLException;

import static coSoDuLieu.connectionSwitch.checkConnection;
import static coSoDuLieu.connectionSwitch.connect;

public class rewardSearch extends itemQuery {

    public void filteredSearch(String searchType, int value) {
        if(!checkConnection()){
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        String sqlStatement = "SELECT Ma_so_nhan_vien, Ho_ten, Kieu_can_bo, So_gio_giang_day, So_bai_bao, So_gio_phuc_vu " +
                "FROM Bang_danh_sach_can_bo WHERE " + searchType + " > ?";

        try (Connection dbConnection = connect();
             PreparedStatement dbStatement  = dbConnection.prepareStatement(sqlStatement)){

            dbStatement.setInt(1, value);
            ResultSet itemQuery  = dbStatement.executeQuery();

            System.out.printf("%-20s", "Ma so nhan vien");
            System.out.printf("%-20s", "Ho ten");
            System.out.printf("%-20s", "Kieu can bo");
            System.out.printf("%-20s", "So gio giang day");
            System.out.printf("%-20s", "So bai bao");
            System.out.printf("%-20s", "So gio phuc vu");
            System.out.println();

            while (itemQuery.next()) {
                System.out.printf("%-20s", itemQuery.getInt("Ma_so_nhan_vien"));
                System.out.printf("%-20s", itemQuery.getString("Ho_ten"));
                System.out.printf("%-20s", itemQuery.getString("Kieu_can_bo"));
                System.out.printf("%-20s", itemQuery.getInt("So_gio_giang_day"));
                System.out.printf("%-20s", itemQuery.getInt("So_bai_bao"));
                System.out.printf("%-20s", itemQuery.getInt("So_gio_phuc_vu"));
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println(sqlStatement);
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void displayTable() {
        if(!checkConnection()){
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        String sqlStatement = "SELECT Ma_so_nhan_vien, Ho_ten, Kieu_can_bo, So_gio_giang_day, So_bai_bao, So_gio_phuc_vu FROM Bang_danh_sach_can_bo";
        try (Connection dbConnection = connect();
             Statement dbStatement  = dbConnection.createStatement();
             ResultSet itemQuery    = dbStatement.executeQuery(sqlStatement)){

            System.out.printf("%-20s", "Ma so nhan vien");
            System.out.printf("%-20s", "Ho ten");
            System.out.printf("%-20s", "Kieu can bo");
            System.out.printf("%-20s", "So gio giang day");
            System.out.printf("%-20s", "So bai bao");
            System.out.printf("%-20s", "So gio phuc vu");
            System.out.println();

            while (itemQuery.next()) {
                System.out.printf("%-20s", itemQuery.getInt("Ma_so_nhan_vien"));
                System.out.printf("%-20s", itemQuery.getString("Ho_ten"));
                System.out.printf("%-20s", itemQuery.getString("Kieu_can_bo"));
                System.out.printf("%-20s", itemQuery.getInt("So_gio_giang_day"));
                System.out.printf("%-20s", itemQuery.getInt("So_bai_bao"));
                System.out.printf("%-20s", itemQuery.getInt("So_gio_phuc_vu"));
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayMiniTable() {
        displayMiniTable("Giang day");
        displayMiniTable("Nghien cuu");
        displayMiniTable("Phuc vu");
    }

    private void displayMiniTable (String searchType) {
        if(!checkConnection()){
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        String sqlStatement = "SELECT Ma_so_nhan_vien, Ho_ten, Kieu_can_bo, So_gio_giang_day, So_bai_bao, So_gio_phuc_vu FROM Bang_danh_sach_can_bo";
        try (Connection dbConnection = connect();
             Statement dbStatement  = dbConnection.createStatement();
             ResultSet itemQuery    = dbStatement.executeQuery(sqlStatement)){

            System.out.printf("%-20s", "Ma so nhan vien");
            System.out.printf("%-20s", "Ho ten");
            System.out.printf("%-20s", "Kieu can bo");
            switch(searchType) {
                case "Giang day" -> System.out.printf("%-20s", "So gio giang day");
                case "Nghien cuu" -> System.out.printf("%-20s", "So bai bao");
                default -> System.out.printf("%-20s", "So gio phuc vu");
            }
            System.out.println();

            while (itemQuery.next()) {
                System.out.printf("%-20s", itemQuery.getInt("Ma_so_nhan_vien"));
                System.out.printf("%-20s", itemQuery.getString("Ho_ten"));
                System.out.printf("%-20s", itemQuery.getString("Kieu_can_bo"));
                switch(searchType) {
                    case "Giang day" -> System.out.printf("%-20s", itemQuery.getInt("So_gio_giang_day"));
                    case "Nghien cuu" -> System.out.printf("%-20s", itemQuery.getInt("So_bai_bao"));
                    default -> System.out.printf("%-20s", itemQuery.getInt("So_gio_phuc_vu"));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
