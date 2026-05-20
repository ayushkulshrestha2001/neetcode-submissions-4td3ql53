class Solution {
    private boolean isPalindrome(String str) {
        StringBuilder str1 = new StringBuilder(str);
        str1.reverse();
        return str1.toString().equals(str);
    }
    public String longestPalindrome(String s) {
        int max = 0;
        String res = "";
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                if(isPalindrome(s.substring(i, j+1)) && s.substring(i, j+1).length()>max) {
                    res = s.substring(i, j+1);
                    max = res.length();
                }
            }
        }
        return res;
    }
}
