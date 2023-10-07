package org.example.DAO;

import org.example.entity.Employee;
import org.example.util.UtilEntity;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAO {
 private static final EntityManager em = UtilEntity.getEntityManager ();
  
  public static void getAllEmployees (){
    List< Employee > employees = em.createQuery ( "SELECT e FROM Employee e", Employee.class ).getResultList ();
    System.out.println ("\n********** Employee List **************\n");
    employees.forEach ( System.out::println);
    System.out.println ("\n****************************************\n");
  }

  public static void getEmployeesById (){
    int id = 0;
    do {
      System.out.println ("\n Write id or 0. to leave");
      Scanner sc = new Scanner ( System.in );
      id = Integer.valueOf ( sc.nextLine () );
      if( id > 0 ) {
        Employee employee = em.find ( Employee.class, id );
        if ( employee != null ) {
          System.out.println ( "\n********** Employee found *************\n" );
          System.out.println ( employee );
          System.out.println ( "\n***************************************\n" );
        } else {
          System.out.println ( "\n********** Employee not found *********\n" );
          System.out.println ( "\n****************************************\n");
        }
      }
    }while( id != 0 );
  }

  public static void crateEmployee (){
    Scanner sc = new Scanner ( System.in );

    Employee newEmployee = new Employee ();
    System.out.println (":: Write first name");
    newEmployee.setFirstName ( sc.nextLine () );
    System.out.println (":: Write first surname");
    newEmployee.setPaSurname ( sc.nextLine () );
    System.out.println (":: Write second surname");
    newEmployee.setMaSurname ( sc.nextLine () );
    System.out.println (":: Write Email");
    newEmployee.setEmail ( sc.nextLine () );
    System.out.println (":: Write salary");
    newEmployee.setSalary (Float.valueOf (sc.nextLine ()) );
    System.out.println (":: Write curp");
    newEmployee.setCurp( sc.nextLine () );

    em.getTransaction ().begin ();
    em.persist ( newEmployee );
    em.getTransaction ().commit ();

    System.out.println ( "\n**** New employee has been created ****\n" );
    System.out.println (newEmployee);
    System.out.println ( "\n****************************************\n");
  }

  public static void updateEmployee ( ){
    int response;
    int id;
    System.out.println (" :: Write employee id: ");
    Scanner scID = new Scanner ( System.in );
    id = Integer.valueOf ( scID.nextLine () );

    Employee employeeToUpdate = em.find ( Employee.class, id );
    System.out.println ("\n************* Employee to modify **********\n");
    System.out.println (employeeToUpdate);
    System.out.println ( "\n****************************************\n");
    do {
      System.out.println ( "\n************* Current values **********\n");
      System.out.println (employeeToUpdate);
      System.out.println ( "\n****************************************\n");
      System.out.println (" Select option to update");
      System.out.println (":: 1. Modify first name");
      System.out.println (":: 2. Modify first surname");
      System.out.println (":: 3. Modify second surname");
      System.out.println (":: 4. Modify email");
      System.out.println (":: 5. Modify salary");
      System.out.println (":: 0. Update");
      Scanner sc = new Scanner ( System.in );
      response = Integer.valueOf ( sc.nextLine () );

      switch ( response ){
        case 1:
          System.out.println ( "\n****************************************\n");
          System.out.println (":: Write new first name ");
          String first_Name = sc.nextLine ();
          employeeToUpdate.setFirstName (first_Name);
          break;
        case 2:
          System.out.println ( "\n****************************************\n");
          System.out.println (":: Write new first surname ");
          String first_Surname = sc.nextLine ();
          employeeToUpdate.setPaSurname (first_Surname);
          break;
        case 3:
          System.out.println ( "\n****************************************\n");
          System.out.println (":: Write new second surname ");
          String second_Surname = sc.nextLine ();
          employeeToUpdate.setMaSurname (second_Surname);
          break;
        case 4:
          System.out.println ( "\n****************************************\n");
          System.out.println (":: Write new email ");
          String email = sc.nextLine ();
          employeeToUpdate.setEmail (email);
          break;
        case 5:
          System.out.println ( "\n****************************************\n");
          System.out.println (":: Write new salary ");
          Float salary = Float.valueOf (sc.nextLine ());
          employeeToUpdate.setSalary (salary);
          break;
        default:
          break;
      }
    }while(response != 0);
    em.getTransaction ().begin ();
    em.persist ( employeeToUpdate );
    em.getTransaction ().commit ();

    System.out.println ( "\n****************************************\n");
    System.out.println ("Employee has benn updated with next values: \n" + employeeToUpdate);
    System.out.println ( "\n****************************************\n");
  }
  public static void deleteEmployee (){
    System.out.println ( "\n****************************************\n");
    System.out.println (":: Write id of employee to delete");
    Scanner sc = new Scanner ( System.in );
    int id = Integer.valueOf ( sc.nextLine () );

    Employee employeeToDelete = em.find ( Employee.class, id );
    System.out.println ("\n************* Employee to modify **********\n");
    System.out.println (employeeToDelete);
    System.out.println ( "\n****************************************\n");

    System.out.println ("Are you sure to delete?");
    System.out.println (":: 1. Delete");
    System.out.println (":: 2. Go back");

    int response = Integer.valueOf ( sc.nextLine () );
    switch ( response ){
      case 1:
        em.getTransaction ().begin ();
        em.remove ( employeeToDelete );
        em.getTransaction ().commit ();
        System.out.println ( "\n****************************************\n");
        System.out.println ("Employee "+ employeeToDelete.getFirstName () + " deleted");
        break;
      default:
        break;
    }
  }
}
