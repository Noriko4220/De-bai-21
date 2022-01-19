package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import static coSoDuLieu.connectionSwitch.connect;


public class connectGui {
    private JLabel nameLabel;
    private JPanel connectPanel;
    private JButton connectionButton;
    private JButton databaseButton;
    private JTextField dbNameInput;
    final private JFrame connectFrame = new JFrame();
    final private File DBScanner = new File("db");
    private String[] DBList;

    public connectGui() {
        databaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                databaseGui databaseGui = new databaseGui();
                databaseGui.displayTableGui();
            }
        });

        connectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean dbname = false;
                DBList = DBScanner.list();
                for (String DBListUnit : DBList) {
                    if (DBListUnit.equals(dbNameInput.getText() + ".db")) {
                        dbname = true;
                        break;
                    }
                }
                if (dbname) {
                    connect(dbNameInput.getText());
                    controlPanelGui controlpanelgui = new controlPanelGui();
                    controlpanelgui.displayTableGui();
                }
            }
        });
    }

    public void displayTableGui() {
        connectFrame.getContentPane().add(connectPanel);

        connectFrame.setTitle("Phan mem quan ly can bo");
        connectPanel.setBorder(new TitledBorder("Table"));

        connectFrame.setVisible(true);
        connectFrame.setSize(480, 240);
    }
}