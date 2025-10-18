package Arrays;

import java.util.Scanner;

public class kadanes {
    public static int maxSum(int[] arr){
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum>max){
                max=sum;
            }
            if(sum<0)sum=0;
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
        int ans=maxSum(arr);
        System.out.println("Maximum Sum in Array "+ans);
    }
}
