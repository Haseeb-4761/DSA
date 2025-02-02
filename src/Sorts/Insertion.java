package Sorts;
import static Sorts.Utils.*;

public class Insertion {

    static <T extends Comparable<T>> void sort (T[] array, int lo, int hi) {

        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 ; j--) {
                if (less(array[j], array[j-1])) swap(array, j, j-1);
                else break;
            }
        }

    }

    public static <T extends Comparable<T>> void sort (T[] array){
        sort(array, 0, array.length-1);
    }
}
