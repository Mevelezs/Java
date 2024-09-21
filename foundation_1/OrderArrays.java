import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Random;

public class OrderArrays {
  public static void main(String[] args) {
    int[] arr1 = getArray();
    int [] arr2 = arr1.clone();

    System.out.println(Arrays.toString(arr1));
    System.out.println("Length array " + arr1.length);
    System.out.println("-----------------------------");

    long init2 = System.currentTimeMillis();
    QuickSort(arr1, 0, arr1.length - 1);
    long end2 = System.currentTimeMillis();

    System.out.println("QuickSort " + (end2 - init2) + " ms");

    Instant init = Instant.now();
    BubbleSort(arr2);
    Instant end = Instant.now();

    System.out.println("BubbleSort " + Duration.between(init, end).toMillis()+ " ms");


  }

  static int [] getArray () {
    Random rand = new Random();
    int value = rand.nextInt(100000);

    int [] arr = new int [value];
    for (int i = 0; i < value; i++) {
      arr[i] = rand.nextInt(1000);
    }
    return arr;
  }
  // Bubblesort (algoritmo de ordenamiento de burbuja)
  static void BubbleSort(int [] arr1){
    for (int i = 0; i <= arr1.length;  i++) {
      int current;
      for (int j = 0; j < arr1.length - i - 1; j++) {
        if( arr1[j + 1] < arr1[j]){
          current = arr1[j];
          arr1[j] = arr1[j + 1];
          arr1[j + 1] = current;
        }
      }
    }
  }

  // QuickSort
  static void QuickSort (int arr[], int izq, int der){
    int pivot = arr[izq];
    int i = izq;
    int j = der;
    int aux;

    while ( i < j) {
      while (arr[i] <= pivot && i < j) i++; // evaluate from izq to der => find values <= pivot and checking that they
      // not crossed
      while (arr[j] > pivot) j--; // evaluate for der to izq => find values > pivot
      if ( i < j ){ // fix the position of the first values find the not meet the conditions
        aux = arr[i];
        arr[i] = arr [j];
        arr[j] = aux;
      }
    }

    // Put the pivot in its final position
    arr[izq] = arr[j];
    arr[j] = pivot;

    if(izq < j-1) QuickSort(arr, izq, j-1); // order left sub-array if sub-array has a minimum two items
    if (j+1 < der) QuickSort(arr, j+1, der); // order right sub-array, if sub-array has minimum two items
  }
}
