package Arrays;

import java.util.Scanner;

class UniqueElements {
    public int removeDuplicates(int[] nums) {
        int k = 0, min = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == min) break;
                else if (nums[i] == nums[j]) nums[j] = min;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        UniqueElements sol = new UniqueElements();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an Array");
        for (int i = 0; i < nums.length; i++) nums[i] = sc.nextInt();
        System.out.println("Number of unique elements " + sol.removeDuplicates(nums));
        sc.close();
    }
}