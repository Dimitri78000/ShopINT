package package_webserver_TP7;
import package_shopping.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Server {
  private FilmDB db;
  private Socket socket;
  private BufferedReader reader;
  private PrintStream out;
  
  public Server(FilmDB filmDB, Socket socket) throws IOException {
    this.db = filmDB;
    this.socket = socket;
    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    out = new PrintStream(socket.getOutputStream());
  }

  public void handle() throws IOException {
    String method = reader.readLine();
    String[] cmd = method.split(" ");
    String location = cmd[1];

    location = location.replace("%20", " ");
    String[] tokens = location.split("/", 0);

    out.println("HTTP/1.1 200 OK");
    out.println("");
    out.println("<html><body>");

    
    System.out.println("Request " + location + " => " + tokens.length + " tokens");
    
    try {
      switch(tokens.length) {
      case 0: 
        out.println(db.asHTML()); 
        break;
      case 3:
        String name = tokens[1];
        int year = Integer.parseInt(tokens[2]);
        Recommendations recommendations = db.lookup(name, year);

        out.println("Recommendations pour le film " + name + " (" + year + ") :");
        out.println(recommendations.asHTML());
        out.println("<p/><a href='/'>Back</a>");
        break;
      default:
        throw new BadRequestException("bad request: " + location);
      }
    } catch(BadRequestException|FilmDoesNotExistsException e) {
      out.println(e.getMessage());
      out.println("<p/><a href='/'>Back</a>");      
    }
    
    out.println("</body></html>");
    socket.close();
  }
}