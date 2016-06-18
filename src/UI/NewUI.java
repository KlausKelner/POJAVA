package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

import javax.swing.event.ChangeListener;


public class NewUI {
	
	private Transistor t = new Transistor(/*1,1,1,1,*/1,0.0000000000000006734,0.75,140,4);
	
	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	
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
		frame.setSize(680, 460);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		
		JPanel centre= new JPanel();
		frame.getContentPane().add(centre, BorderLayout.CENTER);
		centre.setLayout(new GridLayout(1, 3));
		
		AnimationPanel newAnim = new AnimationPanel();
		
		/* TEXT FIELDS */
		JPanel texts = new JPanel();
		texts.setLayout(new BorderLayout());
		
		JPanel fieldsAndLabels = new JPanel();
		fieldsAndLabels.setLayout(new GridLayout(6, 2));
		texts.add(fieldsAndLabels, BorderLayout.CENTER);
		
		textField_1 = new JTextField(); //model
		textField_1.setText("eg. BC548");
		textField_1.setColumns(10);
		//textField_1.setBounds(540, 43, 75, 20);
		fieldsAndLabels.add(textField_1);
		
		JLabel lblNewLabel = new JLabel(labels.transName);
		lblNewLabel.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		//lblNewLabel.setBounds(629, 46, 88, 14);
		fieldsAndLabels.add(lblNewLabel);
		
		textField = new JTextField(); //IS
		textField.setText("0");
		textField.setColumns(10);
		//textField.setBounds(540, 74, 75, 20);
		fieldsAndLabels.add(textField);
		
		JLabel label = new JLabel("IS");
		label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		//label.setBounds(629, 77, 88, 14);
		fieldsAndLabels.add(label);
		
		textField_2 = new JTextField();  //B_F
		textField_2.setText("0");
		textField_2.setColumns(10);
		//textField_2.setBounds(540, 105, 75, 20);
		fieldsAndLabels.add(textField_2);
		
		JLabel label_1 = new JLabel("B_F");
		label_1.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		//label_1.setBounds(629, 108, 88, 14);
		fieldsAndLabels.add(label_1);
		
		textField_3 = new JTextField(); //B_R
		textField_3.setText("0");
		textField_3.setColumns(10);
		//textField_3.setBounds(540, 136, 75, 20);
		fieldsAndLabels.add(textField_3);
		
		JLabel label_2 = new JLabel("B_R ");
		label_2.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		//label_2.setBounds(629, 139, 88, 14);
		fieldsAndLabels.add(label_2);
		
		textField_4 = new JTextField(); //R_L
		textField_4.setText("0");
		textField_4.setColumns(10);
		//textField_4.setBounds(540, 167, 75, 20);
		fieldsAndLabels.add(textField_4);
		
		JLabel label_3 = new JLabel("R_L");
		label_3.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		//label_3.setBounds(629, 170, 88, 14);
		fieldsAndLabels.add(label_3);
		
		textField_5 = new JTextField(); //V_jc
		textField_5.setText("0");
		textField_5.setColumns(10);
		//textField_5.setBounds(540, 198,75, 20);
		fieldsAndLabels.add(textField_5);
		
		JLabel label_4 = new JLabel("V_JC");
		label_4.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		//label_4.setBounds(629, 201, 88, 14);
		fieldsAndLabels.add(label_4);
		
		/* SLIDERS */
		JPanel sliders = new JPanel();
		sliders.setLayout(new GridLayout(6, 1));
		
		JLabel label_5= new JLabel("U_B");
		//label_5.setBounds(395, 37, 200, 26);
		sliders.add(label_5);
		//JLabel label_5a= new JLabel("I_B = " + t.getIb());
		
		
		JSlider sliderUB = new JSlider(JSlider.HORIZONTAL,0,99,0);
		//sliderUB.setBounds(310,67 , 200, 26);
		sliderUB.setMinorTickSpacing(1);
		sliderUB.setMajorTickSpacing(10);
		sliderUB.setPaintLabels(true);
		sliderUB.setPaintTicks(true);
		
		sliderUB.addChangeListener(new ChangeListener (){
			public void stateChanged(ChangeEvent e){
				JSlider source =(JSlider) e.getSource();
				t.Vb=source.getValue();
				t.setVbe();
				t.setVbc();
				newAnim.setVb((int)(source.getValue()/10));
				//System.out.print(t.Vbe+" Wartoœæ U_be\n");
				//System.out.print(t.Vbc+" Wartoœæ U_bc\n");
				//System.out.print(t.Vb+" Wartoœæ U_B\n");
			}
		});
		sliders.add(sliderUB);
		
	    
		
		JLabel label_6= new JLabel("U_C");
		//label_6.setBounds(395, 97, 200, 26);
		sliders.add(label_6);
		//JLabel label_6a= new JLabel("I_C = " + t.getIc());
		
		
		JSlider sliderUC = new JSlider(JSlider.HORIZONTAL,0,99,0);
		//sliderUC.setBounds(310, 127, 200, 26);
		sliderUC.setMinorTickSpacing(1);
		sliderUC.setMajorTickSpacing(10);
		sliderUC.setPaintLabels(true);
		sliderUC.setPaintTicks(true);
		
		sliderUC.addChangeListener(new ChangeListener (){
			public void stateChanged(ChangeEvent e){
				JSlider source =(JSlider) e.getSource();
				t.Vc=source.getValue();
				t.setVbc();
				t.setVce();
				newAnim.setVc((int)(source.getValue()/10));
				//System.out.print(t.Vce+" Wartoœæ U_ce\n");
				//System.out.print(t.Vbc+" Wartoœæ U_bc\n");
				//System.out.print(t.Vc+" Wartoœæ U_C\n");
			}
		});
		sliders.add(sliderUC);
		
		
		
		JLabel label_7= new JLabel("U_E");
		//label_7.setBounds(395, 157, 200, 26);
		sliders.add(label_7);
		//JLabel label_7a= new JLabel("I_E = " + t.getIe());
		
		
		JSlider sliderUE = new JSlider(JSlider.HORIZONTAL,0,99,0);
		//sliderUE.setBounds(310, 187, 200, 26);
		sliderUE.setMinorTickSpacing(1);
		sliderUE.setMajorTickSpacing(10);
		sliderUE.setPaintLabels(true);
		sliderUE.setPaintTicks(true);
		
		sliderUE.addChangeListener(new ChangeListener (){
			public void stateChanged(ChangeEvent e){
				JSlider source =(JSlider) e.getSource();
				t.Ve=source.getValue();
				t.setVbe();
				t.setVce();
				newAnim.setVe((int)(source.getValue()/10));
				//System.out.print(t.Vbe+" Wartoœæ U_be\n");
				//System.out.print(t.Vce+" Wartoœæ U_ce\n");
				//System.out.print(t.Ve+" Wartoœæ U_E\n");
			}
		});
		sliders.add(sliderUE);
	
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 740, 21);
		frame.getContentPane().add(menuBar, BorderLayout.NORTH);
		
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
	    					
	    					ChartPanelIcUbe plot1 = new ChartPanelIcUbe("I_c/U_be",t);
	    					
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
	    					
	    					ChartPanelUceIb plot2 = new ChartPanelUceIb("U_ce/I_b",t);
	    					
	    					
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
		
		
		
		//JMenuItem mntmNewMenuItem = new JMenuItem(labels.save);
		//mnNewMenu.add(mntmNewMenuItem);
		
		//JMenuItem mntmNewMenuItem_1 = new JMenuItem(labels.export);
		//mnNewMenu.add(mntmNewMenuItem_1);
		
		//JMenuItem mntmNewMenuItem_2 = new JMenuItem(labels.quit);
		//mnNewMenu.add(mntmNewMenuItem_2);

		
		/*JButton btnGetData = new JButton(labels.results);
		btnGetData.setBounds(540, 327, 180, 23);
		frame.getContentPane().add(btnGetData);*/
		
		JButton btnApply = new JButton(labels.apply);
		//btnApply.setBounds(540, 229,120, 20);
		btnApply.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				double inp_RL = Double.parseDouble(textField_4.getText());
				double inp_IS=Double.parseDouble(textField.getText());
				double inp_Vjc=Double.parseDouble(textField_5.getText());
				double inp_Bf=Double.parseDouble(textField_2.getText());
				double inp_Br=Double.parseDouble(textField_3.getText());
				/*System.out.println(inp_RL);
				System.out.println(inp_IS);
				System.out.println(inp_Vjc);
				System.out.println(inp_Bf);
				System.out.println(inp_Br);*/
				t.RL=inp_RL;
				t.Is=inp_IS;
				t.Vjc=inp_Vjc;
				t.Bf=inp_Bf;
				t.Br=inp_Br;
				
			}
		});
		texts.add(btnApply, BorderLayout.SOUTH);
		
		
		//newAnim.setBounds(20,30 , 185, 185);

		centre.add(newAnim);
		centre.add(sliders);
		centre.add(texts);
	}
}
