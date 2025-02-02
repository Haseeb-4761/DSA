package Sorts.Application;

import Sorts.Insertion;
import edu.princeton.cs.algs4.StdOut;

public class Point implements Comparable<Point> {
    private int x;
    private int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    private static int common(Point[] arr1, Point[] arr2){
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int low = 0, high = arr2.length-1;
            while (low <= high) {
                int mid = low + (high-low)/2, x1 = arr1[i].x, x2 = arr2[mid].x;
                if (x1 == x2){
                    int y1 = arr1[i].y, y2 = arr2[mid].y;
                    if (y1 == y2){
                        count++;
                        break;
                    }
                    else if (y1 < y2) high = mid-1;
                    else low = mid + 1;
                }
                else if (x1 < x2) high = mid-1;
                else low = mid + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Point[] arr1 = {new Point(3, 4),new Point(7, 8),
                new Point(5, 9),new Point(6, 4),new Point(6, 6)};

        Point[] arr2 = {new Point(7, 8),new Point(7, 14),
                new Point(6, 6),new Point(7, 2), new Point(6,4)};

        if (arr1.length <= arr2.length) {
            Insertion.sort(arr2);
            StdOut.println("Total Common points: " + common(arr1,arr2));
        }
        else {
            Insertion.sort(arr1);
            StdOut.println("Total Common points: " + common(arr2,arr1));
        }
    }

    @Override
    public int compareTo(Point that) {
        if (this.x < that.x) return -1;
        if (this.x > that.x) return 1;
        if (this.y < that.y) return -1;
        if (this.y > that.y) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "( " + this.x + ", "  + this.y + " )";
    }
}
