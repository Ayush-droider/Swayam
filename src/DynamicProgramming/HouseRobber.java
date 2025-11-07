package DynamicProgramming;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int prev2 = 0, prev1 = 0;
        for (int num : nums) {
            int cur = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
    public static void main(String[] args) {
        HouseRobber h = new HouseRobber();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(h.rob(nums));
    }
}

