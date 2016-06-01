package UI;

public class Tmp 
{ 
	public static void main(String [] args)
	{

		Transistor Tuna = new Transistor(/*1,1,1,1,*/1,0.0000000000000006734,0.75,140,4);
		
		Tuna.getGraph();
	
		System.out.println(Tuna.getIc());
	}

}