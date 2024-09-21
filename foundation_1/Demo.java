import java.util.Scanner;

class Demo {
  public static void main(String[] args) {

    // https://unicode-table.com/es/
    char let = '\u2211';
    char let2 = '\u2605';
    int number = 3;
    byte b = 0b1110110;
    byte h = 0x7F;

    System.out.println(number);

    String s = "\"Hola  \\ \"";

    String block = "\tLorem ipsum dolor sit amet consectetur adipisicing elit. Voluptate soluta \n\tobcaecati eaque culpa tenetur adipisci illum maiores illo nesciunt officiis \n\tnobis omnis, incidunt id dolor placeat! Dolore delectus vel repellendus?\n";

    System.out.println(let + " " + let2);
    System.out.println(s + " " + s.charAt(2));
    System.out.println(block);

    String name1 = "MAuricio";
    String name2 = "Mauricio";

    Double d = 1.2;

    System.out.println(d.byteValue());
    System.out.println(name1.equalsIgnoreCase(name2));
    System.out.println(!false ^ !true);
    System.out.println(b + " " + ~h);
    System.out.println(Math.sqrt(2));
    System.out.println(Math.pow(2, 3));
    System.out.println(Math.PI);
    System.out.println(Math.acos(1 / 2));

    System.out.println();
    int result = suma(30, 70);
    System.out.println(result);

    greeting("Mauricio");

    System.out.println(cube(number));
    System.out.println(multipply(number, 0));
    System.out.println(multipply(7, 3));

    Scanner n = new Scanner(System.in);
    int option = n.nextInt();

    evenOrOdd(option);

    System.out.println();

    System.out.println("Write a number");
    System.out.println("menu");
    System.out.println("1. Option 1");
    System.out.println("2. Option 2");
    System.out.println("0. Exit");
    System.out.println("...other optios");

    Scanner m = new Scanner(System.in);
    int option2 = m.nextInt();

    do{
    Scanner opt = new Scanner(System.in);
    int r = opt.nextInt();
    menu(r);
    option2 = r;
    if (option2 == 0)
    System.out.println("...bye");
  else {
    System.out.println("Write a  other option");
  }
  }while(option2!=0);
    
  n.close();
  m.close();
  
  }

  static int suma(int a, int b) {
    return a + b;
  }

  static void greeting(String name) {
    System.out.println("Hello " + name);
  }

  static double cube(double number) {
    return Math.pow(number, 3);
  }

  static int multipply(int num1, int num2) {
    if (num2 == 0) {
      for (int i = 1; i <= 10; i++) {
        System.out.println(num1 + " * " + i + " = " + num1 * i);
      }
    }
    return num1 * num2;
  }

  static void evenOrOdd(int num) {
    if (num == 0) {
      System.out.println("The number " + num + " is even and odd");
    } else if (num % 2 == 0) {
      System.out.println("The number " + num + " is even");
    } else {
      System.out.println("The number " + num + " is odd");
    }
  }

  static void menu(int num) {
    System.out.println("You have selected option " + num);
  }
}