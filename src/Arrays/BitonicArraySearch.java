package Arrays;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class BitonicArraySearch {
    private BitonicArraySearch() {

    }

    private int peak(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }

    private int reverseBinarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    private boolean contains(int[] nums, int target) {
        int peakValueIndex = peak(nums);
        if (target == nums[peakValueIndex]) return true;
        if (binarySearch(nums, 0, peakValueIndex, target) != -1) return true;
        if (reverseBinarySearch(nums, peakValueIndex + 1, nums.length - 1, target) != -1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        BitonicArraySearch bas = new BitonicArraySearch();
        int[] nums = { 1, 2, 3, 5, 7, 9, 8, 6 };
        StdOut.println(bas.contains(nums, 10));
    }
}
