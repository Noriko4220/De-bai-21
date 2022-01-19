package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static coSoDuLieu.modifyTable.deleteElement;

public class deleteGui {
    private JTextField idfield;
    private JPanel deletePanel;
    private JButton deleteButton;
    final private JFrame deleteFrame = new JFrame();

    public deleteGui() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(idfield.getText());
                deleteElement(value);
            }
        });
    }

    public void displayTableGui() {
        deleteFrame.getContentPane().add(deletePanel);

        deleteFrame.setTitle("Phan mem quan ly can bo");
        deletePanel.setBorder(new TitledBorder("Table"));

        deleteFrame.setVisible(true);
        deleteFrame.setSize(480, 240);
    }
}
