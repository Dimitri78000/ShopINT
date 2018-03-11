package package_webserver;


public class Film {
  private String title;
  private int year;
  
  public Film(String title, int year) {
    this.title = title;
    this.year = year;
  }

  public String asHTML() {
    return "<a href=/" + title.replace(" ", "%20") + "/" + year + ">"
        + title + " " + year
        + "</a>";
  }
  
  public int hashCode() {
    return title.hashCode() + year;
  }
  
  public boolean equals(Object o) {
    if(!(o instanceof Film))
      return false;
    Film film = (Film)o;
    return title.equals(film.title) && year == film.year;
  }
  
  public String toString() {
    return title + " (" + year + ")";
  }
}