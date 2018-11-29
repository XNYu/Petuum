package Petuum;

public class FirstNumber {
    public int find(int[] nums, int target) {
        if(nums.length==0||nums[nums.length-1]<=target)
            return -1;
        int start = 0, end = nums.length - 1;
        int ans = end;
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] > target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        FirstNumber f = new FirstNumber();
        System.out.println(f.find(nums,5));
    }
}
