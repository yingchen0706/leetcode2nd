class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        
        int divider = 10;
        int t = x/divider;
        while (t>=10) {
            divider *= 10;
            t = x/divider;
        }
        
        t = x;
        while (t >= 10 || divider>0) {
            int a = t/divider;
            int b = t%10;
            if (a != b) {
                return false;
            }
            t = t - a*divider;
            t = t/10;
            divider = divider/100;
            if (t==0) {
                return true;
            }
        }
        return true;
    }
}
