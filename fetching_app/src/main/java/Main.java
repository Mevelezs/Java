import javax.swing.*;
import java.io.IOException;

public class Main {

  public static void main ( String[] args ) throws IOException {
    int option_menu = 0;
    String[] buttons = {" 1. show characters ", " 2. leave"};

    do {
      String option = ( String ) JOptionPane.showInputDialog ( null, "Rick and Morty",
              "Main Menu", JOptionPane.INFORMATION_MESSAGE,
              null, buttons, buttons[0]);

      for ( int i = 0; i < buttons.length; i++ ){
        if(option.equals ( buttons[i] )){
          option_menu = i;
        }
      }

      switch ( option_menu ){
        case 0:
          CharactersServices.showCharacters ();
          break;
        case 1:
          break;
        default:
          break;
      }
    }while( option_menu != 1);
  }
}
