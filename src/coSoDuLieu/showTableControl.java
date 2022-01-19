package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showTableControl {
    private JButton showAllButton;
    private JButton showSortButton;
    private JPanel controlShow;
    private JFrame jframe = new JFrame();

    public showTableControl() {
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTableGui showtablegui = new showTableGui();
                showtablegui.displayTableGui();
                rewardSearch rewardsearch = new rewardSearch();
                rewardsearch.displayTable();
            }
        });

        showSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMiniTableGui showminitablegui = new showMiniTableGui();
                showminitablegui.displayTableGui();
            }
        });
    }

    public void displayTableGui() {
        jframe.getContentPane().add(controlShow);

        jframe.setTitle("Phan mem quan ly can bo");
        controlShow.setBorder(new TitledBorder("Table"));

        jframe.setVisible(true);
        jframe.setSize(480, 240);
    }
}
