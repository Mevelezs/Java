package org.example.repository;

import org.example.model.Employee;

import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeServices {

  public static void readEmployees() throws SQLException {
    Repository < Employee > repository = new EmployeeRepository ();
    repository.findAll ().forEach ( System.out::println );
  }

  public static int getEmployeeByID() throws SQLException {
    int response;
    int id = 0;
    do {
      System.out.println (":: Write the id or 0. to leave");
      Scanner sc = new Scanner ( System.in );
      response = Integer.valueOf (sc.nextLine ());
      if( response != 0){
        id = response;
        Repository < Employee > repository = new EmployeeRepository ();
        System.out.println (repository.getById ( id ));
        System.out.println ("");
      }
      return id;
    }while( response != 0);
  }
  public static void createEmployee () throws SQLException {
    int id = 0;
    int response;
    do {
      System.out.println (" 1. Create A new Employee \n 0. to Leave");
      Scanner scn = new Scanner ( System.in );
      response = Integer.valueOf (scn.nextInt ());
      if(response != 0 ) {
        newEmployee (id);
      }
    }while( response != 0 );

  }
  public static void updateEmployee () throws SQLException {
    System.out.println (":: Write Employee id: ");
    Scanner sc = new Scanner ( System.in );
    int id = Integer.valueOf ( sc.nextLine () );
    if( getEmployeeByID () != 0 & id > 0 ){
      newEmployee (id);
    }
  }

  public static void deleteEmployee() throws SQLException {
    System.out.println (":: Write Employee id to delete: ");
    Scanner sc = new Scanner ( System.in );
    int id = Integer.valueOf ( sc.nextLine () );

    Repository repository = new EmployeeRepository ();
    repository.delete ( id );

  }


  private static void newEmployee ( Integer id ) throws SQLException {
    Scanner sc = new Scanner ( System.in );

    System.out.println ( ":: Write Employee Name: " );
    String name = sc.nextLine ();
    System.out.println ( ":: Write Employee First Surname: " );
    String first_surname = sc.nextLine ();
    System.out.println ( ":: Write Employee Second Surname: " );
    String second_surname = sc.nextLine ();
    System.out.println ( ":: Write Employee Email: " );
    String email = sc.nextLine ();
    System.out.println ( ":: Write Employee Salary :" );
    Float salary = Float.valueOf ( sc.nextLine () );

    Employee newEmployee = new Employee ( name, first_surname, second_surname, email, salary );

    Repository < Employee > repository = new EmployeeRepository ();
    repository.save ( newEmployee , id);
  }
}
