class Solution {
    int idx;

    public int calculate(String s) {
        idx = 0; 
        return calc(s, 0, 1); 
    }

    public int calc(String s, int ans, int sign) {
        int num = 0;

        while (idx < s.length()) {
            char ch = s.charAt(idx++);

            if (ch == ' ') {
                continue; // skip spaces
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // build full number
            }

            else if (ch == '+') {
                ans += sign * num;
                num = 0;
                sign = 1;
            }

            else if (ch == '-') {
                ans += sign * num;
                num = 0;
                sign = -1;
            }

            else if (ch == '(') {
                num = calc(s, 0, 1); // solve sub-expression recursively
            }

            else if (ch == ')') {
                ans += sign * num;
                return ans; // close sub-expression
            }
        }

        return ans + sign * num; // add last number
    }
}
