import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpAddGUI {
    private JButton SubmitButton;
    private JButton BackButton;
    private JLabel aIDLabelE;
    private JLabel LNLabelE;
    private JTextField UpTextField;
    private JPanel panelUpdate;
    private JLabel UpdateLabel;
    private JLabel aIDLabel;
    private JLabel LNLabel;
    private JLabel UpfLabel;

    private String admin;
    private String last;

    private JFrame updateFrame = new JFrame("Update Profile");

    private final CustomerProfInterface DB;

    public UpAddGUI(CustomerProfInterface DB, String admin, String last) {

        //Uses the correct database, admin, and last name
        this.DB = DB;
        this.admin = admin;
        this.last = last;

        aIDLabelE.setText(String.valueOf(admin));
        LNLabelE.setText(String.valueOf(last));

        updateFrame.setContentPane(panelUpdate);
        updateFrame.setSize(500, 300);
        updateFrame.setLocationRelativeTo(null);
        updateFrame.setVisible(true);
        updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Button to go back to Update menu
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame.setVisible(false);
                new UpdateProfileGUI(DB);
            }
        });

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Makes sure no field is left empty before updating
                if (UpTextField.getText().hashCode() == 0) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty! Please fill them in before submitting!");
                } else {

                    //Update Customer from database
                    String address = UpTextField.getText();

                    if (DB.updateCustomerProf(admin, last, 1, address) == 1) {
                        JOptionPane.showMessageDialog(null, "Profile has successfully been Updated!");
                        } else {
                        JOptionPane.showMessageDialog(null, "Profile does not exist and cannot be updated");
                    };
                    DB.writeToDB();

                    //Clear Text Fields and reset combo Boxes
                    UpTextField.setText(null);
                }
            }
        });
    }
}
