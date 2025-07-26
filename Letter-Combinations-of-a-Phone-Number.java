class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        helper(digits, 0, "", map, ans);
        return ans;  
    }

    private void helper(String digits, int index, String current, HashMap<Character, String> map, List<String> ans) {
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (char letter : letters.toCharArray()) {
            helper(digits, index + 1, current + letter, map, ans);
        }
    }
}
