class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0;i<t.length();i++) {
            mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)+1);
        }
        String res = "";
        Integer resLen = Integer.MAX_VALUE;

        for(int i=0;i<s.length();i++) {
            if(mp.containsKey(s.charAt(i))) {
                HashMap<Character, Integer> mpc = new HashMap<>(mp);
                int j = i;
                while(j<s.length() && !mpc.isEmpty()) {
                    if(mpc.containsKey(s.charAt(j))) {
                        mpc.put(s.charAt(j), mpc.get(s.charAt(j))-1);
                        if(mpc.get(s.charAt(j))==0) {
                            mpc.remove(s.charAt(j));
                        }
                    }
                    j++;
                }
                if(mpc.isEmpty() && j-i < resLen) {
                    res = s.substring(i, j);
                    resLen = j-i;
                }
            }
        }
        return res;
    }
}
