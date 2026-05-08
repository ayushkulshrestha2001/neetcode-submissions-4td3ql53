class Solution {
    public int reverse(int x) {
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;
        int res = 0;
        while(x!=0) {
            int digit = x%10;
            x/=10;
            if(res > maxInt / 10 || (res==maxInt/10 && digit > maxInt%10)) {
                return 0;
            }
            if(res < minInt / 10 || (res==minInt/10 && digit < maxInt%10)) {
                return 0;
            }
            res = res*10 + digit;
        }
        return res;
    }
}
