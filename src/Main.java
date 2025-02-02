import Sorts.Insertion;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1,5,9,6,8,7};
        Insertion.sort(arr);
        StdOut.println(Arrays.toString(arr));
    }
}