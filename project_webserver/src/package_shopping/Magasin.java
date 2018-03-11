package package_shopping;

import java.util.Collection;
import java.util.LinkedList;

public class Magasin {
Collection<Rayon> rayons;
int xmax;
int ymax;
	
	public Magasin() {//met en place une liste de rayons définis
		rayons = new LinkedList<Rayon>();
		xmax=10;
		ymax=10;
		rayons.add(new Rayon("yaourt~~", 3, 3, 3, 9)); // Les noms des rayons doivent être de 8 caractères
		rayons.add(new Rayon("fruits~~", 1,2,1,5 ));
		rayons.add(new Rayon("riz~~~~~",0,0,6,0));
		rayons.add(new Rayon("tomate~~",9,1,9,2));
		rayons.add(new Rayon("viande~~",5,5,9,5));
		rayons.add(new Rayon("chewingu",8,8,8,8));
		rayons.add(new Rayon("epices~~",7,7,8,7));
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
	
	
	public String[][] createDistanceMatrix() { //mise en place de la matrice avec des -1 pour tous les rayons
		String[][] res = new String[xmax][ymax];
		for(Rayon r: rayons) {
			r.addInDistanceMatrix(res);
		}
		return res;
	}
	
	public void showligne(int i) { //affiche une ligne de la matrice et convertit ce qui n'et pas rempli en .
		String[][] res=createDistanceMatrix();
		for (int j=0; j<ymax;j++) {
			if(res[i][j]==null) {
				res[i][j]="°........°";
			}
			System.out.print(res[i][j]);
		}
		
	}
	public void show() {//affiche la matrice : affiche -1 pour les rayons et 0 sinon
		for(int i=0; i<xmax; i++) {
			showligne(i);
			System.out.println();
		}
	}
}
