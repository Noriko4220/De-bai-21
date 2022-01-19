package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class showMiniTableGui {
    private JButton teachButton;
    private JButton researchButton;
    private JButton serviceButton;
    private JPanel selectButton;
    private JFrame connectFrame = new JFrame();

    public showMiniTableGui() {
        teachButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTableGui showtablegui = new showTableGui();
                showtablegui.displayTableGui();
                rewardSearch rewardsearch = new rewardSearch();
                rewardsearch.displayMiniTable("Giang day");
            }
        });

        researchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTableGui showtablegui = new showTableGui();
                showtablegui.displayTableGui();
                rewardSearch rewardsearch = new rewardSearch();
                rewardsearch.displayMiniTable("Nghien cuu");
            }
        });

        serviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTableGui showtablegui = new showTableGui();
                showtablegui.displayTableGui();
                rewardSearch rewardsearch = new rewardSearch();
                rewardsearch.displayMiniTable("Phuc vu");
            }
        });

    }

    public void displayTableGui() {
        connectFrame.getContentPane().add(selectButton);

        connectFrame.setTitle("Phan mem quan ly can bo");
        selectButton.setBorder(new TitledBorder("Table"));

        connectFrame.setVisible(true);
        connectFrame.setSize(480, 180);
    }
}
