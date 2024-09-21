import java.util.Arrays;

public class VarArgs {
  public static void main(String[] args) {
    int num1 = 10, num2 = 42, num3 = 31;
    ShowIntegers(num1, num1, num3, num3, num2);
  }

  static void ShowIntegers (int... date){
    System.out.println(Arrays.toString(date));
    for (int num: date){
      System.out.print(num+ " ");
    }
  }
}
