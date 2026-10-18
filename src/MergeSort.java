import java.util.Arrays;

/**
 * This class includes the classic Merge Sort algorithm,
 * global constants for specifying the extensiveness of the test,
 * and tests its runtime using the SortingEngine class.
 *
 * @author Ethan Rocklin
 */

public class MergeSort implements Sort {

    final private static int ARRAY_COUNT = 100000;
    final private static int MAX_VAL = 100000;
    final private static int MIN_VAL = -100000;

    public static void main(String[] arg) {
        System.out.print("\nBeginning MERGE SORT Test\n");
        SortingEngine.testSortingAlgo(new MergeSort(), ARRAY_COUNT, MIN_VAL, MAX_VAL);
        System.out.print("End of MERGE SORT Test\n");
    }

    /**
     * This method performs Merge Sort on an array of integers.
     * @param arr An array of integers
     * @return The array sorted in increasing order
     */
    public int[] sort(int[] arr) {
        // Edge cases and recursive base case
        if (arr.length < 2) {
            return arr;
        }
        int[] leftPart = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] rightPart = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        sort(leftPart);
        sort(rightPart);
        merge(leftPart, rightPart, arr);
        return arr;
    }

    /**
     * This method is a helper to the Merge Sort algorithm. It merges two sorted
     * parts of an array back into that array.
     * @param leftPart the first sorted subarray
     * @param rightPart the second sorted subarray
     * @param sorted the array used to merge the left and right parts
     * @return a sorted array in ascending order
     */
    private int[] merge(int[] leftPart, int[] rightPart, int[] sorted) {
        // Indices for the three arrays
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftPart.length && j < rightPart.length) {
            if (leftPart[i] <= rightPart[j]) {
                sorted[k] = leftPart[i];
                i++;
            } else {
                sorted[k] = rightPart[j];
                j++;
            }
            k++;
        }
        // Copies any remaining, sorted elements into the sorted array
        while (i < leftPart.length) {
            sorted[k++] = leftPart[i++];
        }
        while (j < rightPart.length) {
            sorted[k++] = rightPart[j++];
        }
        return sorted;
    }

}
