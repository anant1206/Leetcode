class Solution {
    public int countHomogenous(String s) {
       int sum =0;
       int l=0,r=0;
       //Integer Overflow
       final int MOD = 1_000_000_007;
       while(r<s.length()){
        
        if(s.charAt(l) != s.charAt(r)){
            l=r;
        }
        sum = (sum + (r-l+1)) % MOD;
        r++;
       }
       return sum; 
    }
}