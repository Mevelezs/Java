package herncia.Abstractas;

public class Circle extends MetodosFiguras2D{

  private int radio;

  public Circle(int radio) {
    super();
    this.radio = radio;
  }

  @Override
  double perimeter() {
    return (double) 2 * Math.PI * radio;
  }

  @Override
  double area() {
    return Math.PI * Math.pow(radio, 2);
  }

  @Override
  public String toString() {
    return "The circle whit radio: "+radio+" has the following properties"
            + "\nPerimeter: " + this.perimeter()
            + " \nArea: " + this.area();
  }
}
