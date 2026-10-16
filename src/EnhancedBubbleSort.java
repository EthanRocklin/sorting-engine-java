/**
 * This class includes an enhanced Bubble Sort algorithm,
 * global constants for specifying the extensiveness of the test,
 * and tests its runtime using the SortingEngine class.
 *
 * @author Ethan Rocklin
 */

public class EnhancedBubbleSort implements Sort {

    final private static int ARRAY_COUNT = 5000;
    final private static int MAX_VAL = 100000;
    final private static int MIN_VAL = -100000;

    public static void main(String[] arg) {
        System.out.print("\nBeginning ENHANCED BUBBLE SORT Test\n");
        SortingEngine.testSortingAlgo(new EnhancedBubbleSort(), ARRAY_COUNT, MIN_VAL, MAX_VAL);
        System.out.print("End of ENHANCED BUBBLE SORT Test\n");
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
        int itrCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - itrCount - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swaps the current and next elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            } // Stops sorting if the array is already sorted (a swap never happened)
            if (!swapped) {
                break;
            }
            itrCount++;
        }
        return arr;
    }

}
