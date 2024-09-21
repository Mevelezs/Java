package herncia;

public class Persona {
  private String name;
  private int age;
  private String department;

  public Persona(int age, String name) {
    this.age = age;
    this.name = name;
  }

  public Persona (int age, String name, String department){
    this.age = age;
    this.name = name;
    this.department = department;
  }

  public String getName() {
    return this.name;
  }


  @Override
  public String toString() {
    return "name = " +  name + ", age =" + age + " dep: " + department;
  }
}
