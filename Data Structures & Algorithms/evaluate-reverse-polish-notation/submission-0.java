class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+") || t.equals("-") || t.equals("*") || t.equals("/")) {
                int num1 = nums.pop();
                int num2 = nums.pop();
                int res = 0;
                switch (t) {
                    case "+": res = num2 + num1; break;
                    case "-": res = num2 - num1; break;
                    case "*": res = num2 * num1; break;
                    case "/": res = num2 / num1; break; // truncates toward zero in Java
                }
                nums.push(res);
            } else {
                nums.push(Integer.parseInt(t));
            }
        }
        return nums.pop();
    }
}