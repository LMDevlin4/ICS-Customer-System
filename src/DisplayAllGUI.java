import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class DisplayAllGUI {
    private JPanel panelDisplayAll;
    private JLabel CreateLabel;
    private JLabel aIDLabel;
    private JTextField aIDTextField;
    private JTextField FNTextField;
    private JLabel FNLabel;
    private JLabel LNLabel;
    private JTextField LNTextField;
    private JLabel AddLabel;
    private JTextField AddTextField;
    private JLabel PhnLabel;
    private JTextField PhnTextField;
    private JLabel IncLabel;
    private JTextField IncTextField;
    private JLabel VinfLabel;
    private JLabel UseLabel;
    private JTextField UseTextField;
    private JLabel StatusLabel;
    private JTextField StatusTextField;
    private JTextField ModelTextField;
    private JLabel YearLabel;
    private JTextField YearTextField;
    private JLabel TypeLabel;
    private JTextField TypeTextField;
    private JTextField MethodTextField;
    private JLabel MethodLabel;
    private JButton NextButton;
    private JButton BackButton;
    private JFrame dAllFrame = new JFrame("Display Profiles");


    private final CustomerProfInterface DB;

    public DisplayAllGUI(CustomerProfInterface DB, ArrayList<String[]> customerMatches, int i) {

        //Uses the correct database
        this.DB = DB;

        aIDTextField.setText(customerMatches.get(i)[0]);
        FNTextField.setText(customerMatches.get(i)[1]);
        LNTextField.setText(customerMatches.get(i)[2]);
        AddTextField.setText(customerMatches.get(i)[3]);
        PhnTextField.setText(customerMatches.get(i)[4]);
        IncTextField.setText(customerMatches.get(i)[5]);
        StatusTextField.setText(customerMatches.get(i)[6]);
        UseTextField.setText(customerMatches.get(i)[7]);
        ModelTextField.setText(customerMatches.get(i)[8]);
        YearTextField.setText(customerMatches.get(i)[9]);
        TypeTextField.setText(customerMatches.get(i)[10]);
        MethodTextField.setText(customerMatches.get(i)[11]);

        dAllFrame.setContentPane(panelDisplayAll);
        dAllFrame.setSize(800, 650);
        dAllFrame.setLocationRelativeTo(null);
        dAllFrame.setVisible(true);
        dAllFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dAllFrame.setVisible(false);
            }
        });

        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dAllFrame.setVisible(false);
                new MainMenuGUI(DB);
            }
        });
    }
}
