public class sortingAlgorithims {
    /*
    COUNTING-SORT(A, B, k)
    1 let C[0..k] be a new array
    2 for i=0 to k
    3   C[i] = 0
    4 for j=1 to A.length
    5   C[A[j]] = C[A[j]] + 1
    6 //C[i]now contains the number of elements equal to i.
    7 for i=1 to k
    8   C[i]=[C[i]+C[i-1]]
    9 //C[i]now contains the number of elements less than or equal to i.
    10 for j A.length downto 1
    11  B[C[A[j]]] = A[j]
    12  C[A[j]] = C[A[j]] - 1
    */

    /**
     * Sorts an array of integers using the Counting Sort algorithm.
     *
     * @param A the input array to be sorted
     * @param B the output array that will contain the sorted elements
     * @param k the maximum value in the input array
     */
    public static void countingSort(int[] A, int[] B, int k) {
        int[] C = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            C[i] = 0;
        }

        for (int j = 0; j < A.length; j++) {
            C[A[j]]++;
        }

        for (int i = 1; i <= k; i++) {
            C[i] += C[i - 1];
        }

        for (int j = A.length - 1; j >= 0; j--) {
            B[C[A[j]] - 1] = A[j];
            C[A[j]]--;
        }
    }

    /*
    RADIX-SORT(A[])
    1 for each digit d from right to left do
    2   Stable Counting Sort(A,d)
    3 end
    */
    public static void radixSort(int[] A, int d, int k) {
        for (int i = 1; i <= d; i++) {
            int[] B = new int[A.length];
            countingSort(A, B, k);
            A = B;
        }
    }



// end Radix Sort Algorithim Implementation

/*---------------------------------------------------------*/

// QuickSort Algorithim Implementation
    /*
    QUICKSORT(A, p, r)
    1 if p < r
    2   q = PARTITION(A, p, r)
    3   QUICKSORT(A, p, q - 1)
    4   QUICKSORT(A, q + 1, r)
    */

    /**
     * Sorts an array of integers using the QuickSort algorithm.
     *
     * @param A the array to be sorted
     * @param p the starting index of the subarray to be sorted
     * @param r the ending index of the subarray to be sorted
     */
    public static void quickSort(int[] A, int p, int r) {
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static void quickSortRandom(int[] A, int p, int r) {
        if (p < r) {
            int q = partitionRandom(A, p, r);
            quickSortRandom(A, p, q - 1);
            quickSortRandom(A, q + 1, r);
        }
    }



    /*
    PARTITION(A, p, r)
    1 x = A[r]
    2 i = p - 1
    3 for j = p to r - 1
    4   if A[j] <= x
    5       i = i + 1
    6       exchange A[i]with A[j]
    7 exchange A[i+1] with A[r]
    8 return i + 1

    At the beginning of each iteration of the loop of lines 3–6, for any array
    index k, we have:

    1. If p <= k <= i, then A[k] <= x.
    2. If i+1 <= k <= j-1, then A[k] > x .
    3. If k = r, then A[k] = x.
    */


    /**
     * Partitions the given array into two subarrays.
     *
     * @param A the array to be partitioned
     * @param p the starting index of the subarray to be partitioned
     * @param r the ending index of the subarray to be partitioned
     * @return the index of the pivot element
     */
    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
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




    /**
     * Partitions the given array into two subarrays with the pivot chosen at random.
     *
     * @param A the array to be partitioned
     * @param p the starting index of the subarray to be partitioned
     * @param r the ending index of the subarray to be partitioned
     * @return the index of the pivot element
     */

    public static int partitionRandom(int[] A, int p, int r) {
        int pivot = (int) (Math.random() * (r - p + 1) + p);
        int temp = A[r];
        A[r] = A[pivot];
        A[pivot] = temp;
        return partitionRandom(A, p, r);
    }


    public static void quickSortArray(int[] A){
        quickSort(A, 0, A.length - 1);
    }

    public static void quickSortRandomArray(int[] A){
        quickSortRandom(A, 0, A.length - 1);
    }




    public static void countingSortPdfExample(){
        int[] A = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] B = new int[A.length];
        int k = 5;

        countingSort(A, B, k);

        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
    }



    public static void main(String[] args) {
        countingSortPdfExample();


    }
}


