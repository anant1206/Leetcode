class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>>  res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l=i+1,r=nums.length-1;
            int sum =0;
            
            while(l<r){
                sum = nums[i] + nums[l] + nums[r];

                if(sum==0){
                    res.add(Arrays.asList(nums[i] , nums[l] , nums[r]));
                    l++;
                    r--;
                    //As long as the value at l is the same as the previous one, keep moving forward.
                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
                else if(sum>0){
                    r--;
                }else if(sum < 0){
                    l++;
                }
            }
        }
        return res;
    }
}