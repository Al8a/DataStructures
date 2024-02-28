package homework2;
import java.util.Random;
import java.util.Scanner;

public class Main {
    /*************************************************************************
 *
 *  Pace University
 *  Spring 2024
 *  Algorithms and Computing Theory
 *
 *  Course: CS 242
 *  Team members: PUT THE NAMES HERE
 *  Collaborators: PUT THE NAME OF ANY COLLABORATORS OUTSIDE YOUR TEAM HERE, IF NONE, PUT NONE
 *  References: PUT THE LINKS TO YOUR SOURCES HERE
 *
 *  Assignment: PUT THE ASSIGNMENT NUMBER HERE
 *  Problem: PUT THE PROBLEM NAME HERE
 *  Description: PUT A BRIEF DESCRIPTION HERE
 *
 *  Input:
 *  Output:
 *
 *  Visible data fields:
 *  COPY DECLARATION OF VISIBLE DATA FIELDS HERE
 *
 *  Visible methods:
 *  COPY SIGNATURE OF VISIBLE METHODS HERE
 *
 *
 *   Remarks
 *   -------
 *
 *   PUT ALL NON-CODING ANSWERS HERE
 *
 *
 *************************************************************************/

    /**
     * Creates a copy of the given array.
     *
     * @param original the original array to be copied
     * @return a new array that is a copy of the original array
     */
    public static int[] copyArray(int[] original){
        int[] copy = new int[original.length];
        for (int i = 0; i < original.length; i++){
            copy[i] = original[i];
        }
        return copy;
    }

    /**
     * Calculates the sum of all elements in the given array.
     *
     * @param array the array of integers
     * @return the sum of all elements in the array
     */
    public static int sumArray(int[] array){
        int sum = 0;
        for (int num : array){
            sum += num;
        }
        return sum;
    }

    /**
     * Generates a 2D array with random numbers and repetitions.
     *
     * @param n the number of elements in the array
     * @param r the maximum number of repetitions for each element
     * @return a 2D array with random numbers and repetitions
     */
    public static int[][] generateArray(int n, int r){
        Random random = new Random();
        int[] numbers = new int[n];
        int[] repetitions = new int[n];

        for (int i = 0; i < n; i++){
            numbers[i] = random.nextInt(1000000);
            repetitions[i] = random.nextInt(2 * r - 1) * 1;
        }

        int sum = sumArray(repetitions);
        repetitions[n - 1] += n - sum;

        int[][] array = {copyArray(numbers), copyArray(numbers)};
        return array;
    }


    /**
     * Sorts an array of integers using the QuickSort algorithm.
     *
     * @param A the array to be sorted
     * @param p the starting index of the subarray to be sorted
     * @param r the ending index of the subarray to be sorted
     */
    public static void quickSort(int[] A, int p, int r){
        if (p < r){
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }


    /**
     * Sorts an array of integers using the QuickSort algorithm.
     *
     * @param A the array to be sorted
     */
    public static void quickSort(int[] A) {
        quickSort(A, 0, A.length - 1);
    }


    /**
     * Partitions the given array into two subarrays.
     *
     * @param A the array to be partitioned
     * @param p the starting index of the subarray to be partitioned
     * @param r the ending index of the subarray to be partitioned
     * @return the index of the pivot element
     */
    public static int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++){
            if (A[j] <= x){
                i = i + 1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[r];
        A[r] = temp;
        return i + 1;
    }


    public static void countingSort(int[] A, int[] B, int k){
        int[] C = new int[k + 1];

        for (int i = 0; i <= k; i++){
            C[i] = 0;
        }

        for (int j = 1; j < A.length; j++){
            C[A[j]] = C[A[j]] + 1;
        }

        for (int i = 1; i <= k; i++){
            C[i] = C[i] + C[i - 1];
        }

        for (int j = A.length - 1; j >= 0; j--){
            B[C[A[j]]] = A[j];
            C[A[j]] = C[A[j]] - 1;
        }
    }

    public static void radixSort(int[] A, int d, int k){
        for (int i = 1; i <= d; i++) {
            int[] B = new int[A.length];
            countingSort(A, B, k);
        }
    }

    public static void radixSort(int[] A) {
        radixSort(A, 0, A.length - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the input n: ");
        int n = scanner.nextInt();
        System.out.print("Enter the expected number of repetitions r: ");
        int r = scanner.nextInt();

        int[][] arrays = generateArray(n, r);

        long quickSortStartTime = System.nanoTime();
        quickSort(arrays[0]);
        System.out.println("t= " + (System.nanoTime() - quickSortStartTime) + " nanosecs.");

        long radixSortStartTime = System.nanoTime();
        radixSort(arrays[1]);
        System.out.println("t= " + (System.nanoTime() - radixSortStartTime) + " nanosecs.");

        scanner.close();
    }
}

