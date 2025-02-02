import Sorts.Application.KnuthShuffle;
import Sorts.Insertion;
import Sorts.Selection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.io.File;

class FileSorter{
    public static void main(String[] args) {
        String filePath = "D:\\DSA\\src\\Stacks_and_Queues";
        File directory = new File(filePath);
        File[] filesArr = directory.listFiles();
        KnuthShuffle.shuffle(filesArr);
        Insertion.sort(filesArr);
        for (File file : filesArr) {
            StdOut.println(file.getName() + " ");
        }
    }
}