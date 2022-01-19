package coSoDuLieu;

import javax.swing.*;
import javax.swing.border.TitledBorder;


public class tableGui extends JFrame{
    private JPanel panelMain;
    private JButton button1;
    private JTable table1;
    private JButton button2;
    private JButton button3;

    public void displayTableGui() {

        getContentPane().add(panelMain);

        setTitle("Phan mem quan ly can bo");
        panelMain.setBorder(new TitledBorder("Table"));



        setVisible(true);
        setSize(1280, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}