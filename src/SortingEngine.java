import java.time.Instant;
import java.time.Duration;
import java.util.Random;

/**
 * This class is the primary engine for testing the accuracy of various
 * sorting algorithms. It randomly generates a specified number of arrays
 * with a specified size and range of possible integers. The specifiers
 * for each test are implemented as global constants in their respective
 * sorting class. For example, the specifications for Insertion Sort and
 * Merge Sort are within their respective classes.
 *
 * To test a particular sorting algorithm that sorts in increasing order,
 * simply run the class for that sorting algorithm. If the class for your
 * algorithm does not exist, create a class amd follow a similar structure
 * to an existing sorting class in this package. For example, make sure that
 * the ARRAY_COUNT, SIZE, MAX_VAL, and MIN_VAL are global constants or
 * define them such that SortingEngine.testSortingAlgo() can be called safely,
 * and that they have appropriate values befitting valid arrays and integer
 * limits.
 *
 * @author Ethan Rocklin
 */

public class SortingEngine {

    /**
     * This method generates an array of random integers within a defined range.
     * @param size The number of elements in the array
     * @param min The smallest integer that can be in the array
     * @param max The largest integer that can be in the array
     * @return An array of random integers
     */
    public static int[] generateArray(int size, int min, int max) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(min, max + 1);
        }
        return arr;
    }

    /**
     * This method determines if an array is sorted in increasing order.
     * @param arr An array of integers
     * @return A boolean indicating if the array is sorted
     */
    private static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void testSortingAlgo(int arrCount, int size, int min, int max) {
        // Checks for invalid arguments
        if (arrCount < 1) {
            System.out.print("INVALID array count. REQUIRED: arrCount > 0\n");
        }
        if (size < 0) {
            System.out.print("INVALID array size. REQUIRED: size >= 0\n");
        }
        if (min > max) {
            System.out.print("INVALID array size. REQUIRED: \n");
        }
        int count = 0;
        int passed = 0;
        int failed = 0;
        // Captures the effective start of the test
        Instant start = Instant.now();
        while (count < arrCount) {
            int[] arr = generateArray(size, min, max);
            arr = InsertionSort.sort(arr);
            if (isSorted(arr)) {
                passed++;
            } else {
                failed++;
            }
            System.out.printf("\rSuccessful Tests: %d/%d\t\tFailed Tests: %d/%d",
                    passed, arrCount, failed, arrCount);
            count++;
        }
        Instant end = Instant.now();
        printTimes(start, end);
    }

    /**
     * This method prints an array to the console.
     * @param arr An array of integers
     */
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]);
            System.out.print(", ");
        }
        System.out.print(arr[arr.length - 1]);
        System.out.print("]\n");
    }

    /**
     * This method prints the nanoseconds, milliseconds, seconds, and minutes
     * it took for the tested sorting method to complete.
     * @param start The Instant object representing the start of the test
     * @param end The Instant object representing the end of the test
     */
    public static void printTimes(Instant start, Instant end) {
        Duration duration = Duration.between(start, end);
        long milliseconds = duration.toMillis();
        System.out.print("\n\nTest Times\n");
        System.out.print("----------\n");
        System.out.printf("Nanoseconds:\t%d\n", duration.toNanos());
        System.out.printf("Milliseconds:\t%d\n", milliseconds);
        System.out.printf("Seconds:\t\t%f\n", milliseconds / 1000.0);
        System.out.printf("Minutes:\t\t%f\n\n", milliseconds / 60000.0);
    }

}
