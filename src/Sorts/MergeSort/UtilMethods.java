package Sorts.MergeSort;

import static Sorts.Utils.isSorted;
import static Sorts.Utils.less;

public class UtilMethods {

    public static <T extends Comparable<T>> void merge(T[] arr, T[] aux, int lo, int mid, int hi) {
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
            else if (less(aux[j], aux[i])) arr[k] = aux[j++];  // Right element < Left element
            else arr[k] = aux[i++]; // Left element <= Right element
        }
        // Post-condition: the merged sub-array [lo..hi] is sorted
        assert isSorted(arr, lo, hi);
    }


    public static <T extends Comparable<T>> void mergeWithoutCopy(T[] arr, T[] aux, int lo, int mid, int hi) {
        // Pre-conditions: left [lo..mid] and right [mid+1..hi] sub-arrays are sorted
        assert isSorted(arr, lo, mid);
        assert isSorted(arr, mid, hi);

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi ; k++) {

            if (i > mid) arr[k] = aux[j++];  // Left half exhausted
            else if (j > hi) arr[k] = aux[i++];  // right half exhausted
            else if (less(aux[j], aux[i])) arr[k] = aux[j++];  // Right element < Left element
            else arr[k] = aux[i++]; // Left element <= Right element
        }
        // Post-condition: the merged sub-array [lo..hi] is sorted
        assert isSorted(arr, lo, hi);
    }
}
