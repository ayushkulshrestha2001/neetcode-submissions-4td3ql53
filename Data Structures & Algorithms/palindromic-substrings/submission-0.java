class Solution {
    private boolean isPalindrome(String str) {
        StringBuilder str1 = new StringBuilder(str);
        str1.reverse();
        return str1.toString().equals(str);
    }
    
    public int countSubstrings(String s) {
        int res = 0;
        for(int i=0;i<s.length();i++) {
            for(int j=i;j<s.length();j++) {
                if(isPalindrome(s.substring(i, j+1))) {
                    res++;
                }
            }
        }
        return res;
    }
}
