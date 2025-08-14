import java.util.*;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);  // Sort to help detect duplicates
        backtrack(nums, 0, ans);
        return ans;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> ans) {
        if (start == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) perm.add(num);
            ans.add(perm);
            return;
        }

        Set<Integer> seen = new HashSet<>();  // To skip duplicates at this recursion level

        for (int i = start; i < nums.length; i++) {
            if (seen.contains(nums[i])) continue;  // Skip duplicate values
            seen.add(nums[i]);

            swap(nums, start, i);
            backtrack(nums, start + 1, ans);
            swap(nums, start, i);  // backtrack
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
