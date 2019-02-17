class Solution {
    public double myPow(double x, int n) {
        double pow = subPow(x, n);

        return pow;
    }
    
    private double subPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double t = subPow(x, n/2);
        if (n%2 == 1 || n%2 == -1) {
            return t*t*(n > 0 ? x:1/x);
        } else {
            return t*t;
        }
    }
}
