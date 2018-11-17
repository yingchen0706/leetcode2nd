class Solution {
    public String convert(String s, int numRows) {
        int rowN = Math.max(numRows, s.length());
        
        List<StringBuilder> list = new ArrayList<>();
        
        for (int i = 0; i < rowN; i++) {
            list.add(new StringBuilder());
        }
        
        int row = 0;
        int down = -1;
        for (char c: s.toCharArray()) {
            list.get(row).append(c);
            if (row == 0 || row == numRows - 1) {
                down = -down;
            }
            row += down*1;
        }
        
        StringBuilder res = new StringBuilder("");
        for (StringBuilder c: list) {
            res.append(c);
        }
        return res.toString();
    }
}
