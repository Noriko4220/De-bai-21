package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class databaseGui {
    final private JFrame tableFrame = new JFrame();
    private JPanel dbGui;
    private JButton DBList;
    private JButton newDB;

    public databaseGui() {
        DBList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DBList dbList = new DBList();
                dbList.displayTableGui();
            }
        });

        newDB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newDB newdb = new newDB();
                newdb.displayTableGui();
            }
        });
    }

    public void displayTableGui() {
        tableFrame.getContentPane().add(dbGui);

        tableFrame.setTitle("Phan mem quan ly can bo");
        dbGui.setBorder(new TitledBorder("Table"));

        tableFrame.setVisible(true);
        tableFrame.setSize(480, 240);
    }
}
