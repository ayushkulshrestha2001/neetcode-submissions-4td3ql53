class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++) {
            int j = i+1;
            for(j=i+1;j<temperatures.length;j++) {
                if(temperatures[i]<temperatures[j]) {
                    res[i] = j-i;
                    break;
                }
            }
            if(j==temperatures.length) {
                res[i] = 0;
            }
        }
        return res;
    }
}
