package model;

public abstract class Users {
  private String name;
  private String email;
  private String address;
  private String phoneNumber;

  public Users ( String name, String email ) {
    this.name = name;
    this.email = email;
  }

  public String getName () {
    return name;
  }

  public void setName ( String name ) {
    this.name = name;
  }

  public void setEmail ( String email ) {
    this.email = email;
  }

  public String getEmail () {
    return email;
  }

  public void setAddress ( String address ) {
    this.address = address;
  }

  public String getAddress () {
    return address;
  }

  public void setPhoneNumber ( String phoneNumber ) {
    if ( phoneNumber.length () < 3 ) {
      System.out.println ( "The number is very short, please extend" );
    } else {
      this.phoneNumber = phoneNumber;
    }
  }
  public String getPhoneNumber () {
    return "+57 " + phoneNumber;
  }

  public abstract void ShowDataUser ();
  @Override
  public String toString () {
    return "Name: " + name + "\n" + "Email: " + email + "\n";
  }
}
