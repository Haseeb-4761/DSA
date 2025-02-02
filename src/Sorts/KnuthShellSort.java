package Sorts;
import static Sorts.Utils.*;

public class KnuthShellSort {

    public static <T extends Comparable<T>> void sort (T[] array) {
        int n = array.length;

        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1){
            for (int i = h; i < n; i++) {
                for (int j = i; j-h >=0 && less(array[j], array[j-h]) ; j -= h) {
                    swap(array, j, j-h);
                }
            }
            h = h/3;
        }
    }
}
