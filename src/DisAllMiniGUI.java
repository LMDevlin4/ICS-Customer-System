import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.MalformedInputException;
import java.util.*;

public class DisAllMiniGUI {
    private JLabel DAllLabel;
    private JTextField aIDTextField;
    private JLabel aIDLabel;
    private JButton BackButton;
    private JButton SubmitButton;
    private JPanel paneld1;
    private JFrame dAllMiniFrame = new JFrame("Display Matching Profile");

    private final CustomerProfInterface DB;

    public DisAllMiniGUI(CustomerProfInterface DB) {

        //Uses the correct database
        this.DB = DB;

        dAllMiniFrame.setContentPane(paneld1);
        dAllMiniFrame.setSize(500, 300);
        dAllMiniFrame.setLocationRelativeTo(null);
        dAllMiniFrame.setVisible(true);
        dAllMiniFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Button to go back to main menu
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dAllMiniFrame.setVisible(false);
                new MainMenuGUI(DB);
            }
        });

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Makes sure no field is left empty before action
                if (aIDTextField.getText().hashCode() == 0) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty! Please fill them in before submitting!");
                } else {
                    String admin = aIDTextField.getText();

                    ArrayList<String[]> customerMatches = DB.displayAllCustomerProf(admin);

                    if (customerMatches.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Profiles with this AdminID could NOT be found!");
                    } else {

                        dAllMiniFrame.setVisible(false);
                        int i = 0;
                        while (i < customerMatches.size()) {
                            new DisplayAllGUI(DB, customerMatches, i);
                            i++;
                        }

                    }

                }

            }
        });
    }
}
