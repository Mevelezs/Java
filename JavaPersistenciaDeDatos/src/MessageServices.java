import java.util.Scanner;

public class MessageServices {

  public static void createMessage(){
    Scanner sc = new Scanner ( System.in );

    System.out.println ("Write your message");
    String message = sc.nextLine ();

    System.out.println ("White the author's name of message");
    String author_name = sc.nextLine ();

    Messages newMessage = new Messages (message, author_name);

    MessageDAO.createMessageDB ( newMessage );

  };
  public static void readMessage(){
    MessageDAO.readMessagesDB ();

  };
  public static void deleteMessage (){
    Scanner sc = new Scanner ( System.in );
    System.out.println ("Write the Id of message to delete");
    int response = sc.nextInt();
     MessageDAO.deleteMessageDB ( response );
  };
  public static void updateMessage (){

    Scanner sc = new Scanner ( System.in );
    System.out.println ("Write the Id of message to delete ");
    int id = Integer.valueOf (sc.nextLine ());

    System.out.println ("Write the new message");
    String message = sc.nextLine ();

    Messages newMessageUpdate = new Messages ();
    newMessageUpdate.setId_message ( id );
    newMessageUpdate.setMessage ( message );

    MessageDAO.updateMessageDB ( newMessageUpdate);
  };
}
