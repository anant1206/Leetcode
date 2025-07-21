class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }
    private void helper(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result){
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Skip duplicates at the same tree level
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > target) break; // Early pruning

            current.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, current, result); 
            current.remove(current.size() - 1);
        }    
    }
}