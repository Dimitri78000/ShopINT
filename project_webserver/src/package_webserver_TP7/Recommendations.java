package package_webserver_TP7;

import java.util.Collection;
import java.util.LinkedList;

public class Recommendations {
  private Collection<String> recommendations;

  public Recommendations() {
    recommendations = new LinkedList<String>();
  }
  
  public void addRecommendation(String recommendation) {
    recommendations.add(recommendation);
  }
  
  public String asHTML() {
    String res = "<ul>";
    for(String recommendation: recommendations)
      res += "<li>" + recommendation + "</li>";
    return res + "</ul>";
  }
  
  public String toString() {  
    String res = "";
    for(String recommendation: recommendations)
      res += recommendation + System.lineSeparator();
    return res;
  }
}