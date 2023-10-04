import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class CharactersServices {

  public static void showCharacters () throws IOException {
    int number = (int) Math.floor ((Math.random ()*1000)/3);
    String id = String.valueOf ( number );
    /**
     * @Describe: Bringind data of API
     */
    OkHttpClient client = new OkHttpClient ();
    Request request = new Request.Builder ().url ( "https://rickandmortyapi.com/api/character/"+id ).get ().build ();
    Response response = client.newCall ( request ).execute ();
    String rta = response.body ().string ();
    System.out.println ( rta );
    /**
     * Creating an object gson for parse data to json
     */
    Gson gson = new Gson ();
    Characters character = gson.fromJson ( rta, Characters.class );
    System.out.println ( character );

    /**
     * Resazing image ------> optional ( for if the image y very big )
     */
    Image image = null;
    try {
      URL url = new URL ( character.getImage () );
      image = ImageIO.read ( url );
      // System.out.println (url);
     ImageIcon imageCharacter = new ImageIcon ( image );
      // System.out.println (imageCharacter);

      if ( imageCharacter.getIconWidth () > 800 || imageCharacter.getIconWidth () < 600 ) {
        Image background = imageCharacter.getImage ();
        Image resazedImage = background.getScaledInstance ( 600, 600, Image.SCALE_SMOOTH );
        imageCharacter = new ImageIcon ( resazedImage );
      }
      //System.out.println (imageCharacter);

      String[] buttons = {"Show other image ", "Add to favorite ", "Go back"};
      String id_character = String.valueOf ( character.getId () );
      /**
       * Make a  menu
       */
      String options = (String ) JOptionPane.showInputDialog ( null, "Character",
              id_character, JOptionPane.INFORMATION_MESSAGE, imageCharacter, buttons, buttons[0] );

      int selection = -1;

      for ( int i = 0; i < buttons.length; i++ ){
        if(options.equals ( buttons[i] )){
          selection = i;
        }
      }
      switch ( selection ){
        case 0:
          showCharacters ();
          break;
        case 1:
          favoriteCharacters(character);
          break;
        default:
          break;
      }
    } catch ( IOException e ) {
      System.out.println ( e );
    }
  }
  public static void favoriteCharacters ( Characters character ){
    System.out.println ("Hello ");
  }
}
