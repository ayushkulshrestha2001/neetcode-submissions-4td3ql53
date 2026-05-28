class Solution {
    HashMap<String, Boolean> mp = new HashMap<>();
    private boolean dfs(String s1, String s2, String s3, int i, int j, int k) {
        if(k==s3.length()) {
            return (s1.length()==i) && (s2.length()==j);
        }
        String key = i + " " + j;
        if(mp.containsKey(key)) {
            return mp.get(key);
        }
        Boolean res = false;
        if(i<s1.length() && s1.charAt(i)==s3.charAt(k)) {
            res = dfs(s1, s2, s3, i+1, j, k+1);
        }
        if(j<s2.length() && s2.charAt(j)==s3.charAt(k)) {
            res = dfs(s1, s2, s3, i, j+1, k+1);
        }
        mp.put(key, res);
        return res;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        return dfs(s1, s2, s3, 0, 0, 0);
    }
}
