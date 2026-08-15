class Solution {
    int memo[][];
    private int dfs(String word1, String word2, int i, int j) {
        if(i==word1.length()) return word2.length()-j;
        if(j==word2.length()) return word1.length()-i;
        if(memo[i][j]!=-1) {
            return memo[i][j];
        }

        if(word1.charAt(i)==word2.charAt(j)) {
            return dfs(word1, word2, i+1, j+1);
        }

        int res = Math.min(dfs( word1, word2, i + 1, j),
                           dfs(word1, word2, i, j + 1));
        res = Math.min(res, dfs(word1, word2, i + 1, j + 1));
        return memo[i][j] = res + 1;
    }
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for(int i=0;i<word1.length();i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(word1, word2, 0, 0);
    }
}
