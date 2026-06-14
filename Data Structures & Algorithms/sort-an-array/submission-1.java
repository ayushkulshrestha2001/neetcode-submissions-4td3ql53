class Solution {
    private void merge(int[] nums, int l, int mid, int r) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = l;
        int j = mid +1;
        while(i<=mid && j<=r) {
            if(nums[i]<=nums[j]) {
                temp.add(nums[i]);
                i++;
            } else {
                temp.add(nums[j]);
                j++;
            }
        }
        while (i <= mid) {
            temp.add(nums[i]);
            i++;
        }

        while (j <= r) {
            temp.add(nums[j]);
            j++;
        }
        for (i = l; i <= r; i++) {
            nums[i] = temp.get(i - l);
        }
    }

    private void mergeSort(int[] nums, int l, int r) {
        if(l>=r) return;
        int mid = (l+r)/2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid+1, r);
        merge(nums, l, mid, r);
    }

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}