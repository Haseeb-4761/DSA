package Sorts.Application;

import Sorts.Insertion;
import edu.princeton.cs.algs4.StdOut;

public class PermutationCheck {

    public static boolean checkPermutation (Integer[] arr1, Integer[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] arr1 = {10,6,3,5,4,8,9,7,2,1};
        Integer[] arr2 = {3,6,9,1,4,2,5,8,7,10};

        Insertion.sort(arr1);
        Insertion.sort(arr2);

        StdOut.println(checkPermutation(arr1,arr2));
    }
}
