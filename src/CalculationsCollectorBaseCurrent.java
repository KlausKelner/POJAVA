
import java.io.*;

public class CalculationsCollectorBaseCurrent{

  public static void main(String[] args) {
	  
    String s = "**** The calculations for collector and base current ****";
    
    // We are using Ebers Moll formula
    double q = 1.6022*(10^(-19));	//Elementary charge of electron
    double k = 1.3807*(10^(-23));	//Boltzman constant
    double e = 2.7183;				//Euler constant
    double IB = 1; 					//Base current
    double IC = 1; 					//Collector current
    double IS = 0.1;				//Saturation Current
    double V_BE = 1;				//Base Emitter Voltage (*Adjustable)
    double V_BC = 1;				//Base Emitter Voltage (*Adjustable)
    double V_A;						//Forward early voltage
	double T = 293;					//Temperature of transistor
	double IC_Pow1 =(q*V_BE)/(k*T);	//Power factor
	double IC_Pow2 =(q*V_BC)/(k*T);
	
	double IC_Pow4;
	IC_Pow1 = (q*V_BE)/(k*T);
	//IC = IS*(e^IC_Pow1);
	
	
	
	File file = new File("Calculations_for_BC548.txt");
	FileOutputStream fis = null;
	try {
		fis = new FileOutputStream(file);
	} catch (FileNotFoundException g) {
		g.printStackTrace();
	}
	PrintStream out = new PrintStream(fis);
	System.setOut(out);
	System.out.println(s);

  }
}