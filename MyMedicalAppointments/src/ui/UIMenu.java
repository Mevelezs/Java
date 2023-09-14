package ui;

import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = { "January", "February", "March", "April", "May", "Jun", "July",
            "August", "September", "October", "November", "December" };

    public static void showMenu(){
      System.out.println ("Welcome to My Appointments");
      System.out.println ("Selecciona la operación deseada");

      int response;
      do {
        System.out.println ("1. model.Doctor");
        System.out.println ("2. model.Patient");
        System.out.println ("0. Leave");

        Scanner sc = new Scanner ( System.in );
        response = sc.nextInt ();

        switch ( response ){
          case 1:
            System.out.println (" ");
            System.out.println ("*********************************");
            System.out.println ("The model.Doctor's Name");
            System.out.println ("*********************************");
            break;
          case 2:
            System.out.println ("*********************************");
            System.out.println ("model.Patient");
            System.out.println ("*********************************");
            response = 0;
            showNameDoctor ();
            break;
          case 0:
            System.out.println ("*********************************");
            System.out.println ("thanks for your visit");
            System.out.println ("*********************************");
            break;
          default:
            System.out.println ("select valid option");
            break;
        }
      }while (response != 0 );

  }

  private static void showNameDoctor () {
      int option;
    do {
      System.out.println ("Select an option");

      System.out.println ("1 : Book an appointment");
      System.out.println ("2 : My appointments");
      System.out.println ("0 : Return");

      Scanner sc = new Scanner ( System.in );
      option = sc.nextInt ();
      switch ( option ){
        case 1:
          System.out.println (" ");
          System.out.println ("*********************************");
          System.out.println (":: Book an appointment");
          System.out.println ("*********************************");
          for ( int i = 0; i < 3; i++ ){
            System.out.println (i+1 + "." + MONTHS[i]);
          }
          System.out.println ("\n\n");
          break;
        case 2:
          System.out.println (" ");
          System.out.println ("*********************************");
          System.out.println ("this are your appointments");
          System.out.println ("*********************************");
          break;
        case 0:
          showMenu ();
          break;
      }
    }while(option != 0);

  }
}
