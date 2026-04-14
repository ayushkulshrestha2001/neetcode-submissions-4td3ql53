class Solution {
    public boolean isAnagram(String s, String t) {
        // HashMap<Character, Integer> map = new HashMap<>();
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            int number = c - 'a';
            freq[number] = freq[number] + 1;
        }
        for(int i=0;i<t.length();i++) {
            char c = t.charAt(i);
            int number = c - 'a';
            freq[number] = freq[number] - 1;
        }
        for(int i=0;i<freq.length;i++) {
            if(freq[i]!=0) {
                return false;
            }
        }
        return true;
        // for(int i=0;i<s.length();i++) {
        //     Character c = s.charAt(i);
        //     map.put(c, map.getOrDefault(c, 0)+1);
        // }

    }
}
