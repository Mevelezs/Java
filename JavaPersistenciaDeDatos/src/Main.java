//import java.sql.Connection;
import java.util.Scanner;

public class Main {
  public static void main ( String[] args ) {

    Scanner sc = new Scanner ( System.in );
    int response;
    do{
      System.out.println ("\n***********************");
      System.out.println ("Message Application\n");
      System.out.println (" 1. Create a message");
      System.out.println (" 2. Read message");
      System.out.println (" 3. Delete message");
      System.out.println (" 4. Update message");
      System.out.println (" 0. Exit to application");
      response = sc.nextInt ();

      switch ( response ){
        case 1:
          MessageServices.createMessage ();
          break;
        case 2:
          MessageServices.readMessage ();
          break;
        case 3:
          MessageServices.deleteMessage ();
          break;
        case 4:
          MessageServices.updateMessage ();
          break;
        default:
          break;
      }
    }while(response != 0 );


    /*Connexion connexion = new Connexion ();
    try ( Connection cnx = connexion.get_connection () ){
    }catch ( Exception e ) {
      System.out.println (e);
    } */
  }
}
