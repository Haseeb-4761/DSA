package Sorts;

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

class LearnMergeSort {

    // Helper method to compare two elements
    private static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    // Merges two sorted subarrays from the auxiliary array back into the original array
    private static <T extends Comparable<T>> void merge(T[] arr, T[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;

        // Merge the two sorted halves from 'aux' back into 'arr'
        for (int k = lo; k <= hi; k++) {
            if (i > mid) arr[k] = aux[j++];  // Left half exhausted, take from right half
            else if (j > hi) arr[k] = aux[i++];  // Right half exhausted, take from left half
            else if (less(aux[j], aux[i])) arr[k] = aux[j++];  // Right element < Left element
            else arr[k] = aux[i++];  // Left element <= Right element
        }
    }

    // Recursively sorts the array using the auxiliary array and switches roles
    private static <T extends Comparable<T>> void divide(T[] arr, T[] aux, int lo, int hi) {
        if (hi <= lo) return;  // Base case, when lo >= hi, stop recursion

        int mid = lo + (hi - lo) / 2;

        // Recursively sort the left and right halves, switching roles of 'arr' and 'aux'
        divide(aux, arr, lo, mid);  // Sort left half in 'aux'
        divide(aux, arr, mid + 1, hi);  // Sort right half in 'aux'

        // Merge the two halves back into the original array (arr)
        merge(arr, aux, lo, mid, hi);
    }

    // Wrapper method to initialize the auxiliary array and start the sorting
    public static <T extends Comparable<T>> void sort(T[] arr) {
        T[] aux = Arrays.copyOf(arr, arr.length);  // Create auxiliary array and copy elements from 'arr'
        divide(arr, aux, 0, arr.length - 1);  // Start sorting from index 0 to n-1
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 5, 9, 6, 4, 2, 12, 10};  // Example input array
        sort(arr);  // Call the sorting method
        StdOut.println(Arrays.toString(arr));  // Print the sorted array
    }
}