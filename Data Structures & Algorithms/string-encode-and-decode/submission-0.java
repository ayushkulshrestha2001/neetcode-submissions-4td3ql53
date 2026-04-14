class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(String str : strs) {
            int len = str.length();
            res = res + len + '#' + str;
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i=0;
        int lastIndex = 0;
        while(i<str.length()) {
            while(str.charAt(i)!='#') {
                i++;
            }
            String lenStr = str.substring(lastIndex, i);
            int len = Integer.parseInt(lenStr);
            i++;
            String strRes = str.substring(i, i+len);
            i = i + len;
            lastIndex = i;
            res.add(strRes);
        }
        return res;
    }
}
