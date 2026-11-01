class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int height=0;
        int width=0;
        int area=0;
        int maxheight=0;
        while(left <  right) {
            width=right-left;
            height=Math.min(heights[left],heights[right]);
            area=width*height;
             maxheight=Math.max(maxheight,area);
            

            if(heights[left] < heights[right]) {
                left++;
            }else {
                right--;
            }
        }
        return maxheight;
    }
}
