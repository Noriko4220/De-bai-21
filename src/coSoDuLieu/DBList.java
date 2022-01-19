package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.io.File;

public class DBList {
    private String[] DBList;
    private JList list1;
    private JPanel Dblist;
    final private JFrame tableFrame = new JFrame();
    private File DBScanner = new File("db");

    public void displayTableGui() {
        DBList = DBScanner.list();

        assert DBList != null : "Khong co database nao trong danh sach";

        tableFrame.getContentPane().add(Dblist);
        tableFrame.add(new JList(DBList));

        tableFrame.setTitle("Phan mem quan ly can bo");
        Dblist.setBorder(new TitledBorder("Table"));

        tableFrame.setVisible(true);
        tableFrame.setSize(240, 480);
    }
}
