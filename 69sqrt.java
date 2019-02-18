class Solution {
    public int mySqrt(int x) {
        int l = 1, r = x, res = 0;
        
        while (l <= r) {
            int mid = (l+r)/2;
            if (x/mid > mid) {
                l = mid+1;
                res = mid;
            } else if (x/mid < mid) {
                r = mid-1;
            } else {
                return mid;
            }
        }
        return res;
    }
}
