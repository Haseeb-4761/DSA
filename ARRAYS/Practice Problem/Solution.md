# Java Code Solutions

## 1. Duplicate Check

### Approach 1: Brute Force (O(n^2))

```java
public boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
    }
    return false;
}
```

### Approach 2: Using HashSet (O(n))

```java
import java.util.HashSet;

public boolean containsDuplicate(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i])) {
            return true;
        } else {
            set.add(nums[i]);
        }
    }
    return false;
}
```

## 2. Search in Rotated Sorted Array

### Approach: Binary Search

```java
public class Solution {
    public int search(int[] nums, int target) {
        int min = minSearch(nums);
        if (nums[min] <= target && target <= nums[nums.length - 1]) {
            return search(nums, min, nums.length - 1, target);
        } else {
            return search(nums, 0, min, target);
        }
    }

    public int search(int[] nums, int left, int right, int target) {
        int l = left;
        int r = right;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int minSearch(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid;
            } else if (nums[left] <= nums[mid] && nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Index of target " + target + ": " + solution.search(nums, target));
    }
}
```

## 3. Best Time to Buy and Sell Stock

### Approach: One Pass (O(n))

```java
public int maxProfit(int[] prices) {
    int buy = prices[0];
    int profit = 0;
    for (int i = 1; i < prices.length; i++) {
        if (buy < prices[i]) {
            profit = Math.max(prices[i] - buy, profit);
        } else {
            buy = prices[i];
        }
    }
    return profit;
}
```

## 4. Trapping Rain Water

### Approach: Two Pointers (O(n))

```java
public int trap(int[] height) {
    int n = height.length;
    int res = 0, l = 0, r = n - 1;
    int rMax = height[r], lMax = height[l];
    while (l < r) {
        if (lMax < rMax) {
            l++;
            lMax = Math.max(lMax, height[l]);
            res += lMax - height[l];
        } else {
            r--;
            rMax = Math.max(rMax, height[r]);
            res += rMax - height[r];
        }
    }
    return res;
}
```

## 5. Three Sum

### Approach: Brute Force with HashSet (Avoiding Duplicates)

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        Collections.sort(triplet);
                        result.add(triplet);
                    }
                }
            }
        }
        result = new ArrayList<>(new LinkedHashSet<>(result));
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println("Triplets that sum to zero: " + solution.threeSum(nums));
    }
}
```

This Markdown file provides an overview of the solutions to various common algorithmic problems. Each section contains the code along with comments where necessary for clarity.
