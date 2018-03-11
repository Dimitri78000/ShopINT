package package_webserver;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

	public static void main(String[] args) throws Exception 
	{
		System.out.println("Hello World!");
		
		
	    FilmDB db = new FilmDB();
	    
	    db.create("Evil Dead", 1981);
	    db.create("Evil Dead", 2013);
	    db.create("Fanfan la Tulipe", 1952);
	    db.create("Fanfan la Tulipe", 2003);
	    db.create("Mary a tout prix", 1998);
	    db.create("Black Sheep", 2008);

	    db.lookup("Evil Dead", 1981).addRecommendation("Ouh ! Mais ca fait peur !");
	    db.lookup("Evil Dead", 2013).addRecommendation("Meme pas peur !");
	    db.lookup("Evil Dead", 2013).addRecommendation("Insipide et sans saveur");
	    db.lookup("Fanfan la Tulipe", 1952).addRecommendation("Manque de couleurs");
	    db.lookup("Fanfan la Tulipe", 1952).addRecommendation("Supers scenes de combat");
	    db.lookup("Fanfan la Tulipe", 2003).addRecommendation("Mais pourquoi ???");
	    db.lookup("Mary a tout prix", 1998).addRecommendation("Le meilleur film de tous les temps");
	    db.lookup("Black Sheep", 2008).addRecommendation("Un scenario de genie");
	    db.lookup("Black Sheep", 2008).addRecommendation("Une realisation parfaite");
	    db.lookup("Black Sheep", 2008).addRecommendation("A quand Black Goat ?");
		
		
		int port = 4123;
	    ServerSocket server = new ServerSocket(port);
	    while(true) {
	        try {
	          new Server(db, server.accept()).handle();
	        } catch(IOException e) {
	          System.out.println(e.getMessage());
	          e.printStackTrace();
	        }
	      }    
	    
	}

}
