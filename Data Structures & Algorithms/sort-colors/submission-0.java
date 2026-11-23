class Solution {
    private void swap(int[] nums, int low, int high) {
        
            int temp = nums[low];
            nums[low] = nums[high];
            nums[high] = temp;
            
    }
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // swap(nums[mid], nums[low]);
                swap(nums, mid, low);
                low++;
                mid++;
            } else if (nums[mid] == 2) {
                // swap(nums[mid], nums[high]);
                swap(nums, mid, high);
                high--;
            } else {
                mid++;
            }
        }
    }
}