import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
  public Connection get_connection (){
    Connection connection = null;
    try {
      connection = DriverManager.getConnection (
              "jdbc:mysql://localhost:3306/message_app",
              "root",
              "admin123" );
     // System.out.println ("connected ");
    }catch ( SQLException e){
      System.out.println ( "Somenthink is wrong " + e );
    }
    return connection;
  }
}
