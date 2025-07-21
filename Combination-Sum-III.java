class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(k, n, 1, new ArrayList<>(), list);
        return list;
    }
    private void helper(int k, int target, int start, List<Integer> current, List<List<Integer>> result){
        if (target == 0 && current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= 9; i++) {

            if (i > target) break; // Early pruning
            //pick
            current.add(i);
            helper(k, target - i, i + 1, current, result); 

            // Backtrack
            current.remove(current.size() - 1);
        }    
    }
}