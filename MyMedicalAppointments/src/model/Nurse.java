package model;

public class Nurse extends Users{

  private String speciality;

  public Nurse ( String name, String email ) {
    super ( name, email );
  }

  public String getSpeciality (){
    return speciality;
  }

  public void setSpeciality (String speciality){
    this.speciality = speciality;
  }

  @Override
  public void ShowDataUser () {
    System.out.println ("Empleado del Hospital: Cruz Verde");
    System.out.println ("Depatartamento: Nutriología, Pediatría \n");
  }
}
