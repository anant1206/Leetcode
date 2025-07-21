class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), list);
        return list;
    }
    private void helper(int[] candidates, int target, int i, List<Integer> current, List<List<Integer>> result){
        if(candidates.length == i){
            if(target==0){
                result.add(new ArrayList<>(current));
            }
            return;
        }

        if(candidates[i]<=target) {
            current.add(candidates[i]);
            helper(candidates, target-candidates[i], i , current, result);
            current.remove(current.size() - 1);
        }
        helper(candidates, target, i + 1, current, result);       
    }
}