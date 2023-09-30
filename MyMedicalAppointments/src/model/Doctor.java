package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Users {
  private String speciality;
  private   ArrayList<AvailableAppointment> availableAppointments = new ArrayList<> ();

  public Doctor ( String name, String email) {
    super(name, email);
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
    /**
     * @Name: SimpleDateFormat
     * @Description:  método para dar formato y pasar de date a string y alrevés
     */
    SimpleDateFormat format = new SimpleDateFormat ("dd/MM/yyyy");

    public AvailableAppointment(String date, String time ){
      try {
        this.date = format.parse ( date ); // parcear un sting a date;
      } catch ( ParseException e ) {
        throw new RuntimeException ( e );
      }
      this.time = time;
    }

    public void setDate ( Date date ) {
      this.date = date;
    }

    public Date getDate (String DATE) {
      return date;
    }

    /**
     * @Description: metodo sobreescrito para pasar de date a string
     * @return : formatea la fecha(tipo Date) y la convierte en string
     */
    public String getDate () {
      return format.format ( date );
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


  /**
   * Description : This method add news elements for array
   * @param date : parameter of Date type fot the array
   * @param time : parameter of type string for the array
   */
  public void addAvailableAppointment(String date, String time){
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
