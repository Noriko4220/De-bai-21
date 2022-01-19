import coSoDuLieu.rewardSearch;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class rewardMiniTable {
    private JTextField value;
    private JPanel rewardPanel;
    private JButton searchButton;
    private JFrame frame = new JFrame();

    public rewardMiniTable() {
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rewardSearch rewardsearch = new rewardSearch();
            }
        });
    }

    public void displayTableGui() {
        frame.getContentPane().add(rewardPanel);

        frame.setTitle("Phan mem quan ly can bo");
        rewardPanel.setBorder(new TitledBorder("Table"));

        frame.setVisible(true);
        frame.setSize(480, 180);
    }
}
