class Solution {

    private void dfs(int[] nums, List<List<Integer>> res, boolean[] pick, List<Integer> perm) {
        if(perm.size()==nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0;i<nums.length;i++) {
            if(!pick[i]) {
                perm.add(nums[i]);
                pick[i] = true;
                dfs(nums, res, pick, perm);
                perm.remove(perm.size()-1);
                pick[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, new boolean[nums.length], new ArrayList<>());
        return res;
    }
}
