import java.util.Arrays;

public class EjecicioDibujo {
  /**
   * 1. Diseña un método que una Stinrg en mayúsculas dentro de un rectángulo
   * formado por caracteres especiales unicode. Se debe tener en cuenta que la
   * string deberá tener 2 espacios en blanco al principio y al final, si hay
   * espacios entre palabras deberán ser como mínimo triples. La solución deberá
   * ser válida para una String de una sola línea
   * 
   * 2. Diseña un método que imprima el contenido de un Array de enteros dentro de
   * un rectángulo formado por caracteres unicode. Se debe tener en cuenta que
   * cada entero estará dentro de su propia celda. El tamaño de la celda seráa la
   * cantidad de dígitos del entero más 2. Un espacio de separación tanto antes
   * como después.
   */

  static final char ESQ_SUP_IZQ = '\u2554';
  static final char LINEA_HORIZONTAL = '\u2550';
  static final char ESQ_SUP_DER = '\u2557';
  static final char ESQ_INF_IZQ = '\u255A';
  static final char ESQ_INF_DER = '\u255D';
  static final char LINEA_VERTICAL = '\u2551';
  
  public static void main(String[] args) {

    int [] numbers = {2 ,4, 432};
    printString("Hello everybody, this is a good day to die");
    printArrays(Arrays.toString(numbers));

  }

  static void printString(String string) {
    int stringLength = string.length() * 2;
    for (int i = 0; i <= stringLength + 3; i++) {
      if (i == 0)
        System.out.print(ESQ_SUP_IZQ);
      if (i == stringLength + 3)
        System.out.println(ESQ_SUP_DER);
      else
        System.out.print(LINEA_HORIZONTAL);

    }

    for (int i = 0; i < string.length(); i++) {
      if (i == 0)
        System.out.print(LINEA_VERTICAL + "  ");

      System.out.print(string.charAt(i) + " ");
    }
    System.out.println(" " + LINEA_VERTICAL);

    for (int i = 0; i <= stringLength + 3; i++) {
      if (i == 0)
        System.out.print(ESQ_INF_IZQ);
      if (i == stringLength + 3)
        System.out.println(ESQ_INF_DER);
      else
        System.out.print(LINEA_HORIZONTAL);
    }
  }
  
  static void printArrays(String number) {
    System.out.println( number);
   
  }

}
