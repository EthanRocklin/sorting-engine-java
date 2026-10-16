/**
 * This class includes the classic Selection Sort algorithm,
 * global constants for specifying the extensiveness of the test,
 * and tests its runtime using the SortingEngine class.
 *
 * @author Ethan Rocklin
 */

public class SelectionSort implements Sort {

    final private static int ARRAY_COUNT = 10000;
    final private static int MAX_VAL = 10000;
    final private static int MIN_VAL = -10000;

    public static void main(String[] arg) {
        System.out.print("\nBeginning SELECTION SORT Test\n");
        SortingEngine.testSortingAlgo(new SelectionSort(), ARRAY_COUNT, MIN_VAL, MAX_VAL);
        System.out.print("End of SELECTION SORT Test\n");
    }

    /**
     * This method performs Selection Sort on an array of integers.
     * @param arr An array of integers
     * @return The array sorted in increasing order
     */
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

}
