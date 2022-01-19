package coSoDuLieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static coSoDuLieu.connectionSwitch.*;

public class modifyTable {

    public static void insertElement(int director, String kieuCanBo, String name, int num) {
        String sqlStatement;

        switch (director) {
            case 1 -> sqlStatement = "INSERT INTO Bang_danh_sach_can_bo(Ho_ten,Kieu_can_bo,So_gio_giang_day) VALUES(?,?,?)";
            case 2 -> sqlStatement = "INSERT INTO Bang_danh_sach_can_bo(Ho_ten,Kieu_can_bo,So_bai_bao) VALUES(?,?,?)";
            case 3 -> sqlStatement = "INSERT INTO Bang_danh_sach_can_bo(Ho_ten,Kieu_can_bo,So_gio_phuc_vu) VALUES(?,?,?)";
            default -> {
                System.out.println("Error");
                return;
            }
        }

        if(!checkConnection()) {
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        try (Connection dbConnection = connect();
             PreparedStatement dbStatement = dbConnection.prepareStatement(sqlStatement)) {
            dbStatement.setString(1, name);
            dbStatement.setString(2, kieuCanBo);
            dbStatement.setInt(3, num);
            dbStatement.executeUpdate();
            System.out.println("Nhap du lieu vao database thanh cong");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteElement(int maSo) {
        if(!checkConnection()){
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        String sql = "DELETE FROM Bang_danh_sach_can_bo WHERE Ma_so_nhan_vien = ?";

        try (Connection dbConnection = connect();
             PreparedStatement dbStatement = dbConnection.prepareStatement(sql)) {
            dbStatement.setInt(1, maSo);
            dbStatement.executeUpdate();
            System.out.println("Da xoa thanh cong khoi bang");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateElement(int maSo, int director, String kieuCanBo, String name, int num) {
        String sqlStatement;
        String nullSqlStatement = "UPDATE Bang_danh_sach_can_bo SET " +
                "So_gio_giang_day = ? , So_bai_bao = ? , So_gio_phuc_vu = ? WHERE Ma_so_nhan_vien = ?";

        switch (director) {
            case 1 -> sqlStatement = "UPDATE Bang_danh_sach_can_bo SET Ho_ten = ? , Kieu_can_bo = ? , " +
                    "So_gio_giang_day = ? WHERE Ma_so_nhan_vien = ?";
            case 2 -> sqlStatement = "UPDATE Bang_danh_sach_can_bo SET Ho_ten = ? , Kieu_can_bo = ? , " +
                    "So_bai_bao = ? WHERE Ma_so_nhan_vien = ?";
            case 3 -> sqlStatement = "UPDATE Bang_danh_sach_can_bo SET Ho_ten = ? , Kieu_can_bo = ? , " +
                    "So_gio_phuc_vu = ? WHERE Ma_so_nhan_vien = ?";
            default -> {
                System.out.println("Error");
                return;
            }
        }

        if (!checkConnection()) {
            System.out.println("Chua ket noi toi database nao");
            return;
        }

        try (Connection dbConnection = connect();
             PreparedStatement dbStatement = dbConnection.prepareStatement(nullSqlStatement)) {
            dbStatement.setNull(1, java.sql.Types.NULL);
            dbStatement.setNull(2, java.sql.Types.NULL);
            dbStatement.setNull(3, java.sql.Types.NULL);
            dbStatement.setInt(4, maSo);
            dbStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try (Connection dbConnection = connect();
             PreparedStatement dbStatement = dbConnection.prepareStatement(sqlStatement)) {
            dbStatement.setString(1, name);
            dbStatement.setString(2, kieuCanBo);
            dbStatement.setInt(3, num);
            dbStatement.setInt(4, maSo);
            dbStatement.executeUpdate();
            System.out.println("Cap nhat du lieu vao database thanh cong");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
