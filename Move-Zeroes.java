class Solution {
    public void moveZeroes(int[] nums) {
        int l=0;
        int n=nums.length-1;

        for(int r =0; r<=n; r++){
            if(nums[r]!=0){
                swap(nums,l,r);
                l++;
            }
        }
    }
    void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}