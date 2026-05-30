class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> res = new HashSet<>();
        for(int[] t: triplets) {
            if(t[0]>target[0] || t[1]>target[1] || t[2]>target[2]) {
                continue;
            }
            for(int i=0;i<t.length;i++) {
                if(t[i]==target[i]) {
                    res.add(i);
                }
            }
        }
        return res.size()==3;
    }
}
