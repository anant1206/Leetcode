class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>  res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i=0;i<n-2;i++){     
            // skipping because all 4 are distinct     
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // skip duplicates
            
            for(int j=i+1;j<n-2;j++){
                if (j > i+1 && nums[j] == nums[j - 1]) continue; // skip duplicates

                int l=j+1,r=nums.length-1;
                while(l<r){
                    long sum = (long) nums[i] + nums[l] + nums[r] + nums[j]  ;

                    if(sum==target){
                        res.add(Arrays.asList(nums[i] , nums[j], nums[l] , nums[r]));
                        l++;
                        r--;
                        //As long as the value at l is the same as the previous one, keep moving forward.
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (l < r && nums[r] == nums[r + 1]) r--;

                    }
                    else if(sum > target){
                        r--;
                    }else if(sum < target){
                        l++;
                    }
                }
            }
        }
        return res;
    }
}