class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++) {
            int[] freq = new int[26];
            String s = strs[i];
            for(int j=0;j<s.length();j++) {
                char c = s.charAt(j);
                freq[c-'a'] = freq[c-'a']+1;
            }
            String key = Arrays.toString(freq);
            if(map.containsKey(key)) {
                List<String> ls = map.get(key);
                ls.add(s);
                map.put(key, ls);
            } else {
                List<String> ls = new ArrayList<>();
                ls.add(s);
                map.put(key, ls);
            }
        }
        return new ArrayList<>(map.values());
    }
}
