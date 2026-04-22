class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int m = 0;
        for(int i=0;i<piles.length;i++) {
            m = Math.max(m, piles[i]);
        }
        int l = 1;
        int res = m;
        while(l<=m) {
            int k = (l + m)/2;
            int totalTime = 0;
            for(int p:piles) {
                totalTime+=Math.ceil((double)p/k);
            }
            if(totalTime<=h) {
                res = k;
                m = k-1;
            } else {
                l = k+1;
            }
        }
        return res;
    }
}
