class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> ans = new HashSet<>();
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);  // Important for pruning duplicates
        boolean[] used = new boolean[arr.length];
        backtrack(arr, new StringBuilder(), used, ans);
        return ans.size();
    }

    private void backtrack(char[] tiles, StringBuilder path, boolean[] used, Set<String> ans) {
        for (int i = 0; i < tiles.length; i++) {
            if (used[i]) continue;

            // Skip duplicate characters
            if (i > 0 && tiles[i] == tiles[i - 1] && !used[i - 1]) continue;

            path.append(tiles[i]);
            ans.add(path.toString());

            used[i] = true;
            backtrack(tiles, path, used, ans);
            
            used[i] = false;
            path.deleteCharAt(path.length() - 1);
        }
    }
}
