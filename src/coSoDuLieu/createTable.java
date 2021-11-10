package coSoDuLieu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {
    public static void newTable(String database) {
        String url = "jdbc:sqlite:db/" + database + ".db";
        String sql = """
                CREATE TABLE IF NOT EXISTS Bang_danh_sach_can_bo (
                	Ma_so_nhan_vien integer PRIMARY KEY,
                	Ho_ten text NOT NULL,
                	Kieu_can_bo text NOT NULL,
                	So_gio_giang_day integer,
                	So_bai_bao integer,
                	So_gio_phuc_vu integer
                );""";

        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
