class Solution {
    Map<Character, String> mp = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private void backtrack(String digits, int i, String stack, List<String> res) {
        if(stack.length()==digits.length()) {
            res.add(stack);
            return;
        }
        String s = mp.get(digits.charAt(i));
        for(char c : s.toCharArray()) {
            backtrack(digits, i+1, stack+c, res);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        backtrack(digits, 0, "", res);
        return res;
    }
}
