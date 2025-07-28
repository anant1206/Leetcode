class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        //Precompute factorials up to (n - 1)!
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // Build the k-th permutation using recursion
        StringBuilder result = new StringBuilder();
        findKthPermutation(nums, k - 1, fact, result);
        return result.toString();
    }

    private void findKthPermutation(List<Integer> nums, int k, int[] fact, StringBuilder result) {
        if (nums.isEmpty()) return;

        int n = nums.size();
        
        // Calculate index of the next number to pick
        // Each block of permutations with the same first digit has size of (n - 1)!
        int index = k / fact[n - 1];
        result.append(nums.get(index));
        nums.remove(index);

        // Update k to the position within the selected block
        k = k % fact[n - 1];
        findKthPermutation(nums, k, fact, result);
    }
}
