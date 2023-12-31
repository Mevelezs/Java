package model;

import java.util.Date;

public class AppointmentNurse implements ISchedulable {
  private int id;
  private Patient patient;
  private Nurse nurse;
  private Date date;
  private String time;

  public AppointmentNurse ( Patient patient, Nurse nurse ) {
    this.patient = patient;
    this.nurse = nurse;
  }

  public int getId (){
    return id;
  }

  public void setPatient ( Patient patient){
    this.patient = patient;
  }

  public Patient getPatient (){
    return patient;
  }

  public void setNurse ( Nurse nurse) {
    this.nurse = nurse;
  }

  public Nurse getNurse(){
    return nurse;
  }

  public void setDate (Date date){
    this.date=date;
  }

  public Date getDate (){
    return date;
  }

  public void setTime (String time){
    this.time= time;
  }

  public String getTime () {
    return time;
  }

  @Override
  public void schedulable ( Date date, String time ) {
    this.date = date;
    this.time = time;
  }
}
