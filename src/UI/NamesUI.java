

import javax.swing.JFrame;

public class NamesUI extends JFrame {

	/* List of buttons */
	
	private static final long serialVersionUID = 1L;
	String file;
	String edit;
	String save;
	String export;
	String quit;
	String anim_wind;
	String results;
	String transName;
	String help;
	String apply;
	String getHelp;
	String plots;
	String plot1="I_c/U_be";
	String plot2="Uce / Ib";
	


	public NamesUI(int a) {
		if(a==1){
			setEnglishLabels();
		}
		if(a==2){
			setPolishLabels();
		}

	}
	void setEnglishLabels(){
		file="File";
		edit="Edit";
		save="Save";
		export="Export";
		quit="Quit";
		anim_wind="Animation window";
		results="Export Results";
		transName="Model";
		help="Help";
		apply="Apply";
		getHelp="Info";
		plots = "Plots";
	}
	void setPolishLabels(){
		file="Plik";
		edit="Edytuj";
		save="Zapisz";
		export="Wyeksportuj";
		quit="Wyjdz";
		anim_wind="Okno animacji";
		results="Wyeksportuj Wyniki";
		transName="Model";
		help="Pomoc";
		apply="Zatwierdz";
		getHelp="Info";
		plots = "Wykresy";		
		
	}
}