class Solution {
    private boolean isPalindrome(String str1) {
        StringBuilder str = new StringBuilder(str1);
        str.reverse();
        String rev = str.toString();
        return rev.equals(str1);
    }
    private void backtrack(String s, int i, List<List<String>> res, List<String> stack) {
        if(i>=s.length()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for(int j=i; j<s.length();j++) {
            if(isPalindrome(s.substring(i, j+1))) {
                stack.add(s.substring(i, j+1));
                backtrack(s, j+1, res, stack);
                stack.remove(stack.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(s, 0, res, new ArrayList<>());
        return res;
    }
}
