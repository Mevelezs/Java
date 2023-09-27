package model;

import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Users {
  private String speciality;


  public Doctor ( String name, String email, String speciality ) {
    super(name, email);
    System.out.println ("This is the model.Doctor with your dates \n");
    this.speciality = speciality;
  }


  public void setSpeciality ( String speciality ) {
    this.speciality = speciality;
  }

  public String getSpeciality () {
    return speciality;
  }

  public static class AvailableAppointment {
    private int id;
    private Date date;
    private String time;

    public AvailableAppointment(Date date, String time ){
      this.date = date;
      this.time = time;
    }

    public void setDate ( Date date ) {
      this.date = date;
    }

    public Date getDate () {
      return date;
    }

    public void setTime ( String time ) {
      this.time = time;
    }

    public String getTime () {
      return time;
    }

    public void setId ( int id ) {
      this.id = id;
    }

    public int getId () {
      return id;
    }

    @Override
    public String toString () {
      return "Available Appointments" + "\nDate: " + date + "\nTime: " + time;
    }
  }

  /**
   * This us the form to create ArrayLists
   */
  ArrayList<AvailableAppointment> availableAppointments = new ArrayList<> ();

  /**
   * Description : This method add news elements for array
   * @param date : parameter of Date type fot the array
   * @param time : parameter of type string for the array
   */
  public void addAvailableAppointment(Date date, String time){
    availableAppointments.add( new AvailableAppointment ( date, time ));
  }

  /**
   * @return An Array list of availability appointment
   */
  public ArrayList<AvailableAppointment> getAvailableAppointments (){
    return availableAppointments;
  }

  @Override
  public void ShowDataUser () {
    System.out.println ("Empleado del Hospital: Cruz Roja");
    System.out.println ("Depeartamento: Cancerorlogía \n");
  }

  @Override
  public String toString () {
    return super.toString () + "\nSpeciality: " + speciality + "\nAvailable: " + getAvailableAppointments ();
  }
};
