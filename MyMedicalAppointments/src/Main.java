import model.Doctor;
import model.Patient;
import model.Users;

import java.util.Date;

public class Main {
  public static void main ( String[] args ) {

    //showMenu ();

    Doctor myDoc = new Doctor ("SacaLastrava", "mail@mail","Medico General");
    myDoc.addAvailableAppointment (new Date (), "4: pm");
    myDoc.addAvailableAppointment (new Date (), "14: pm");
    myDoc.addAvailableAppointment (new Date (), "18: pm");
    System.out.println ("\n");
    myDoc.ShowDataUser ();


    System.out.println (myDoc);
  /*
    for ( model.Doctor.AvailableAppointment aA: myDoc.getAvailableAppointments ()) {
      System.out.println ("---" + aA.getDate () + " " + aA.getTime ());
    }
    */

    System.out.println ("\n\n");

    Patient patient = new Patient ( "Mauricio","email@mail");
    System.out.println (patient);
  }
}