package org.example;

import org.example.DAO.EmployeeDAO;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main ( String[] args ) {
    int response;
    do {

      System.out.println ("****************************");
      System.out.println ("********* Employee Menu ***********");
      System.out.println (":: Select option");
      System.out.println ("1. List all employees");
      System.out.println ("2. get employee by id");
      System.out.println ("3. Create new employee");
      System.out.println ("4. Update employee");
      System.out.println ("5. Delete employee");
      System.out.println ("0. Leave");

      Scanner sc = new Scanner ( System.in );
      response = Integer.valueOf ( sc.nextLine () );

      switch ( response ){
        case 1:
          EmployeeDAO.getAllEmployees ();
          break;
        case 2:
          EmployeeDAO.getEmployeesById ();
          break;
        case 3:
          EmployeeDAO.crateEmployee ();
          break;
        case 4:
          EmployeeDAO.updateEmployee ();
          break;
        case 5:
          EmployeeDAO.deleteEmployee ();
          break;
        default:
          break;
      }
    }while( response != 0);

    System.out.println ("Sayonara...");
    }
}