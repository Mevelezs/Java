package model;

public class Patient extends Users {

  private String birthday;
  private double weight;
  private double height;
  private String blood;

  public Patient ( String name, String email ) {
    super (name, email );
    System.out.println ("This is the model.Patient \n");
  }

  public void setHeight ( double height ) {
    this.height = height;
  }

  public double getHeight () {
    return height;
  }

  public void setBirthday ( String birthday ) {
    this.birthday = birthday;
  }

  public String getBirthday () {
    return birthday;
  }

  public void setWeight ( double weight ) {
    this.weight = weight;
  }

  public String getWeight () {
    return weight + " Kg.";
  }

  public void setBlood ( String blood ) {
    this.blood = blood;
  }

  public String getBlood () {
    return blood;
  }

  @Override
  public String toString () {
    return super.toString () + "Age: " + birthday+ "\n" + "Weight: " + getWeight ();
  }

  @Override
  public void ShowDataUser () {
    System.out.println ("Pasiente");
    System.out.println ("Historial completo desde nacimiento");
  }
}
