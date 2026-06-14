class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for(String str : strs) {
            int j = 0;
            while(j<Math.min(res.length(), str.length())) {
                if(res.charAt(j)!=str.charAt(j)) {
                    break;
                }
                j++;
            }
            res = res.substring(0, j);
        }
        return res;
    }
}