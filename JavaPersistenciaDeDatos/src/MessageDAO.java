import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageDAO {

  public static void createMessageDB(Messages message) {

    Connexion dbConnect = new Connexion ();
    PreparedStatement ps = null;

    try( Connection conexion = dbConnect.get_connection ()){
      String query = "INSERT INTO messages (message, author_message) VALUES (?, ?)";

      ps = conexion.prepareStatement (query);
      ps.setString ( 1, message.getMessage ());
      ps.setString ( 2, message.getAuthor_message () );
      ps.executeUpdate ();

      System.out.println ("\nThe message has been created");

    }catch ( SQLException e ){
      System.out.println (e);
    };
  };

  public static void readMessagesDB () {

    Connexion dbConnect = new Connexion ();

    PreparedStatement ps = null;
    ResultSet rs = null;

    try( Connection conexion = dbConnect.get_connection ()){

      String query = "SELECT * FROM messages";
      ps = conexion.prepareStatement ( query );
      rs = ps.executeQuery ();

      while ( rs.next () ){
        System.out.println ("ID: " + rs.getInt ( "id_message" ));
        System.out.println ("message: " + rs.getString ( "message" ));
        System.out.println ("Author: " + rs.getString ( "author_message" ));
        System.out.println ("Date: " + rs.getString ( "date_message" ));
        System.out.println ("*****************************\n");
      }
    }catch ( SQLException e ){
      System.out.println ("The messages not found");
      System.out.println (e);
    };

  };
  public static void deleteMessageDB (int id_message) {

    Connexion dbConnect = new Connexion ();
    PreparedStatement ps = null;

    try( Connection conexion = dbConnect.get_connection ()){

      String query = "DELETE FROM messages WHERE id_message = ?";

      ps = conexion.prepareStatement ( query );
      ps.setInt ( 1, id_message );
      ps.executeUpdate ();

      System.out.println ("The message has been deleted");

    } catch ( SQLException e ){
      System.out.println ("The messages not found");
      System.out.println (e);
    };
  };
  public static void updateMessageDB (Messages message) {

    Connexion dbConnect = new Connexion ();
    PreparedStatement ps = null;

    try( Connection conexion = dbConnect.get_connection ( )){

      String query = "UPDATE messages SET message = ? WHERE id_message = ?";
      ps = conexion.prepareStatement (query);
      ps.setString ( 1, message.getMessage () );
      ps.setInt ( 2, message.getId_message () );
      ps.executeUpdate ();

      System.out.println ("The messages not Updated");
    } catch ( SQLException e ){

      System.out.println ("The messages not Updated");
      System.out.println (e);
    };

  };

}