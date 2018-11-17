class Solution {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows==1) {
            return s;
        }
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < numRows; i++) {
             
            for (int j = 0; (j*2*numRows - (j*2-1)-1) - i < s.length(); j++) {
                int m = j*2;
                int k = m*numRows - (m -1) -1;
                
                if (i == 0 || j == 0) {
                    res.append(s.charAt(k+i));
                } else if (i == numRows - 1 && k+numRows - 1 < s.length()) {
                    res.append(s.charAt(k+numRows-1));
                } else if (i > 0 && i < numRows - 1) {
                    res.append(s.charAt(k-i));
                    if (k+i <s.length()) {
                        res.append(s.charAt(k+i));
                    }
                }
            }
        }
        return res.toString();
    }
}
