/**
 * This class includes the classic definition of Insertion Sort,
 * global constants for specifying the extensiveness of the test,
 * and tests its runtime using the SortingEngine class.
 *
 * @author Ethan Rocklin
 */

public class InsertionSort implements Sort {

    final private static int ARRAY_COUNT = 10000;
    final private static int MAX_VAL = 100000;
    final private static int MIN_VAL = -100000;

    public static void main(String[] arg) {
        System.out.print("\nBeginning INSERTION SORT Test\n");
        SortingEngine.testSortingAlgo(new InsertionSort(), ARRAY_COUNT, MIN_VAL, MAX_VAL);
        System.out.print("End of INSERTION SORT Test\n");
    }

    /**
     * This method performs Insertion Sort on an array of integers.
     * @param arr An array of integers
     * @return The array sorted in increasing order
     */
    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
           int curr = arr[i];
           // Starts index for the scan one element behind the current element
           int j = i - 1;
           // Checks elements to the left until a small integer to the current is found
           while (j >= 0 && arr[j] > curr) {
               arr[j + 1] = arr[j];
               j--;
           }
           // Swaps the current element being sorted with the next smallest element
           arr[j + 1] = curr;
       }
        return arr;
    }

}
