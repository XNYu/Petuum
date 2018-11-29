package Petuum;

public class FIndUnDpulicate {
    public static int find(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if ((mid - start) % 2 == 0) {
                    start = mid + 2;
                }
                else
                    end = mid - 1;
            } else if (mid > 1 && nums[mid] == nums[mid - 1]) {
                if ((mid - start - 1) % 2 == 0) {
                    start = mid + 1;
                }
                else
                    end = mid - 2;
            }
            else
                return nums[mid];
        }
        int mid = start + (end - start) / 2;
        if (mid < 0 || mid > nums.length - 1) {
            return -1;
        }
        return nums[mid];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4,4,6,6,8,8};
        System.out.println(find(nums));
    }

}
