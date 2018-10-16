class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int cnt = (n % 2 == 0) ? 2 : 1;
        int i = 0; 
        int j = 0;
        int mid = (n + 1)/2 - 1;
        double sum = 0;
        
        for (int k = 0; k <= mid + cnt -1; k++) {
            int elem = 0;
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    elem = nums1[i++];
                } else {
                    elem = nums2[j++];
                }
            } else if (i < nums1.length) {
                elem = nums1[i++];
            } else if (j < nums2.length) {
                elem = nums2[j++];
            }
            if (k>=mid) {
                sum += elem;
            }
        }
        return (double)sum/cnt;
    }
}
