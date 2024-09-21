import java.util.Scanner;

public class MyScanner {
  public static void main(String[] args){
    String name;
    int age;
    double weight;
    double height;

    System.out.println("What is your name?");
    Scanner into = new Scanner(System.in);
    name = into.nextLine();

    System.out.println("What is your age?");
    age = into.nextInt();
    
    System.out.println("What is your weight?");
    weight = into.nextDouble();
    
    System.out.println("What is your height?");
    height = into.nextDouble();

    into.close();
    System.out.println(" \tYour name is: " + name + "\n\tyou have " + age + " years \n\twight " + weight
        + " (m), \n\theight " + height + " (kg)");
    
    double imc = weight / (Math.pow(height, 2));

    System.out.println("\n\t\tYout IMC is: " + imc);
    
    if (imc <18) 
      System.out.println("\t\tYou are very skinny\n");
    if (imc >= 18 && imc <= 24) 
      System.out.println("\t\tYou havae a good weight\n");
    else
      System.out.println("\t\tYou are overweight\n");
  }
}
