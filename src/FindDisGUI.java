import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindDisGUI {
    private JPanel panelFind;
    private JLabel FindLabel;
    private JLabel aIDLabel;
    private JTextField aIDTextField;
    private JButton SubmitButton;
    private JTextField LNTextField;
    private JLabel LNLabel;
    private JButton BackButton;

    private JFrame findFrame = new JFrame("Find Profile");

    private final CustomerProfInterface DB;

    public FindDisGUI(CustomerProfInterface DB) {

        //Uses the correct database
        this.DB = DB;

        findFrame.setContentPane(panelFind);
        findFrame.setSize(500, 300);
        findFrame.setLocationRelativeTo(null);
        findFrame.setVisible(true);
        findFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Button to go back to main menu
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findFrame.setVisible(false);
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

                    if (DB.findCustomerProf(admin, last) == null) {
                        JOptionPane.showMessageDialog(null, "This profile cannot be found");
                    } else {
                        findFrame.setVisible(false);
                        new DisplayGUI(DB, DB.findCustomerProf(admin, last));

                        //Clear Text Fields and reset combo Boxes
                        aIDTextField.setText(null);
                        LNTextField.setText(null);
                    }
                }
            }
        });
    }
}
