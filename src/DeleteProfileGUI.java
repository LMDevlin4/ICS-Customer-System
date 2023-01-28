import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class DeleteProfileGUI {
    private JPanel panelDelete;
    private JLabel DeleteLabel;
    private JLabel aIDLabel;
    private JLabel LNLabel;
    private JTextField aIDTextField;
    private JButton BackButton;
    private JButton SubmitButton;
    private JTextField LNTextField;

    private JFrame deleteFrame = new JFrame("Delete Profile");

    private final CustomerProfInterface DB;

    public DeleteProfileGUI(CustomerProfInterface DB) {

        //Uses the correct database
        this.DB = DB;

        deleteFrame.setContentPane(panelDelete);
        deleteFrame.setSize(500, 300);
        deleteFrame.setLocationRelativeTo(null);
        deleteFrame.setVisible(true);
        deleteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Button to go back to main menu
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFrame.setVisible(false);
                new MainMenuGUI(DB);
            }
        });

        SubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Makes sure no field is left empty before deleting from database
                if (aIDTextField.getText().hashCode() == 0 || LNTextField.getText().hashCode() == 0) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty! Please fill them in before submitting!");
                } else {

                    String admin = aIDTextField.getText();
                    String last = LNTextField.getText();

                    //Delete Customer from database
                    if (DB.deleteCustomerProf(admin, last)) {
                        JOptionPane.showMessageDialog(null, "Profile has successfully been deleted!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Profile does not exist and cannot be deleted");
                    }
                    DB.writeToDB();

                    //Clear Text Fields and reset combo Boxes
                    aIDTextField.setText(null);
                    LNTextField.setText(null);
                }
            }
        });
    }

}
