class TimeMap {

    private HashMap<String, List<Pair<Integer,String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Pair<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        List<Pair<Integer,String>> list = map.get(key);

        int l = 0, r = list.size()-1;
        String result = "";

        while(l<=r){
            int mid = l + (r-l)/2;

            if(list.get(mid).getKey() <= timestamp){
                result = list.get(mid).getValue();
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return result;
    }
}