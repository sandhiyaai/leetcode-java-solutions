// Brute Force Approach
// Time Complexity: O(N^2)
// Space Complexity: O(1)

class SolutionBasic {
    public int longestOnes(int[] nums, int k) {
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            int z = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) z++;

                if (z <= k) {
                    max = Math.max(max, j - i + 1);
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
// Sliding Window (Better Version)
// Time Complexity: O(N)
// Space Complexity: O(1)

class SolutionBetter {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, z = 0, max = 0;

        while (r < nums.length) {
            if (nums[r] == 0) z++;

            while (z > k) {
                if (nums[l] == 0) z--;
                l++;
            }

            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
// Sliding Window (Optimal Clean Version)
// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0, r = 0, z = 0, max = 0;

        while (r < nums.length) {
            if (nums[r] == 0) z++;

            if (z > k) {
                if (nums[l] == 0) z--;
                l++;
            }

            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}
