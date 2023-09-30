package ui;

import java.util.Scanner;

public class UIPatientMenu {
  public static void showPatientMenu(){
    int response = 0;
    do {
      System.out.println ("\n\n");
      System.out.println ("Patient");
      System.out.println ("Welcome: " + UIMenu.patientLogged);
      System.out.println ("1. Book an appointment");
      System.out.println ("2. My appointments");
      System.out.println ("0. Logout");

      Scanner sc = new Scanner( System.in );
      response = Integer.valueOf ( sc.nextLine () );

      switch ( response ){
        case 1 :
          break;
        case 2:

        case 0:
          UIMenu.showMenu ();
          break;
      }
    }while( response != 0 );
  }
  private static void showBookAppointmentsMenu () {
    int response = 0;

    do {
      System.out.println (":: Book an appointment");
      System.out.println (":: Select date: ");

    }while ( response != 0 );
  }
}
