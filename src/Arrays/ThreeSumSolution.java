package Arrays;/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

public class ThreeSumSolution {
    private ThreeSumSolution() {
    }

    private void sort(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int swap = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = swap;
                }
            }
        }
    }

    private int threeSum(int[] nums) {
        int count = 0;
        sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == 0) {
                    StdOut.println(nums[i] + " " + nums[left] + " " + nums[right]);
                    count++;
                    do {
                        left++;
                    } while (nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (nums[right] == nums[right + 1]);
                }
                else if (total > 0) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ThreeSumSolution sol = new ThreeSumSolution();
        int[] nums = { -3, -5, -9, 0, 3, 6, 4, 2, 5, 4, 6, 5, 4, 1 };
        StdOut.println(sol.threeSum(nums));
    }
}
