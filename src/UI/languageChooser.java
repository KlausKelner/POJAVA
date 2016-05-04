package UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class languageChooser {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					languageChooser window = new languageChooser ();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public languageChooser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 238, 142);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(10, 69, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setToolTipText("Quits the program");
		btnQuit.setBounds(123, 69, 89, 23);
		frame.getContentPane().add(btnQuit);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 30, 202, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setEditable(true);
		comboBox.addItem("Choose from list");
		comboBox.addItem("English");
		comboBox.addItem("Polski");
		
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() == 1) {
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								newUI window = new newUI(1);
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				
				
				if (comboBox.getSelectedIndex() == 2) {
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								newUI window = new newUI(2);
								window.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("Choose language");
		lblNewLabel.setBounds(10, 11, 172, 14);
		frame.getContentPane().add(lblNewLabel);
	}
}
