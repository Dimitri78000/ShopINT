package package_webserver_TP7;


import java.util.HashMap;
import java.util.Map;

public class FilmDB {
  private Map<Film, Recommendations> db;
  
  public FilmDB() {
    db = new HashMap<Film, Recommendations>();
  }
  
  public Recommendations lookup(String title, int year) throws FilmDoesNotExistsException {
    Film film = new Film(title, year);
    Recommendations res = db.get(film);
    if(res == null)
      throw new FilmDoesNotExistsException(film + " does not exists");
    else
      return res;
  }
  
  public void create(String title, int year) throws FilmAlreadyExistsException {
    Film film = new Film(title, year);
    if(db.get(film) != null)
		try {
			throw new FilmDoesNotExistsException(film + " already exists");
		} catch (FilmDoesNotExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	else
      db.put(film, new Recommendations());
  }
  
  public String asHTML() {
    String res = " <br/> <br/> Liste des films :<ul>";
    
    for(Film film: db.keySet()) {
      res += "<li>" + film.asHTML() + "</li>";
    }
    
    return res + "</ul>";
  }
  
  public String toString() {
    String res = "";
    for(Film film: db.keySet())
      res += film + System.lineSeparator();
    return res;
  }
}