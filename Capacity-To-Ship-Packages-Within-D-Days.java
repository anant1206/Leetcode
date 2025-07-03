class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long start = 0,end=0;
        long total=0;

        for (long w : weights) {
            start = Math.max(start, w);
            end = end+w;
        }

        while (start <= end) {
            long mid = start + (end - start) / 2;

            long sum = 0;
            int d = 1;

            for (long w : weights) {
                if (sum+w > mid) {
                    sum = w;
                    d++;
                } else {
                    sum = sum + w;
                }

            }

            if (d > days) {
                // more days , increase weight so days become less
                start = mid + 1;

            } else {
                // less days , decrease weight
                end = mid - 1;
            }
        }
        return (int)start;
    }
}