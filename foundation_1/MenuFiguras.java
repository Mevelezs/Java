import java.util.Scanner;

public class MenuFiguras {
  public static void main(String[] args) {
    System.out.println();
    System.out.println("Figures menu");
    System.out.println();
    menu();
  }

  static void cuadradoLLeno(int a) {
    System.out.println();
    for (int i = 0; i < a; i++) {
      System.out.println("* ".repeat(a));
    }
    System.out.println();

  }

  static void cuadradoVacio(int a) {
    System.out.println();
    for (int i = 0; i < a; i++) {
      if (i == 0)
        System.out.println("* ".repeat(a));
      if (i > 0 && i < a - 1)
        System.out.println("*" + "  ".repeat(a - 2) + " *");
      if (i == a - 1)
        System.out.println("* ".repeat(a));
    }
    System.out.println();
  }

  static void trianguloLleno(int h) {
    System.out.println();

    for (int i = 0; i < h; i++) {
      System.out.println("* ".repeat(i));
    }
    System.out.println();

  }

  static void trianguloVacio(int h) {
    System.out.println();

    for (int i = 0; i < h; i++) {
      if (i == 0 || i == 1)
        System.out.println("* ".repeat(i + 1));
      if (i > 1 && i < h - 1)
        System.out.println("*" + "  ".repeat(i - 1) + " *");
      if (i == h - 1)
        System.out.println("* ".repeat(h));
    }
    System.out.println();

  }

  static void menu() {
    Scanner menu = new Scanner(System.in);
    int num = 0;

    do {

      callMenu();
      num = menu.nextInt();
      Scanner data = new Scanner(System.in);

      switch (num) {
        case 1:
          System.out.println("Empty square");
          System.out.println("Write the side of the square");
          int option1 = data.nextInt();
          cuadradoVacio(option1);
          break;

        case 2:
          System.out.println("Filled square");
          System.out.println("Write the side of the square");
          int option2 = data.nextInt();
          cuadradoLLeno(option2);
          break;

        case 3:
          System.out.println("Empty triangule");
          System.out.println("Write the hight of the triangle");
          int option3 = data.nextInt();
          trianguloVacio(option3);
          break;

        case 4:
          System.out.println("Filled triangule");
          System.out.println("Write the hight of the triangle");
          int option4 = data.nextInt();
          trianguloLleno(option4);
          break;

        case 0:
          System.out.println("Bye...");
          data.close();
          break;

        default:
          System.out.println();
          System.out.println("Option not valid");
          break;
      }
    } while (num != 0);
    menu.close();
  }

  static void callMenu() {
    System.out.println("Option menu");
    System.out.println("1.- Empty square");
    System.out.println("2.- Filled square");
    System.out.println("3.- Empty triangule");
    System.out.println("4.- Filled triangule");
    System.out.println("0.- Exit");
    System.out.println("Select an option");
    System.out.println();
  }
}
