package UI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class getHelp {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 */
	public getHelp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String lol="Simulation of a transistor\n"
				+"Project POJAVA\n"
				+"KlaKel , AliPrz\n"
				+"───█───▄▀█▀▀█▀▄▄───▐█──────▄▀█▀▀█▀▄▄\n"
				+ "──█───▀─▐▌──▐▌─▀▀──▐█─────▀─▐▌──▐▌─█▀\n"
				+ "─▐▌──────▀▄▄▀──────▐█▄▄──────▀▄▄▀──▐▌\n"
				+ "▐█─────────────────────█▌───────────█\n"
				+ "▐█─────────────────────█▌───────────█\n"
				+ "▐█─────────────────────█▌───────────█\n"
				+ "▐█─────────────────────█▌───────────█\n"
				+ "─█───────────────█▄───▄█────────────█\n"
				+ "─▐▌───────────────▀███▀────────────▐▌\n"
				+ "──█──────────▀▄───────────▄▀───────█\n"
				+ "───█───────────▀▄▄▄▄▄▄▄▄▄▀────────█\n";

		frame = new JFrame();
		frame.setBounds(100, 100,510, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 500, 261);
		frame.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		
		JTextPane txtpnNaszProgram = new JTextPane();
		txtpnNaszProgram.setText(lol);
		scrollPane_1.setViewportView(txtpnNaszProgram);
	}

}
