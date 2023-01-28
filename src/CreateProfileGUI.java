import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

public class CreateProfileGUI {
    public JPanel panelCreate;
    private JLabel CreateLabel;
    private JTextField aIDTextField;
    private JLabel aIDLabel;
    private JLabel FNLabel;
    private JLabel LNLabel;
    private JLabel AddLabel;
    private JLabel PhnLabel;
    private JTextField FNTextField;
    private JTextField LNTextField;
    private JTextField AddTextField;
    private JTextField PhnTextField;
    private JLabel IncLabel;
    private JButton SubmitButton;
    private JLabel UseLabel;
    private JLabel StatusLabel;
    private JLabel ModelLabel;
    private JLabel YearLabel;
    private JLabel TypeLabel;
    private JLabel MethodLabel;
    private JTextField ModelTextField;
    private JTextField YearTextField;
    private JTextField IncTextField;
    private JComboBox UseComboBox;
    private JComboBox StatusComboBox;
    private JComboBox TypeComboBox;
    private JComboBox MethodComboBox;
    private JButton BackButton;
    private JLabel VinfLabel;
    private JFrame createFrame = new JFrame("Create Profile");

    private final CustomerProfInterface DB;

    public CreateProfileGUI(CustomerProfInterface DB) {

        //Uses the correct database
        this.DB = DB;

        createFrame.setContentPane(panelCreate);
        createFrame.setSize(800, 650);
        createFrame.setLocationRelativeTo(null);
        createFrame.setVisible(true);
        createFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Button to go back to main menu
        BackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFrame.setVisible(false);
                new MainMenuGUI(DB);
            }
        });

        //Makes Sure income is entered as a number
        IncTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        //Makes Sure phone is entered as a number
        PhnTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        //Makes Sure income is entered as a number
        IncTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        //Makes Sure year is entered as a number
        YearTextField.addKeyListener(new KeyAdapter() {
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

                //Makes sure no field is left empty before writing to database
                if (aIDTextField.getText().hashCode() == 0 || FNTextField.getText().hashCode() == 0 || LNTextField.getText().hashCode() == 0 || AddTextField.getText().hashCode() == 0 || PhnTextField.getText().hashCode() == 0 || IncTextField.getText().hashCode() == 0 || UseComboBox.getSelectedIndex() == 0 || StatusComboBox.getSelectedIndex() == 0 || ModelTextField.getText().hashCode() == 0 || YearTextField.getText().hashCode() == 0 || TypeComboBox.getSelectedIndex() == 0 || MethodComboBox.getSelectedIndex() == 0) {
                    JOptionPane.showMessageDialog(null, "Some fields are empty! Please fill them in before submitting!");
                } else {

                    String admin = aIDTextField.getText();
                    String first = FNTextField.getText();
                    String last = LNTextField.getText();
                    String address = AddTextField.getText();
                    String phone = PhnTextField.getText();
                    float income = Float.parseFloat(IncTextField.getText());

                    String status = (String) StatusComboBox.getItemAt(StatusComboBox.getSelectedIndex());
                    String use = (String) UseComboBox.getItemAt(UseComboBox.getSelectedIndex());

                    String model = ModelTextField.getText();
                    String year = YearTextField.getText();

                    String type = (String) TypeComboBox.getItemAt(TypeComboBox.getSelectedIndex());
                    String method = (String) MethodComboBox.getItemAt(MethodComboBox.getSelectedIndex());

                    //Create a new customer and write to database
                    CustomerProf add = DB.createNewCustomerProf(admin, first, last, address, phone, income, status, use, model, year, type, method);
                    DB.current.insertNewProfile(add);
                    DB.writeToDB();

                    JOptionPane.showMessageDialog(null, "New profile has successfully been created!");

                    //Clear Text Fields and reset combo Boxes
                    aIDTextField.setText(null);
                    FNTextField.setText(null);
                    LNTextField.setText(null);
                    AddTextField.setText(null);
                    PhnTextField.setText(null);
                    IncTextField.setText(null);
                    StatusComboBox.setSelectedIndex(0);
                    UseComboBox.setSelectedIndex(0);
                    ModelTextField.setText(null);
                    YearTextField.setText(null);
                    TypeComboBox.setSelectedIndex(0);
                    MethodComboBox.setSelectedIndex(0);
                }

            }
        });
    }

    public static void main(String args[]) {
    }

}

