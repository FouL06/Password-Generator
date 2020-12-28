import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class designed to create and provide a user interface. Allowing the user to
 * access the PasswordGenerator class, as to generate a randomly generated
 * password of a variable length along with the additon of special characters if
 * the user desires.
 * 
 * @author Ashton Foulger
 * @version (0.01) December 28, 2020
 *
 */
public class PasswordGeneratorGUI implements ActionListener {

	// Variables used by PasswordGenerator
	private static int length;
	private static boolean specialChars = true;

	// Variables accessed by GUI
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel welcome = new JLabel("Password Generator (v0.01)");
	private static JLabel text = new JLabel("Please enter the desired length of your password:");
	private static JButton generatePassword;
	private static JTextField setLength;
	private static JTextField password;
	private static JCheckBox wantSpecial;

	/**
	 * Constructor, generates the user interface using java's built in GUI system,
	 * placing Jswing objects where needed for the user to generate a password of
	 * variable length and special characters.
	 */
	public PasswordGeneratorGUI() {
		frame = new JFrame();
		panel = new JPanel();

		// Program text constraints
		welcome.setFont(new Font("Courier", Font.BOLD, 20));
		text.setFont(new Font("Courier", Font.BOLD, 12));

		// length text field constraints
		setLength = new JTextField(2);

		// Button constraints
		generatePassword = new JButton("Generate Password");
		generatePassword.setFont(new Font("Courier", Font.BOLD, 12));
		generatePassword.addActionListener(this);

		// Checkbox constraints
		wantSpecial = new JCheckBox("Enable Special Letters");
		wantSpecial.setFont(new Font("Courier", Font.BOLD, 12));

		// Password text field constraints
		password = new JTextField();
		password.setFont(new Font("Courier", Font.BOLD, 16));
		password.setEditable(false);
		password.setBackground(Color.WHITE);
		password.setVisible(false);

		// Panel additions and constraints
		panel.setBorder(BorderFactory.createEmptyBorder(25, 15, 25, 15));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(welcome);
		panel.add(text);
		panel.add(setLength);
		panel.add(wantSpecial);
		panel.add(generatePassword);
		panel.add(password);

		// JFrame additions and constraints
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Password Generator");
		frame.setSize(300, 300);
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Provides a click event when the Generate Password button is pressed.
	 * Accessing the PasswordGenerator Class generating a password of length
	 * provided, and special characters if the user requested. Then allowing the
	 * password to be shown to the user through the user interface.
	 */
	@Override
	public void actionPerformed(ActionEvent e) throws NoSuchElementException {
		if (setLength.getText().equals("")) {
			throw new NoSuchElementException("No length was entered:");
		}

		length = Integer.parseInt(setLength.getText());
		specialChars = wantSpecial.isSelected();

		PasswordGenerator pg = new PasswordGenerator(length, specialChars);
		password.setVisible(true);
		password.setText(pg.generatePassword());
	}

	/**
	 * Main method to draw the GUI.
	 */
	public static void main(String[] args) {
		new PasswordGeneratorGUI();
	}
}
