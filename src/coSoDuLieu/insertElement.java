package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static coSoDuLieu.insertElementController.getControllerNum;
import static coSoDuLieu.modifyTable.insertElement;

public class insertElement {
    private JTextField namefield;
    private JPanel insertPanel;
    private JButton updateButton;
    private JTextField typefield;
    private JTextField valuefield;
    private JLabel value;
    private JLabel name;
    private JLabel type;
    private JFrame frame = new JFrame();

    public insertElement() {
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertElement(getControllerNum(), typefield.getText(), namefield.getText(), Integer.parseInt(valuefield.getText()));
            }
        });
    }

    public void displayTableGui() {
        frame.getContentPane().add(insertPanel);

        frame.setTitle("Phan mem quan ly can bo");
        insertPanel.setBorder(new TitledBorder("Table"));

        frame.setVisible(true);
        frame.setSize(480, 480);
    }
}
