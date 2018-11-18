class Solution {
    public int reverse(int x) {
        boolean mark = false;
        long t = x;
        if (t<0) {
            t = t*-1;
            mark=true;
        }
        StringBuilder s = new StringBuilder();
        long divider = 10;
        while (t/divider > 0) {
            s.append(t%divider/(divider/10));
            t = t - (int)(t%divider);
            divider*=10;
        }
        s.append(t/(divider/10));
        long res = Long.valueOf(s.toString());
        if (res >= 2147483647 || res < -2147483648) {
            return 0;
        }
        if (mark) {
            res = res*-1;
        }
        return (int)res;
    }
}
