class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l = 0, maxf = 0;
        int res = 0;
        for(int r=0;r<s.length();r++) {
            mp.put(s.charAt(r), mp.getOrDefault(s.charAt(r), 0) + 1);
            maxf = Math.max(maxf, mp.get(s.charAt(r)));
            while((r-l+1)- maxf > k) {
                mp.put(s.charAt(l), mp.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(r-l+1, res);
        }
        return res;
    }
}
