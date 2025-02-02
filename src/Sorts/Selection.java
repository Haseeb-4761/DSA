package Sorts;
import static Sorts.Utils.*;

public class Selection {

    public static <T extends Comparable<T> > void sort (T[] array) {
        int n = array.length;

        for (int i=0; i<n; i++) {
            int min = i;
            for (int j = i+1; j < n ; j++) {
                if (less(array[j], array[min])) min = j;
            }
            swap(array, i , min);
        }
    }
}
