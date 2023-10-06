package org.example.repository;

import org.example.model.Employee;
import org.example.util.ConnectionDB;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository < Employee > {

  private static Connection getConnection () throws SQLException {
    return ConnectionDB.getConnectionDB ();
  }

  @Override
  public List< Employee > findAll () throws SQLException {
    List < Employee > employees = new ArrayList<> ();
    try (
            Statement stmt = getConnection ().createStatement ();
            ResultSet rs = stmt.executeQuery ("SELECT * FROM employees");
    ) {

      while ( rs.next () ){
        Employee e = readingEmployees ( rs );
        employees.add ( e );
      }
    }
    return employees;
  }

  @Override
  public  Employee getById ( Integer id ) throws SQLException {
    Employee employee = null;
    try ( PreparedStatement ps = getConnection ().prepareStatement ("SELECT * FROM employees WHERE id = ? ") ){
       ps.setInt ( 1,id );
       try ( ResultSet rs = ps.executeQuery ()){
          if (rs.next () ){
            employee = readingEmployees ( rs );
          }
       }
    }
    return employee;
  }

  @Override
  public void save ( Employee employee, int id ) throws SQLException {
    String query;
    if(id > 0){
      query = "UPDATE employees SET first_name=?, pa_surname=?, ma_surname=?, email=?, salary=?, curp=? WHERE id ="+id;
    }else{
      query = "INSERT INTO employees ( first_name, pa_surname, ma_surname, email, salary, curp) VALUES (?, ?, ?, ?, ?, ?)";
    }
    try (PreparedStatement ps = getConnection ().prepareStatement ( query )){
      ps.setString ( 1, employee.getFirst_name () );
      ps.setString ( 2, employee.getPa_surname () );
      ps.setString ( 3, employee.getMa_surname () );
      ps.setString ( 4, employee.getEmail () );
      ps.setFloat ( 5,  employee.getSalary () );
      ps.setString (6, employee.getCurp ()  );
      ps.executeUpdate ();

      if(id > 0){
        System.out.println (" Employee has been Updated");
      }else{
        System.out.println ("Employee has been created \n ");
      }
    }
  }

  @Override
  public void delete ( Integer id ) throws SQLException {
    String query = "DELETE FROM employees WHERE id=?";
   try(PreparedStatement ps = getConnection ().prepareStatement (query)){
     ps.setInt (1, id);
     ps.executeUpdate ();
     System.out.println (" Employee deleted ");
   }
  }

  private static Employee readingEmployees ( ResultSet rs ) throws SQLException {
    Employee e = new Employee ();
    e.setId ( rs.getInt ( "id" ) );
    e.setFirst_name ( rs.getString ( "first_name" ));
    e.setPa_surname ( rs.getString ( "pa_surname" ));
    e.setMa_surname ( rs.getString ( "ma_surname" ));
    e.setEmail ( rs.getString ( "email" ) );
    e.setSalary ( rs.getFloat ( "salary" ));
    e.setCurp ( rs.getString ( "curp" ) );
    return e;
  }
}
