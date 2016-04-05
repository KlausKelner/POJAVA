import java.io.*;

public class CalculationsBC547{

  public static void main(String[] args) {
	  
    String s = "**** The calculations for transistor BC547 ****";
 
	double RL = 1;					//Resistive Load
	double h11 = 4.5;				//input impedance hie
	double h12 = 0.0002;			//reverse voltage hre
	double h21 = 330;				//current gain hfe	
	double h22 = 30;				//output admitance hoe
	
	//Parameters for transistor
	double R_IN;				//input resistance
	double R_OUT; 				//output resistance
	double K_u;					//voltage amplification
	double K_i; 				//current amplification
	double K_p;					//power amplification
	
	R_IN = h11 - (h12*h21*RL)/(1+(h22*RL));
	R_OUT = 1 / (h22 - (h12*h21)/(h11+RL));
	K_u = (-h21*RL)/(h22+(h11*h22-h12*h21)*RL);
	K_i = h21/(1+h22*RL);
	K_p = -K_u*K_i;  
	
	File file = new File("Calculations_for_BC547.txt");
	FileOutputStream fis = null;
	try {
		fis = new FileOutputStream(file);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	PrintStream out = new PrintStream(fis);
	System.setOut(out);
	System.out.println(s);
	System.out.println("\n\n");
	System.out.println("Value of internal resistance :\n");
	System.out.print(R_IN);
	System.out.println("\n\n");
	System.out.println("Value of external resistance :\n");
	System.out.print(R_OUT);
	System.out.println("\n\n");
	System.out.println("Value of voltage amplification :\n");
	System.out.print(K_u);
	System.out.println("\n\n");
	System.out.println("Value of current amplification :\n" );
	System.out.print(K_i);
	System.out.println("\n\n");
	System.out.println("Value of power amplification : \n");
	System.out.print(K_p);
	System.out.println("\n\n");
  }
}