package package_shopping;

public class Rayon { //definie les attributs du rayons
	
	String produit;
	private int x0; private int y0; //case du début du rayon
	private int x1; private int y1;//case de la fin du rayon
	
	
	public Rayon(String nom, int x0, int y0, int x1, int y1) {
		produit=nom;
		this.x0=x0;
		this.y0=y0;
		this.x1=x1;
		this.y1=y1;
	}
	

	/*public void addInDistanceMatrix(int[][] res) { //met -1 dans la matrice pour dire que le rayons est occupé par des aliments
		for(int y=y0; y<y1; y++)
			res[x0][y] = -1;
	}*/
	public String[][] addInDistanceMatrix(String[][] res) {
		if (x0!=x1 && y0!=y1) {
            System.out.println("erreur de coordonées");
		}
		else{
			if ((x0==x1) && (y0==y1)){ //rayon d'une case
				res[x0][y0]="|" + produit +"|";
			}
			else if(x0==x1) {//rayon en ligne
					res[x0][y0]="|" + produit +"¤";
					for(int y=y0+1; y<y1;y++) {
						res[x0][y]="¤"+"========"+"¤";
					}
					res[x0][y1]="¤========|";
			}
			else if(y0==y1) {//rayon en colonne
				res[x0][y0]="|" + produit + "|";
				for(int x=x0+1;x<x1;x++) {
					res[x][y0]="|========|";
				}
				res[x1][y0]="|========|";
			}
		}
		return res;
	}
}
