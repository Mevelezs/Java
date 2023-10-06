package org.example;

import org.example.repository.EmployeeServices;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
  public static void main ( String[] args ) throws SQLException {
    int response;

    do {
      System.out.println ("\n***********************************");
      System.out.println ("******** Employees Menu ***********");
      System.out.println (":: Options: ");
      System.out.println (" 1. Read All Employees");
      System.out.println (" 2. Search Employee by Id");
      System.out.println (" 3. Create Employee");
      System.out.println (" 4. Update Employee");
      System.out.println (" 5. Delete Employee");
      System.out.println (" 0. Leave");


      Scanner sc = new Scanner ( System.in );
      response = Integer.valueOf ( sc.nextInt ()  );
      switch ( response ){
        case 1:
          EmployeeServices.readEmployees ();
          break;
        case 2:
          EmployeeServices.getEmployeeByID ();
          break;
        case 3:
          EmployeeServices.createEmployee ();
          break;
        case 4:
          EmployeeServices.updateEmployee ();
          break;
        case 5:
          EmployeeServices.deleteEmployee ();
          break;
        default:
          break;
      }
    }while(response != 0);

    System.out.println ("...Bye");
  }
}