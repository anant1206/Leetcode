class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        rec(s, new StringBuilder(),0, ans);
        return ans;
    }

    private static void rec(String s, StringBuilder sb, int i, List<String> ans) {
        if (i==s.length()) {
            ans.add(sb.toString());
            return;
        }

        char c = s.charAt(i);

        if (Character.isLetter(c)) {
            // Add lowercase version
            rec(s, sb.append(Character.toLowerCase(c)) ,i+1, ans);
            sb.deleteCharAt(sb.length()-1);
            // Add uppercase version
            rec(s, sb.append(Character.toUpperCase(c)),i+1, ans);
            sb.deleteCharAt(sb.length()-1);
        } else {
            // Just add digit (no change)
            rec(s, sb.append(c),i+1, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}