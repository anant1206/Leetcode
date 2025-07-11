class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        // prefix sum
        int[]count=new int[nums.length+1];
        count[0]=1;
        
        int ans=0, odd=0;
        
        for(int n : nums) {
            // bitwise odd check
            odd = odd + (n&1);

            if(odd-k>=0) {
                ans+=count[odd-k];
            }
            count[odd]++;
        }
        return ans;
    }

}