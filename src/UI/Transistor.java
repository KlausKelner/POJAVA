package UI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Math;
public class Transistor {
	String name = "Default name transistor";
	static double E = 2.71;
	double Vb=0;
	double Vc=1;					// Emiter, collector, base voltage
	double Ve=0;
	
	double Vbe = Vb-Ve;					
	double Vbc = Vb-Vc;	
	double Vce = Vc-Ve;
	
	double RL;					//Resistive Load
	double h11;					//input impedance hie
	double h12;					//reverse voltage hre
	double h21;					//current gain hfe	
	double h22;					//output admitance hoe
	
	double Is;					//Saturation current
	double Vjc;					//Junction voltage
	double Bf;					//Beta f
	double Br;					//Beta r
	
	//double I1 = (Is/Br)*(Math.pow(E,(Vbc/Vjc - 1)));						//(Is/Br)*E^(Vbc/Vjc - 1)
	//double I2 = (Is/Bf)*Math.pow(E,(Vbe/Vjc - 1));						//(Is/Bf)*E^(Vbe/Vjc - 1)
	//double I3 = Is*(Math.pow(E,(Vbe/Vjc - 1))-Math.pow(E,(Vbc/Vjc - 1)));	//Is*(E^(Vbe/Vjc) - E^(Vbc/Vjc))
	
	//Parameters for transistors
	double R_IN=h11 - (h12*h21*RL)/(1+(h22*RL));				//input resistance
	double R_OUT=1 / (h22 - (h12*h21)/(h11+RL)); 				//output resistance
	double K_u=(-h21*RL)/(h22+(h11*h22-h12*h21)*RL);			//voltage amplification
	double K_i=h21/(1+h22*RL);  								//current amplification
	double K_p=-K_u*K_i;                                        //power amplification

	Transistor(/*double inp_h11,double inp_h12,double inp_h21,
			double inp_h22,*/double inp_RL,double inp_Is,double inp_Vjc,double inp_Bf,double inp_Br)
	{
		/*h11=inp_h11;
		h12=inp_h12;
		h21=inp_h21;
		h22=inp_h22;*/
		RL =inp_RL;
		Is=inp_Is;
		Vjc=inp_Vjc;
		Bf=inp_Bf;
		Br=inp_Br;
	}
	
	
	double getR_IN()
	{
		return R_IN;
	}
	
	double getR_OUT()
	{
		return R_OUT;
	}
	
	double getK_u()
	{
		return R_OUT;
	}
	
	double getK_i()
	{
		return K_i;
	}
	
	double getK_p()
	{
		return K_p;
	}
	double getIc()
	{
		double Ic = (Is/Br)*(Math.pow(E,(Vbc/Vjc - 1)))+Is*(Math.pow(E,(Vbe/Vjc - 1))-Math.pow(E,(Vbc/Vjc - 1)));
		return Ic;
	}
	double getIe()
	{
		double Ie = (Is/Bf)*Math.pow(E,(Vbe/Vjc - 1))+Is*(Math.pow(E,(Vbe/Vjc - 1))-Math.pow(E,(Vbc/Vjc - 1)));
		return Ie;
	}
	double getIb()
	{
		double Ib = (Is/Br)*(Math.pow(E,(Vbc/Vjc - 1)))+(Is/Bf)*Math.pow(E,(Vbe/Vjc - 1));
		return Ib;
	}
	void getGraph()
	{
		Vbe=0;
		Vbc=0;
		File file = new File("Graph for "+name+".txt");
		FileOutputStream fis = null;
		try {
			fis = new FileOutputStream(file);
			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		PrintStream out = new PrintStream(fis);
		System.setOut(out);
		System.out.println("***Using ctrl+h in text editor change dots '.' to ',' to make graph");
		System.out.println("\n\n");
		System.out.println("Vbe[V];Ic[A]");
		System.out.println("\n");
		int s = 10000;
		for(int i=0; i<=s; i++)
		{
			Vbe = Vbe+0.01;
			double tmpIc = getIc();
			System.out.println(Vbe+";"+tmpIc);
		}
	}
	void incVb(double step)
	{
		Vb=Vb+step;
		setVbe();
		setVbc();
	}
	void incVc(double step)
	{
		Vc=Vc+step;
		setVbc();
		setVce();
	}
	void incVe(double step)
	{
		Ve=Ve+step;
		setVbe();
		setVce();
	}
	void setVbe()
	{
		Vbe = Vb - Ve;
	}
	void setVbc()
	{
		Vbc = Vb - Vc;
	}
	void setVce()
	{
		Vce = Vc - Ve;
	}
	}

		

