package Sorts;

public class DutchFlagSort {
    public static <T extends Comparable<T>> void sort (T[] array, T low, T high) {
        int l = 0,m=0, h = array.length-1;
        while(m <= h) {
            if (array[m].equals(low)){
                swap(array, l , m);
                l++;
                m++;
            }
            else if (array[m].equals(high)){
                swap(array, m , h);
                h--;
            }
            else m++;
        }
    }

    private static <T extends Comparable<T>> void swap (T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
