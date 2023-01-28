import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateProfileGUI {
    private JPanel panelUpdate;
    private JLabel aIDLabel;
    private JButton SubmitButton;
    private JButton BackButton;
    private JLabel UpdateLabel;
    private JTextField aIDTextField;
    private JLabel LNLabel;
    private JTextField LNTextField;
    private JLabel UpfLabel;
    private JComboBox UpfComboBox;
    private JFrame updateFrame = new JFrame("Update Profile");

    private final CustomerProfInterface DB;

    public UpdateProfileGUI(CustomerProfInterface DB) {

        //Uses the correct database
        this.DB = DB;

        updateFrame.setContentPane(panelUpdate);
        updateFrame.setSize(500, 300);
        updateFrame.setLocationRelativeTo(null);
        updateFrame.setVisible(true);
        updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Button to go back to main menu
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame.setVisible(false);
                new MainMenuGUI(DB);
            }
        });

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Makes sure no field is left empty before updating
                if (aIDTextField.getText().hashCode() == 0 || LNTextField.getText().hashCode() == 0 || UpfComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty! Please fill them in before submitting!");
                } else {

                    String admin = aIDTextField.getText();
                    String last = LNTextField.getText();
                    int tobeUp = UpfComboBox.getSelectedIndex();

                    if (tobeUp == 1){
                        updateFrame.setVisible(false);
                        new UpAddGUI(DB, admin, last);
                    }

                    if (tobeUp == 2){
                        updateFrame.setVisible(false);
                        new UpPhnGUI(DB, admin, last);

                    }

                    if (tobeUp == 3){
                        updateFrame.setVisible(false);
                        new UpUseGUI(DB, admin, last);

                    }

                    if (tobeUp == 4){
                        updateFrame.setVisible(false);
                        new UpStatusGUI(DB, admin, last);


                    }

                    if (tobeUp == 5){
                        updateFrame.setVisible(false);
                        new UpModelGUI(DB, admin, last);

                    }

                    if (tobeUp == 6){
                        updateFrame.setVisible(false);
                        new UpYearGUI(DB, admin, last);

                    }

                    if (tobeUp == 7){
                        updateFrame.setVisible(false);
                        new UpTypeGUI(DB, admin, last);

                    }

                    if (tobeUp == 8){
                        updateFrame.setVisible(false);
                        new UpMethodGUI(DB, admin, last);

                    }

                    if (tobeUp == 9){
                        updateFrame.setVisible(false);
                        new UpIncGUI(DB, admin, last);
                    }


                    //Clear Text Fields and reset combo Boxes
                    aIDTextField.setText(null);
                    LNTextField.setText(null);
                }
            }
        });
    }

}
