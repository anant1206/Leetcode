class Solution {
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            //int correct = nums[i]-1;
            if (nums[i]>0 && nums[i]<=nums.length && nums[i] != nums[nums[i]-1]) {
                swap(nums, i, nums[i]-1);
            } else i++;
        }
        for (int j = 0; j < nums.length; j++) {
            //checking which element is not at its correct position that would be missing element
            if (nums[j] != j+1) {
                return j+1;
            }
        }
        return nums.length+1;
    }

    static void swap(int[] arr, int first, int second) {
        //swap
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}