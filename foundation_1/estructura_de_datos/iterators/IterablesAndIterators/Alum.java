package estructura_de_datos.iterators.IterablesAndIterators;

public class Alum {
  private final String name;
  private final int age;
  private final double grade;

  public Alum ( String name, int age, double grade ) {
    this.name = name;
    this.age = age;
    this.grade = grade;
  }

  public String getName () {
    return name;
  }

  public int getAge () {
    return age;
  }

  public double getGrade () {
    return grade;
  }

  @Override
  public String toString () {
    return "Alum [ " + "name = " + name + ", age = " + age + ", grade = " + grade + " ]";
  }
}
