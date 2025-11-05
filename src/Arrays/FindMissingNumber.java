package Arrays;

public class FindMissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i <= n; i++) xor ^= i;
        for (int num : nums) xor ^= num;
        return xor;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        System.out.println(missingNumber(arr));
    }
}

