class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        
        if (digits == null || digits.length() == 0) {
            return res;
        }
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        
        helper(digits, 0, new StringBuilder(), res, map);    
        return res;        
    }

    private void helper(String digits, int i, StringBuilder current, List<String> res, Map<Character, String> map) {
        if (i == digits.length()) {
            res.add(current.toString());
            return;
        }
        
        String letters = map.get(digits.charAt(i));
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            helper(digits, i + 1, current, res, map);
            current.deleteCharAt(current.length() - 1); // backtrack
        }
    }    
}
