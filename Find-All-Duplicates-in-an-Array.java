class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] a = new int[nums.length+1];
        List<Integer> list = new ArrayList<>();

        for(int i : nums){
            // count frequency of element
            a[i]++;
        }
        for(int i = 1;i<a.length;i++){
            if(a[i] > 1){
                list.add(i);
            }
        }
        return list;
    }
}