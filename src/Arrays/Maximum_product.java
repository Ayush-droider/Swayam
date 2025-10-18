package Arrays;

import java.util.Scanner;

public class Maximum_product {
    public static int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE;
        int pre=1,suf=1;
        for(int i=0;i<nums.length;i++){
            if(pre==0)pre=1;
            if(suf==0)suf=1;
            pre*=nums[i];
            suf*=nums[nums.length-i-1];
            max=Math.max(max,Math.max(pre,suf));
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Array size--->");
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int ans=maxProduct(arr);
        System.out.println("Maximum Product in the array is "+ans);
    }
}
