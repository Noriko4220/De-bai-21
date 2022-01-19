package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertElementController {
    private JButton teachButton;
    private JButton researchButton;
    private JButton serviceButton;
    private JPanel controlPanel;
    private static int controllerNum = 1;
    private JFrame connectFrame = new JFrame();

    public insertElementController() {
        teachButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setGiangDay();
                insertElement insertelement = new insertElement();
                insertelement.displayTableGui();
            }
        });

        researchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNghienCuu();
                insertElement insertelement = new insertElement();
                insertelement.displayTableGui();
            }
        });

        serviceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPhucVu();
                insertElement insertelement = new insertElement();
                insertelement.displayTableGui();
            }
        });
    }

    public void displayTableGui() {
        connectFrame.getContentPane().add(controlPanel);

        connectFrame.setTitle("Phan mem quan ly can bo");
        controlPanel.setBorder(new TitledBorder("Table"));

        connectFrame.setVisible(true);
        connectFrame.setSize(480, 180);
    }

    private static void setGiangDay() {
        controllerNum = 1;
    }

    private static void setNghienCuu() {
        controllerNum = 2;
    }

    private static void setPhucVu() {
        controllerNum = 3;
    }

    public static int getControllerNum() {
        return controllerNum;
    }
}
