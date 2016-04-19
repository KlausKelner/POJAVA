package UI;

import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.javafx.css.CalculatedValue;

public class ParametersLook extends JPanel {
	 @Override
     public void paintComponent(Graphics g) {
         super.paintComponent(g);
         
         g.drawRect(20, 20, 700, 220);
     }
}
