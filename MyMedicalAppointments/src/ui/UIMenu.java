package ui;

import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {

    public static final String[] MONTHS = { "January", "February", "March", "April", "May", "Jun", "July",
            "August", "September", "October", "November", "December" };

    public static Patient patientLogged;
    public static Doctor doctorLogged;

    public static void showMenu(){
      System.out.println ("Welcome to My Appointments");
      System.out.println ("Selecciona la operación deseada");

      int response;
      do {
        System.out.println ("1. Doctor");
        System.out.println ("2. Patient");
        System.out.println ("0. Leave");

        Scanner sc = new Scanner ( System.in );
        response = sc.nextInt ();

        switch ( response ){
          case 1:
            System.out.println (" ");
            System.out.println ("*********************************");
            System.out.println ("The Doctor's Dates");
            System.out.println ("*********************************");
            response = 0;
            authUser ( 1 );
            break;
          case 2:
            System.out.println ("*********************************");
            System.out.println ("The Patient Dates");
            System.out.println ("*********************************");
            response = 0;
            authUser ( 2 );
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
  public static void authUser(int userType){
    ArrayList < Doctor > doctors = new ArrayList<> ();
    doctors.add ( new Doctor ( "Mauricio", "mevelezs@mail.com", "General" ));
    doctors.add ( new Doctor ( "Aurelio", "aurelio@mail.com", "Pediatría" ));
    doctors.add ( new Doctor ( "Maximus", "maximus@mail.com", "Cirujano" ));


    ArrayList< Patient > patients = new ArrayList<> ();
    patients.add ( new Patient ( "María", "aaria@mail.com"));
    patients.add ( new Patient ( "Alejandra", "alejandra@mail.com"));
    patients.add ( new Patient ( "Cleopatra", "cleo@mail.com"));


    boolean emailCorrect = false;

    do {

      System.out.println ("Insert you email: [ ej: a@a.com]");
      Scanner sc = new Scanner (System.in);
      String email = sc.nextLine ();

      if( userType == 1 ) {

        for ( Doctor d : doctors ) {

          if ( d.getEmail ().equals ( email ) ) {
            emailCorrect = true;
            doctorLogged = d;
          }
        }
      }
      if(userType == 2){

        for ( Patient p: patients) {
          emailCorrect = true;
          patientLogged = p;
        }
      }

    }while(!emailCorrect);

  };
}
