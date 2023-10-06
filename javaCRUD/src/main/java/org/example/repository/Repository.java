package org.example.repository;

import org.example.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface Repository < T > {
  List < T > findAll () throws SQLException;
  T getById ( Integer id ) throws SQLException;
  void save ( Employee employee, int id ) throws SQLException;
  void delete ( Integer id ) throws SQLException;
}
