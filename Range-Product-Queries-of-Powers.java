class Solution {
    public int[] productQueries(int n, int[][] queries) {
        // Extract powers of 2 from the binary representation of n
        ArrayList<Integer> powers = new ArrayList<>();
        int bit = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                powers.add((int)Math.pow(2, bit));
            }
            bit++;
            n >>= 1;
        }

        int[] result = new int[queries.length];
        int MOD = 1_000_000_007;

        for (int i = 0; i < queries.length; i++) {
            int temp = 1;
            int left = queries[i][0];
            int right = queries[i][1];

            for (int k = left; k <= right; k++) {
                temp = (int)(((long)temp * powers.get(k)) % MOD);
            }

            result[i] = temp;
        }

        return result;
    }
}
