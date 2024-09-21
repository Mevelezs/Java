public class Recursividad {
  public static void main(String[] args) {
  
    System.out.println(factorial(4));
    triangle(30);
    System.out.println(numDigitos(398433));
    System.out.println(potencia(-32, -3));
    System.out.println();
    System.out.println(isBinary(1100111));
    System.out.println(convertToBinary(8));
    System.out.println();
    System.out.println(orderWorld("ab"));
    System.out.println(orderWorld("abwcd"));
    System.out.println(orderWorld("aabc"));
    System.out.println(orderWorld("ababbc"));
    System.out.println(orderWorld("aaabbbc"));
    
   

  }

  static double factorial(int n) {
    if (n == 0)
      return 1;
    return n * factorial(n - 1);
  }

  static int triangle(int n) {
    if (n == 0)
      return 0;
    if (n > 0) {
      triangle(n - 1);
      System.out.println("* ".repeat(n));
    }
    return 0;
  }

  static int numDigitos(int n) {

    if (n == 0) return 0;
    return 1 + numDigitos(n / 10);

  }
  
  static int potencia(int a, int b) {
    if (b < 0) {
      System.out.println("Syntax error");
      return 0;
    }
    if (b == 0)return 1;
    return a *= potencia(a, b - 1);
  }

  static boolean isBinary(int a) {
    if (a == 0 || a == 1)
      return true;
    if (a % 10 == 0 || a % 10 == 1)
      return isBinary(a / 10);
    return false;
  }
  
  static String convertToBinary(int a) {
    if (a == 0)
      return "0\n";
    return convertToBinary(a / 2) + a % 2;
  }
 
  static boolean orderWorld(String a){
    if (a.length() == 1)
      return true;
    if (a.charAt(0) <= a.charAt(1)) {
      return orderWorld(a.substring(1, a.length()));
    }
    return false;
  }

  static void sumNumber(int num) {
    
  }
}
