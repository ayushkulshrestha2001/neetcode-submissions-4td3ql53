class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder str = new StringBuilder();
        while(columnNumber !=0) {
            columnNumber--;
            int mod = columnNumber % 26;
            str.append((char) ('A' + mod));
            columnNumber /= 26;
        }
        return str.reverse().toString();
    }
}