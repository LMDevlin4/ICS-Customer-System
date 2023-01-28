import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayGUI {
    private JPanel panelDisplay;
    private JLabel CreateLabel;
    private JLabel VinfLabel;
    private JButton BackButton;
    private JTextField aIDTextField;
    private JTextField FNTextField;
    private JTextField LNTextField;
    private JTextField AddTextField;
    private JTextField PhnTextField;
    private JTextField IncTextField;
    private JTextField UseTextField;
    private JTextField StatusTextField;
    private JLabel UseLabel;
    private JLabel StatusLabel;
    private JLabel YearLabel;
    private JLabel TypeLabel;
    private JLabel MethodLabel;
    private JTextField ModelTextField;
    private JTextField YearTextField;
    private JTextField TypeTextField;
    private JTextField MethodTextField;
    private JLabel IncLabel;
    private JLabel PhnLabel;
    private JLabel AddLabel;
    private JLabel LNLabel;
    private JLabel FNLabel;
    private JLabel aIDLabel;

    private JFrame displayFrame = new JFrame("Display Profile");

    private final CustomerProfInterface DB;

    public DisplayGUI(CustomerProfInterface DB, String cusInfo[]) {

        //Uses the correct database
        this.DB = DB;

        //Set proper text fields
        aIDTextField.setText(cusInfo[0]);
        FNTextField.setText(cusInfo[1]);
        LNTextField.setText(cusInfo[2]);
        AddTextField.setText(cusInfo[3]);
        PhnTextField.setText(cusInfo[4]);
        IncTextField.setText(cusInfo[5]);
        StatusTextField.setText(cusInfo[6]);
        UseTextField.setText(cusInfo[7]);
        ModelTextField.setText(cusInfo[8]);
        YearTextField.setText(cusInfo[9]);
        TypeTextField.setText(cusInfo[10]);
        MethodTextField.setText(cusInfo[11]);

        displayFrame.setContentPane(panelDisplay);
        displayFrame.setSize(800, 650);
        displayFrame.setLocationRelativeTo(null);
        displayFrame.setVisible(true);
        displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Button to go back to main menu
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFrame.setVisible(false);
                new FindDisGUI(DB);
            }
        });
    }
}
