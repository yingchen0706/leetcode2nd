class Solution {
    public String multiply(String num1, String num2) {
        int[] sum = new int[num1.length() + num2.length()];
        for (int a: sum) {
            a = 0;
        }
        int index = 0;
        for (int i = num2.length() - 1; i>=0; i--)  {
            index = num2.length()-1 - i;
            int a = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j>=0;j--) {
                int b = num1.charAt(j) - '0';
                int s = a*b;
                sum[index]+=s;
                index++;
            }
        }
        for (int i = 0; i < sum.length-1; i++) {
            if (sum[i] >= 10) {
                sum[i+1] += sum[i]/10;
                sum[i] = sum[i]%10;
            }
        }
        StringBuffer sb = new StringBuffer("");
        boolean notStarted = true;
        for (int i = sum.length-1; i >=0; i--) {
            if (notStarted && sum[i] == 0) {
                continue;
            }
            sb.append((char)(sum[i] + '0'));
            notStarted=false;
        }
        if (notStarted) {
            sb = new StringBuffer("0");
        }
        return sb.toString();
    }
}
