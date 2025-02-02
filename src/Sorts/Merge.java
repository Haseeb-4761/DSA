package Sorts;

public class Merge {

    // Merge function: combines two sorted subarrays into one sorted subarray
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // Preconditions: left [lo..mid] and right [mid+1..hi] subarrays are sorted
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        // Copy the array into auxiliary array
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // Merge the sorted halves
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {                  // Left half exhausted
                a[k] = aux[j++];
            } else if (j > hi) {            // Right half exhausted
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) { // Right element < Left element
                a[k] = aux[j++];
            } else {                        // Left element <= Right element
                a[k] = aux[i++];
            }
        }

        // Postcondition: the merged subarray [lo..hi] is sorted
        assert isSorted(a, lo, hi);
    }

    // Recursive sort function
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return; // Base case: single element is already sorted
        int mid = lo + (hi - lo) / 2;

        // Recursively sort the left half
        sort(a, aux, lo, mid);

        // Recursively sort the right half
        sort(a, aux, mid + 1, hi);

        // Merge the two sorted halves
        merge(a, aux, lo, mid, hi);
    }

    // Public API: Sorts the entire array
    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length]; // Auxiliary array
        sort(a, aux, 0, a.length - 1);
    }

    // Helper function: checks if one element is less than another
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // Helper function: checks if an array is sorted within a range
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            if (less(a[i + 1], a[i])) return false;
        }
        return true;
    }

    // Main method to test the MergeSort implementation
    public static void main(String[] args) {
        Integer[] array = {1, 5, 8, 3, 9, 2, 4, 7};

        System.out.println("Original array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Sort the array
        Merge.sort(array);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}

