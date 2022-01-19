package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controlPanelGui {
    private JButton showButton;
    private JPanel controlPanel;
    private JButton deleteButton;
    private JButton insertButton;
    private JButton searchButton;
    final private JFrame controlPanelFrame = new JFrame();

    public controlPanelGui() {
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTableControl showtablecontrol = new showTableControl();
                showtablecontrol.displayTableGui();
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                insertElementController insertelementcontroller = new insertElementController();
                insertelementcontroller.displayTableGui();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteGui deletegui = new deleteGui();
                deletegui.displayTableGui();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchController searchcontroller = new searchController();
                searchcontroller.displayTableGui();
            }
        });
    }

    public void displayTableGui() {
        controlPanelFrame.getContentPane().add(controlPanel);

        controlPanelFrame.setTitle("Phan mem quan ly can bo");
        controlPanel.setBorder(new TitledBorder("Table"));

        controlPanelFrame.setVisible(true);
        controlPanelFrame.setSize(480, 480);
    }
}
