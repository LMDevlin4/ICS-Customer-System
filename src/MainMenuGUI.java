import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class MainMenuGUI {
    private JRadioButton createProfileRadioButton;
    private JRadioButton deleteProfileRadioButton;
    private JRadioButton updateProfileRadioButton;
    private JRadioButton findDisplayProfileRadioButton;
    private JRadioButton displayAllProfilesRadioButton;
    private JLabel ICSLabel;
    private JButton selectButton;
    private JPanel panelMenu;
    private JFrame menuFrame = new JFrame("Main Menu");

    //DB to be used
    private final CustomerProfInterface DB;

    public MainMenuGUI(CustomerProfInterface DB) {

        this.DB = DB;

        menuFrame.setContentPane(panelMenu);
        menuFrame.setSize(800, 650);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (createProfileRadioButton.isSelected()) {
                    menuFrame.setVisible(false);
                    new CreateProfileGUI(DB);
                }

                if (deleteProfileRadioButton.isSelected()) {
                    menuFrame.setVisible(false);
                    new DeleteProfileGUI(DB);
                }

                if (updateProfileRadioButton.isSelected()) {
                    menuFrame.setVisible(false);
                    new UpdateProfileGUI(DB);
                }

                if (findDisplayProfileRadioButton.isSelected()) {
                    menuFrame.setVisible(false);
                    new FindDisGUI(DB);
                }

                if (displayAllProfilesRadioButton.isSelected()) {
                    menuFrame.setVisible(false);
                    new DisAllMiniGUI(DB);
                }


            }


        });
    }

    public static void main(String args[]) {
        //new MainMenuGUI();
    }


}
