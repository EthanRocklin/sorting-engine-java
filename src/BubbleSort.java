/**
 * This class includes the classic definition of Bubble Sort,
 * global constants for specifying the extensiveness of the test,
 * and tests its runtime using the SortingEngine class.
 *
 * @author Ethan Rocklin
 */

public class BubbleSort implements Sort {

    final private static int ARRAY_COUNT = 5000;
    final private static int MAX_VAL = 100000;
    final private static int MIN_VAL = -100000;

    public static void main(String[] arg) {
        System.out.print("\nBeginning BUBBLE SORT Test\n");
        SortingEngine.testSortingAlgo(new BubbleSort(), ARRAY_COUNT, MIN_VAL, MAX_VAL);
        System.out.print("End of BUBBLE SORT Test\n");
    }

    /**
     * This method performs Bubble Sort on an array of integers.
     * @param arr An array of integers
     * @return The array sorted in increasing order
     */
    public int[] sort(int[] arr) {
        // Edge cases
        if (arr.length < 2) {
            return arr;
        }
        // Algorithm starts
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swaps the current and next elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

}