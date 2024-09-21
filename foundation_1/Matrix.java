import java.util.Arrays;

public class Matrix {
  public static void main(String[] args) {
    int[][] matrix = { { 1, 2, 3 }, { 5, 4, 3 }, { 9, 8, 76 } };
    int[][][] matrix2 = { { { 4, 3, 2 }, { 8, 6, 7 } }, { { 8, 7, 8, 9, 3 }, { 3, 4, 2, 6 } } };

    matrix[0][1] = 3;
    System.out.println(matrix[0][1]);
    System.out.println(matrix[1].length);

    for (int[] iterator : matrix) {
      System.out.print("[ ");
      for (int i : iterator) {
        System.out.print(i + ", ");
      }
      System.out.print("\b\b");
      System.out.println(" ]");
    }

    System.out.println("----------------------------");
    for (int[] i : matrix) {
      System.out.println(Arrays.toString(i));
    }

    System.out.println("----------------------------");

    System.out.println(Arrays.deepToString(matrix2));

    System.out.println("----------------------------");

    System.out.println(Arrays.deepToString(createMatix(10)));

    System.out.println("----------------------------");

    printMatrix(createMatix(10));

    System.out.println("----------------------------- x");

    printInvertedDiagonal(createMatix(10));

  }

  static int[][] createMatix(int n) {
    return new int[n][n];
  }

  static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (i == j)
          System.out.print(" x ");
        else
          System.out.print(" - ");
      }
      System.out.println();
    }
  }

  static void printInvertedDiagonal(int[][] matrix) {
    int count = matrix.length - 1;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (j == count)
          System.out.print(" x ");
        else
          System.out.print(" - ");
      }
      count--;
      System.out.println();
    }
  }
  
  
}
