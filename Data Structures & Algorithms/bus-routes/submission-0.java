public class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        int n = routes.length;
        Map<Integer, List<Integer>> stops = new HashMap<>();
        for (int bus = 0; bus < n; bus++) {
            for (int stop : routes[bus]) {
                stops.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
            }
        }

        Set<Integer> seenBus = new HashSet<>();
        Set<Integer> seenStop = new HashSet<>();
        seenStop.add(source);
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        int res = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int stop = q.poll();
                if (stop == target) return res;
                for (int bus : stops.getOrDefault(stop, new ArrayList<>())) {
                    if (seenBus.contains(bus)) continue;
                    seenBus.add(bus);
                    for (int nxtStop : routes[bus]) {
                        if (seenStop.contains(nxtStop)) continue;
                        seenStop.add(nxtStop);
                        q.add(nxtStop);
                    }
                }
            }
            res++;
        }
        return -1;
    }
}