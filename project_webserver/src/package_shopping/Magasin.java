package package_shopping;

import java.util.Collection;
import java.util.LinkedList;

public class Magasin {
Collection<Rayon> rayons;
int xmax;
int ymax;
	
	public Magasin() {//met en place une liste de rayons définis
		rayons = new LinkedList<Rayon>();
		xmax=10; // xmax exclu, le magasin va de 0 à xmax-1
		ymax=10; // xmax exclu, le magasin va de 0 à xmax-1
		
		/*
		rayons.add(new Rayon("yaourt~~", 3, 3, 3, 9)); // Les noms des rayons doivent être de 8 caractères
		rayons.add(new Rayon("lessive~", 1,2,1,5 ));
		rayons.add(new Rayon("riz~~~~~",0,0,3,0));
		rayons.add(new Rayon("savon~~~",5,1,5,2));
		rayons.add(new Rayon("viande~~",5,3,7,3));
		rayons.add(new Rayon("chewingu",7,9,7,9));
		rayons.add(new Rayon("epices~~",4,8,6,8));
		
		rayons.add(new Rayon("vetement",5,5,6,5));
		rayons.add(new Rayon("vetement",5,6,6,6));
		
		rayons.add(new Rayon("~ENTREE~",9,8,9,8));
		rayons.add(new Rayon("~SORTIE~",9,0,9,6));
		*/
		
		rayons.add(new Rayon("yaourt", 3, 3, 3, 9)); // Les noms des rayons doivent être de 8 caractères
		rayons.add(new Rayon("lessive", 1,2,1,5 ));
		rayons.add(new Rayon("riz",0,0,3,0));
		rayons.add(new Rayon("savon",5,1,5,2));
		rayons.add(new Rayon("viande",5,3,7,3));
		rayons.add(new Rayon("chewingum",8,7,8,7));
		rayons.add(new Rayon("epices",4,8,6,8));
		
		rayons.add(new Rayon("vetement",5,5,6,5));
		rayons.add(new Rayon("vetement",5,6,6,6));
		
		rayons.add(new Rayon("ENTREE",9,8,9,8));
		rayons.add(new Rayon("SORTIE",9,0,9,6));
	}
	
	public String[][] createDistanceMatrix() { //mise en place de la matrice avec des -1 pour tous les rayons
		String[][] res = new String[xmax][ymax];
		for(Rayon r: rayons) {
			r.addInDistanceMatrix(res);
		}
		return res;
	}
	
	public String[][] createDistanceMatrixHTML() { //mise en place de la matrice avec des -1 pour tous les rayons
		String[][] res = new String[xmax][ymax];
		for(Rayon r: rayons) {
			r.addInDistanceMatrixHTML(res);
		}
		return res;
	}
	
	public String showligne(int i) { //affiche une ligne de la matrice et convertit ce qui n'et pas rempli en .
		String[][] res=createDistanceMatrix();
		String ligne ="";
		for (int j=0; j<ymax;j++) {
			if(res[i][j]==null) {
				res[i][j]="°........°";
			}
			ligne+= res[i][j];
		}
		return ligne;
		
	}
	public String show() {//affiche la matrice : affiche -1 pour les rayons et 0 sinon
		String string_matrice = "";
		for(int i=0; i<xmax; i++) {
			String Newligne=System.getProperty("line.separator");
			string_matrice+=showligne(i);
			string_matrice+=Newligne; 
			}
		return string_matrice;
	}
	
	public String showAsHTML() {//affiche la matrice : affiche -1 pour les rayons et 0 sinon
		String string_matrice_HTML = "<table>";
		
		String[][] res=createDistanceMatrixHTML();
		
		String debut_ligne = "<tr>";
		String fin_ligne = "</tr>";
		String debut_case = "<td>";
		String fin_case = "</td>";
		String Newligne=System.getProperty("line.separator");
		
		for(int i=0; i<xmax; i++) {
			string_matrice_HTML+= debut_ligne;
			for(int j=0;j<ymax;j++) {
				string_matrice_HTML+= debut_case;
				
				if (res[i][j]!=null) {
					string_matrice_HTML+= res[i][j];
				}
				
				string_matrice_HTML+= fin_case;
				
			}
			string_matrice_HTML+= fin_ligne;
			string_matrice_HTML+=Newligne; // Pour que le code HTML soit plus propre à lire "Afficher le code source de la page"
		}
		
		string_matrice_HTML += "</table>";
		string_matrice_HTML += "<style> table{border-collapse:collapse;} td,th {border: 1px solid black;}  </style>";
		return string_matrice_HTML;
	}
	
	
	/*public int[][] createDistanceMatrix() { //mise en place de la matrice avec des -1 pour tous les rayons
	int[][] res = new int[xmax][ymax];
	for(Rayon r: rayons) {
		r.addInDistanceMatrix(res);
	}
	return res;
}

public void showligne(int i) { //affiche une ligne
	int[][] res=createDistanceMatrix();
	for (int j=0; j<ymax;j++) {
		System.out.print(res[i][j]);
	}
	
}
public void show() {//affiche la matrice : affiche -1 pour les rayons et 0 sinon
	int[][] res=createDistanceMatrix();
	for(int i=0; i<xmax; i++) {
		showligne(i);
		System.out.println();
	}
}
*/
}
