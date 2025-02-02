package Sorts;

class Utils {

    public static <T extends Comparable<T>> boolean less (T first, T second) {
        return first.compareTo(second) < 0;
    }

    public static <T extends Comparable<T>> void swap (T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T extends Comparable<T>> boolean isSorted (T[] arr, int lo, int hi) {
        for (int i = lo; i < hi ; i++) {
            if (less(arr[i+1], arr[i])) return false;
        }
        return true;
    }

    public static <T extends Comparable<T>> boolean isSorted (T[] arr) {
        return isSorted(arr,0, arr.length-1);
    }
}
