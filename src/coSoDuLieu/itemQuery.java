package coSoDuLieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static coSoDuLieu.connectionSwitch.connect;
import static coSoDuLieu.connectionSwitch.checkConnection;

public class itemQuery {

    public static void displayTable(){
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

    public static void filteredSearch(int typeDirector, int searchModifier, int value) {
        if(!checkConnection()){
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        String searchType;
        String modifierType;

        switch (typeDirector) {
            case 1 -> searchType = "So_gio_giang_day";
            case 2 -> searchType = "So_bai_bao";
            case 3 -> searchType = "So_gio_phuc_vu";
            case 4 -> searchType = "Ma_so_nhan_vien";
            default -> {
                System.out.println("Error");
                return;
            }
        }

        switch (searchModifier) {
            case 1 -> modifierType = ">";
            case 2 -> modifierType = "<";
            case 3 -> modifierType = "=";
            default -> {
                System.out.println("Error");
                return;
            }
        }

        String sqlStatement = "SELECT Ma_so_nhan_vien, Ho_ten, Kieu_can_bo, So_gio_giang_day, So_bai_bao, So_gio_phuc_vu " +
                     "FROM Bang_danh_sach_can_bo WHERE " + searchType + " " + modifierType + " ?";

        try (Connection dbConnection = connect();
             PreparedStatement dbStatement  = dbConnection.prepareStatement(sqlStatement)){

            dbStatement.setInt(1,value);
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

    public static void khenThuongGiangDay(int soGioGiangDayChuan) {
        if(!checkConnection()){
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        int soGioGiangDay = soGioGiangDayChuan * 5/4;
        String sqlStatement = "SELECT Ma_so_nhan_vien, Ho_ten, Kieu_can_bo, So_gio_giang_day, So_bai_bao, So_gio_phuc_vu " +
                "FROM Bang_danh_sach_can_bo WHERE So_gio_giang_day > ?";

        try (Connection dbConnection = connect();
             PreparedStatement dbStatement  = dbConnection.prepareStatement(sqlStatement)){

            dbStatement.setInt(1,soGioGiangDay);
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

    public static void khenThuongBao(int soBaiBaoChuan) {
        if(!checkConnection()){
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        int soBaiBao = soBaiBaoChuan + 2;
        String sqlStatement = "SELECT Ma_so_nhan_vien, Ho_ten, Kieu_can_bo, So_gio_giang_day, So_bai_bao, So_gio_phuc_vu " +
                "FROM Bang_danh_sach_can_bo WHERE So_bai_bao > ?";

        try (Connection dbConnection = connect();
             PreparedStatement dbStatement  = dbConnection.prepareStatement(sqlStatement)){

            dbStatement.setInt(1,soBaiBao);
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

    public static void khenThuongPhucVu(int soGioPhucVuChuan) {
        if(!checkConnection()){
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        int soGioPhucVu = soGioPhucVuChuan + 2;
        String sqlStatement = "SELECT Ma_so_nhan_vien, Ho_ten, Kieu_can_bo, So_gio_giang_day, So_bai_bao, So_gio_phuc_vu " +
                "FROM Bang_danh_sach_can_bo WHERE So_gio_phuc_vu > ?";

        try (Connection dbConnection = connect();
             PreparedStatement dbStatement  = dbConnection.prepareStatement(sqlStatement)){

            dbStatement.setInt(1,soGioPhucVu);
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
}