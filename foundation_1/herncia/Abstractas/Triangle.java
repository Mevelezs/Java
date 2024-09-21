package herncia.Abstractas;

import static java.lang.Math.*;

public class Triangle extends MetodosFiguras2D{
  private int l1;
  private int l2;
  private int l3;

  public Triangle(int l1, int l2, int l3) {
    super();
    this.l1 = l1;
    this.l2 = l2;
    this.l3 = l3;
  }

  @Override
  double perimeter() {
    return (double) (l1 + l2 + l3)/2;
  }

  @Override
  double area() {
    double p = this.perimeter();
    double a = sqrt(p * ( (p-l1) * (p-l2) * (p-l3) ));
    return a;
  }

  @Override
  public String toString() {
    return "The triangle whit sades: " + l1 + ", "+l2 + ", and "+l3 +" has the following properties"
            + "\nPerimeter: " + this.perimeter()
            + " \nArea: " + this.area();
  }
}
