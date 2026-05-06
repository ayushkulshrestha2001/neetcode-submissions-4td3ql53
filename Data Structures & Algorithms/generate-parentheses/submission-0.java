class Solution {
    private void backtrack(int n, StringBuilder stack, List<String> res, int openN, int closedN) {
        if(openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }
        if(openN < n) {
            stack.append('(');
            backtrack(n, stack, res, openN+1, closedN);
            stack.deleteCharAt(stack.length()-1);
        }
        if(closedN<openN) {
            stack.append(')');
            backtrack(n, stack, res, openN, closedN+1);
            stack.deleteCharAt(stack.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        StringBuilder stack = new StringBuilder();
        List<String> res = new ArrayList<>();
        backtrack(n, stack, res, 0, 0);
        return res;
    }
}
