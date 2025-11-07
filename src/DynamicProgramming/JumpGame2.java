package DynamicProgramming;

public class JumpGame2 {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGame2 j = new JumpGame2();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(j.jump(nums));
    }
}
