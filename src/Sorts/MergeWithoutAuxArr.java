package Sorts;

import static Sorts.Utils.*;

public class MergeWithoutAuxArr {
    private static <T extends Comparable<T>> void merge(T[] arr, T[] aux, int lo, int mid, int hi) {
        // Pre-conditions: left [lo..mid] and right [mid+1..hi] sub-arrays are sorted
        assert isSorted(arr, lo, mid);
        assert isSorted(arr, mid, hi);

        for (int i = lo; i <= hi ; i++) {
            aux[i] = arr[i];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi ; k++) {
            if (i > mid) arr[k] = aux[j++];  // Left half exhausted
            else if (j > hi) arr[k] = aux[i++];  // right half exhausted
            else if (less(aux[j], aux[i])) swap(arr, i , j);  // Right element < Left element
            else arr[k] = aux[i++]; // Left element <= Right element
        }
        // Post-condition: the merged sub-array [lo..hi] is sorted
        assert isSorted(arr, lo, hi);
    }

    private static <T extends Comparable<T>> void divide(T[] arr, T[] aux, int lo, int hi) {
        if (hi <= lo+7){
            Insertion.sort(arr, lo, hi);
            return;
        }

        int mid = lo + (hi-lo)/2;

        // Recursively sort left half
        divide(arr,aux, lo, mid);
        // Recursively sort right half
        divide(arr,aux,mid+1,hi);
        // for performance enhancement, if first half is less than second half, no need to merge
        if (less(arr[mid], arr[mid+1])) return;
        // merge two halves
        merge(arr, aux, lo, mid, hi);
    }

    public static <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;
        T[] aux = (T[]) new Comparable[n];
        divide(arr, aux, 0, n-1);
    }
}
