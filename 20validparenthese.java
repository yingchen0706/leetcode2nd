class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] charArr = s.toCharArray();
        for (char c: charArr) {
            if (c=='{' || c=='[' || c=='(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c=='}' && top != '{') ||
                   (c==']' && top != '[') ||
                   (c==')' && top != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
