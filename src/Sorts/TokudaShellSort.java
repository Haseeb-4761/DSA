package Sorts;
import static Sorts.Utils.*;

public class TokudaShellSort {

    public static <T extends Comparable<T>> void sort (T[] array) {
        double y = 2.2436091;
        int n = array.length, h = 0, k = 2;
        while(h < (int)(n/y)){
            h = (int)(Math.pow(y, k-1) / (y-1));
            k++;
        }

        while (h >= 1){
            for (int i = h; i < n; i++) {
                for (int j = i; j-h >=0 && less(array[j], array[j-h]) ; j -= h) {
                    swap(array, j, j-h);
                }
            }
            h = (int)(h/2.2);
        }
    }
}
