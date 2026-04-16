class Solution {
    public boolean isPalindrome(String s) {
        String rev = "";
        String strim = "";
        for(int i=0;i<s.length();i++) {
            if(Character.isLetterOrDigit(s.charAt(i))) {
                strim = strim + s.charAt(i);
                rev = s.charAt(i) + rev;
            }
        }
        if(strim.equalsIgnoreCase(rev)) {
            return true;
        }
        return false;
    }
}
