import java.util.Arrays;

public class Arrayss {
  public static void main(String[] args) {
    int[] arr = {3, 2, 3, 6, 4, 3};
    int[] arr2 = {2, 4, 3, 5, 6, 7, 8, 6, 8, 9, 21};
    int num = 3;
    char a = 'a';

    String[] arrString = {"dsa", "asdc", "lknmk", "hfgavba", "ada"};

    addIntArray(arr, num);
    addStringArray(arrString);
    addStringArray(arrString, a);
    addIntArray(arr, arr2);
  }

  static void addIntArray(int[] arr, int num) {
    System.out.println(countNumber(arr, num));
  }

  static void addIntArray(int[] arr1, int[] arr2) {
    System.out.println(Arrays.toString(compareArrays(arr1, arr1)));
  }


  static void addStringArray(String[] arr) {
    System.out.println(moreLonString(arr));
  }

  static void addStringArray(String[] arr, char a) {
    startWidth(arr, a);
  }

  static int countNumber(int[] arr, int num) {
    int count = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        count++;
      }
    }
    return count;

  }

  static String moreLonString(String[] arrs) {
    String longString = " ";

    for (int i = 0; i < arrs.length; i++) {
      if (arrs[i].length() >= longString.length()) {
        longString = arrs[i];
      }
    }
    return longString;
  }

  static void startWidth(String[] arr, char a) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].charAt(0) == a)
        System.out.println(arr[i]);
    }
  }

  static int[] compareArrays(int[] arr1, int[] arr2) {
    int maxLength = 0;
    if (arr1.length > arr2.length)
      maxLength = arr1.length;
    else
      maxLength = arr2.length;

    int[] result = new int[maxLength];

    for (int i = 0; i < maxLength; i++) {
      if (arr1[i] > arr2[i]) {
        result[i] = arr1[i];
      } else {
        result[i] = arr2[i];
      }
    }
    return result;
  }
}
