import java.util.Arrays;

public class CopyArrays {
  public static void main(String[] args) {

    // copy array with same references
    int [] arr1 = {1,2,3,4,5};
    int []arr2 = arr1;

    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));

    arr2[0] = 123;

    System.out.println();
    System.out.print(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    System.out.println();

    // Both objects point to the same reference in memory
    System.out.println(arr1 + " " + arr2);
    System.out.println();


    // Copy for cloning
    int [] arr3 = {1,2,3,4,5};
    int [] clone = arr3.clone();

  //Different spaces in memory
    System.out.println(arr3 + " " + clone);
   clone [0] = 123;

   // the original array has been not affected

    System.out.print(Arrays.toString(arr3));
    System.out.print(" ");
    System.out.println(Arrays.toString(clone));
    
  }
}
