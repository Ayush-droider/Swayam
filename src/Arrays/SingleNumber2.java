package Arrays;

public class SingleNumber2 {
    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 2};
        System.out.println(singleNumber(arr));
    }
}

