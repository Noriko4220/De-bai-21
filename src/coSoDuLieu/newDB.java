package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static coSoDuLieu.createDB.newDB;

public class newDB {
    private JTextField nameField;
    private JPanel taoDB;
    private JButton createButton;
    final private JFrame newDBFrame = new JFrame();

    public newDB() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newDB(nameField.getText());
            }
        });
    }

    public void displayTableGui() {
        newDBFrame.getContentPane().add(taoDB);

        newDBFrame.setTitle("Phan mem quan ly can bo");
        taoDB.setBorder(new TitledBorder("Table"));

        newDBFrame.setVisible(true);
        newDBFrame.setSize(480, 240);
    }
}
