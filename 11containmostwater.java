class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {
            int left = height[i];
            for (int j = i+1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[j],left)*(j-i));
            }
        }
        return max;
    }
}
