package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class searchController {
    private JButton searchButton;
    private JPanel searchControllerPanel;
    private JButton rewardButton;
    private JFrame frame = new JFrame();

    public searchController() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        rewardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void displayTableGui() {
        frame.getContentPane().add(searchControllerPanel);

        frame.setTitle("Phan mem quan ly can bo");
        searchControllerPanel.setBorder(new TitledBorder("Table"));

        frame.setVisible(true);
        frame.setSize(480, 240);
    }
}
