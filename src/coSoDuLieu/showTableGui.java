package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class showTableGui {

    private JFrame frame;
    private JPanel tableView;
    private JTable dataTable;
    private JScrollPane scrollName;

    public showTableGui() {
        DefaultTableModel model = new DefaultTableModel();

        dataTable.setAutoCreateRowSorter(true);
        dataTable.setFillsViewportHeight(true);
        dataTable.setPreferredScrollableViewportSize(new Dimension(550, 200));
        model.addColumn("Id");
        model.addColumn("Tên nhân viên");
        model.addColumn("Kiểu cán bộ");
        model.addColumn("Số giờ giảng dạy");
        model.addColumn("Số bài báo");
        model.addColumn("Số giờ phục vụ");
        dataTable.setModel(model);
    }

    public void displayTableGui() {
        frame = new JFrame("TableGUI");
        frame.getContentPane().add(new showTableGui().dataTable);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(600, 400));
    }
}
