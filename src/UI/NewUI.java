package UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class NewUI {
	
	Transistor t = new Transistor(1,1,1,1,1,0.0000000000000006734,0.75,140,4);
	
	String labelka = "lol";
	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the application.
	 */
	public NewUI(int lang) {
		initialize(lang);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int lang) {
		
		
		NamesUI labels = new NamesUI(lang);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 756, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		/* TEXT FIELDS */
		textField_1 = new JTextField();
		textField_1.setText("eg. BC548");
		textField_1.setColumns(10);
		textField_1.setBounds(540, 43, 75, 20);
		frame.getContentPane().add(textField_1);
		
		textField = new JTextField();
		textField.setText("0");
		textField.setColumns(10);
		textField.setBounds(540, 74, 75, 20);
		frame.getContentPane().add(textField);
		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(540, 105, 75, 20);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setColumns(10);
		textField_3.setBounds(540, 136, 75, 20);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setColumns(10);
		textField_4.setBounds(540, 167, 75, 20);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setColumns(10);
		textField_5.setBounds(540, 198,75, 20);
		frame.getContentPane().add(textField_5);
		
		/* SLIDERS */
		
		JSlider sliderUB = new JSlider();
		sliderUB.setBounds(310,67 , 200, 26);
		frame.getContentPane().add(sliderUB);
		
		JSlider sliderUC = new JSlider();
		sliderUC.setBounds(310, 127, 200, 26);
		frame.getContentPane().add(sliderUC);
		
		JSlider sliderUE = new JSlider();
		sliderUE.setBounds(310, 187, 200, 26);
		frame.getContentPane().add(sliderUE);
		
		
		/* LABELS */
		JLabel lblNewLabel = new JLabel(labels.transName);
		lblNewLabel.setBounds(629, 46, 88, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("IS");
		label.setBounds(629, 77, 88, 14);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("B_F");
		label_1.setBounds(629, 108, 88, 14);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("B_R ");
		label_2.setBounds(629, 139, 88, 14);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("V_A");
		label_3.setBounds(629, 170, 88, 14);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("V_JC");
		label_4.setBounds(629, 201, 88, 14);
		frame.getContentPane().add(label_4);
		
		JLabel label_5= new JLabel("U_B");
		label_5.setBounds(395, 37, 200, 26);
		frame.getContentPane().add(label_5);
		
		JLabel label_6= new JLabel("U_E");
		label_6.setBounds(395, 97, 200, 26);
		frame.getContentPane().add(label_6);
		
		JLabel label_7= new JLabel("U_C");
		label_7.setBounds(395, 157, 200, 26);
		frame.getContentPane().add(label_7);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 740, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu(labels.file);
		menuBar.add(mnNewMenu);
		JMenu mnoNewMenu = new JMenu(labels.edit);
		menuBar.add(mnoNewMenu);
		JMenu plotsNewMenu = new JMenu(labels.plots);
		menuBar.add(plotsNewMenu);
		JMenu mnopNewMenu = new JMenu(labels.help);
		menuBar.add(mnopNewMenu);
		
		JMenuItem plots1NewMenuItem = new JMenuItem(labels.plot1);
		plotsNewMenu.add(plots1NewMenuItem);
		
		plots1NewMenuItem.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent arg0) {
	    		
	    		   EventQueue.invokeLater(new Runnable() {
	    				public void run() {
	    					
	    					ChartPanelDemo plot1 = new ChartPanelDemo("Plot1",t);
	    					
	    					}
	    				}
	    			);
	    		   
	    		
	            }
	        });
		
		JMenuItem plots2NewMenuItem = new JMenuItem(labels.plot2);
		plotsNewMenu.add(plots2NewMenuItem);
		
		plots2NewMenuItem.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent arg0) {
	    		
	    		   EventQueue.invokeLater(new Runnable() {
	    				public void run() {
	    					
	    					ChartPanelDemo plot2 = new ChartPanelDemo("Plot2",t);
	    					
	    					}
	    				}
	    			);
	    		   
	    		
	            }
	        });
		
		JMenuItem helpNewMenuItem = new JMenuItem(labels.getHelp);
		mnopNewMenu.add(helpNewMenuItem);
		
		helpNewMenuItem.addActionListener(new ActionListener() {
	    	   public void actionPerformed(ActionEvent arg0) {
	    		
	    		   EventQueue.invokeLater(new Runnable() {
	    				public void run() {
	    					try {
	    						GetHelp window = new GetHelp();
	    						window.frame.setVisible(true);
	    					} catch (Exception e) {
	    						e.printStackTrace();
	    					}
	    				}
	    			});
	    		   
	    		
	            }
	        });
		
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem(labels.save);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem(labels.export);
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem(labels.quit);
		mnNewMenu.add(mntmNewMenuItem_2);

		
		JButton btnGetData = new JButton(labels.results);
		btnGetData.setBounds(540, 327, 180, 23);
		frame.getContentPane().add(btnGetData);
		
		JButton btnApply = new JButton(labels.apply);
		btnApply.setBounds(540, 229,120, 20);
		frame.getContentPane().add(btnApply);
		
		AnimationPanel newAnim = new AnimationPanel();
		newAnim.setBounds(20,30 , 185, 185);
		frame.getContentPane().add(newAnim);
	}
}
