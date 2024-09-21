package herncia;

import java.util.Objects;

public class Student extends Persona{
  private int credits;

  public Student( String name, int age){
    super(age, name);
    this.credits = 60;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return credits == student.credits;
  }

  @Override
  public String toString() {
    return "The alum with name " + super.getName() + " has " + this.credits + " credits in course";
  }
}
