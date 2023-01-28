import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpPhnGUI {
    private JPanel panelUpdate;
    private JLabel UpdateLabel;
    private JLabel aIDLabel;
    private JLabel LNLabel;
    private JLabel UpfLabel;
    private JButton SubmitButton;
    private JButton BackButton;
    private JLabel aIDLabelE;
    private JLabel LNLabelE;
    private JTextField UpTextField;

    private String admin;
    private String last;

    private JFrame updateFrame = new JFrame("Update Profile");

    private final CustomerProfInterface DB;

    public UpPhnGUI(CustomerProfInterface DB, String admin, String last) {

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

        //Makes Sure phone is entered as a number
        UpTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Makes sure no field is left empty before updating
                if (UpTextField.hashCode() == 0) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty! Please fill them in before submitting!");
                } else {

                    //Update Customer from database
                    String address = UpTextField.getText();

                    if (DB.updateCustomerProf(admin, last, 2, address) == 1) {
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
