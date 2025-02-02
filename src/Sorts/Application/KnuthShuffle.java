package Sorts.Application;

import java.util.Random;

/**
 * One way to implement the shuffle method is that you can generate a random number for each
 * element of array and then sort these random numbers which result into a uniformly random
 * shuffled array but the problem is that the sort takes O(nlog n) time. Here comes the Knuth's
 * method (O(n) time) which says while traversing through array generate a randomIndex either
 * between 0 and i(inclusive) or between i and n-1(inclusive) and swap ith value with
 * randomIndex value. Note that whether you start traversing from 0 or n-1, it doesn't matter.
 * Robert SedgeWick says that below implementation also produces uniform random shuffle.
 *  public static void shuffle(Object[] arr){
 *      int N = arr.length;
 *      for (int i = 0; i < N; i++){
 *          int r = StdRandom.uniform(i + 1);
 *          swap(arr, i, r);
 *      }
 *  }
 * **/

public class KnuthShuffle {
    public static void shuffle (Object[] array) {
        int n = array.length;
        Random random = new Random();
        for (int i = 0; i < n ; i++) {
            int randIndex = i + random.nextInt(n-i);   // random index between i and n-1;
            swap(array, i, randIndex);
        }
//        does these produce same result... yes.
//        for (int i = 0; i < n; i++) {
//            int randIndex = random.nextInt(i+1);   // random index between 0 and i;
//            swap(array, i, randIndex);
//        }
//
//        for (int i = n-1; i >= 0; i--) {
//            int randIndex = random.nextInt(i+1);   // random index between 0 and i;
//            swap(array, i, randIndex);
//        }
//
//        for (int i = n-1; i >= 0; i--) {
//            int randIndex = random.nextInt(i, n);   // random index between i and n-1;
//            swap(array, i, randIndex);
//        }
    }

    private static void swap (Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
