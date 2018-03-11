package package_shopping;

public class RayonCarre {
	String produit;
	private int x0; private int y0; 
	private int x1; private int y1;
	private int x2; private int y2; 
	private int x3; private int y3;
	
	
	public RayonCarre(String nom, int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3) {
		produit=nom;
		this.x0=x0; // abscisse du point en haut à gauche
		this.y0=y0; // ordonnée du point en haut à gauche
		
		this.x1=x1; // abscisse du point en haut à droite
		this.y1=y1; // ordonnée du point en haut à droite 
		
		this.x2=x2; // abscisse du point en bas à droite
		this.y2=y2; // ordonnée du point en bas à droite
		
		this.x3=x3;// abscisse du point en bas à gauche
		this.y3=y3;// ordonnée du point en bas à gauche
	}
	public void addInDistanceMatrix(String[][] res) {
		if (x0!=x1 && y1!=y2 && x2!=x3 && y3!=y0) {
            System.out.println("erreur de coordonées pour le rayon carré");
		}
		else{
			for(int x=x0;x<x3;x++) {
				for (int y=y0;y<y1;y++) {
					if (x==x0 && y==y0) 
					{ res[x][y]="|" + produit +"¤"; }
					else if (x==x0)
					{ res[x][y]="|::::::::¤"; }
					else if (y==y1)
					{ res[x][y]="¤::::::::|"; }
					else 
					{ res[x][y]="¤::::::::¤"; }
			}
			
			
			/*
			if ((x0==x1) && (y0==y1)){ //rayon d'une case
				res[x0][y0]="|" + produit +"|";
			}
			else if(x0==x1) {//rayon en ligne
					res[x0][y0]="|" + produit +"¤";
					for(int y=y0+1; y<y1;y++) {
						res[x0][y]="¤========¤";
					}
					res[x0][y1]="¤========|";
			}
			else if(y0==y1) {//rayon en colonne
				res[x0][y0]="|" + produit + "|";
				for(int x=x0+1;x<x1;x++) {
					res[x][y0]="|========|";
				}
				res[x1][y0]="|--------|";
			*/
			}
		}
	}
}
