package UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NewTransistorPanel extends JPanel {
	private double thing1 = 0;
	private double thing2 = 0;
	private double thing3 = 0;
	private double thing4 = 0;
	private String[] diffTransistors = {"BC546","BC547","B548"};

	public NewTransistorPanel() throws HeadlessException {
		JPanel panel = new JPanel();
		this.add(panel);
		panel.setLayout(new FlowLayout());
		
		JPanel textBoxes = new JPanel();
		textBoxes.setLayout(new FlowLayout());
		textBoxes.setPreferredSize(new Dimension(150,440));

		JLabel makeTrans = new JLabel("Create your own transistor");
		textBoxes.add(makeTrans);
		
		JFormattedTextField type1 = new JFormattedTextField();
		JFormattedTextField type2 = new JFormattedTextField();
		JFormattedTextField type3 = new JFormattedTextField();
		JFormattedTextField type4 = new JFormattedTextField();
		type1.setValue(new Double(thing1));
		type1.setPreferredSize(new Dimension(80,20));
		type2.setValue(new Double(thing2));
		type2.setPreferredSize(new Dimension(80,20));
		type3.setValue(new Double(thing3));
		type3.setPreferredSize(new Dimension(80,20));
		type4.setValue(new Double(thing4));
		type4.setPreferredSize(new Dimension(80,20));
		textBoxes.add(type1);
		textBoxes.add(type2);
		textBoxes.add(type3);
		textBoxes.add(type4);
		panel.add(textBoxes);
		
		JPanel chooseFrom = new JPanel();
		chooseFrom.setPreferredSize(new Dimension(150,440));
		JLabel choose = new JLabel("Choose from catalog");
		chooseFrom.add(choose);
		
		JComboBox chooseTrans = new JComboBox(diffTransistors);
		chooseTrans.setPreferredSize(new Dimension(100,20));
		chooseFrom.add(chooseTrans);
		
		JPanel space = new JPanel();
		space.setPreferredSize(new Dimension(150, 80));
		chooseFrom.add(space);
		
		JButton okButton = new JButton("OK");
		chooseFrom.add(okButton);
		
		panel.add(chooseFrom);
		
	}

}
