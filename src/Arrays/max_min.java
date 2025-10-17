package Arrays;

import java.util.Scanner;

public class max_min {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Array size--->");
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(max<arr[i])max=arr[i];
        }
        for(int i=0;i<n;i++){
            if(min>arr[i])min=arr[i];
        }
        System.out.println("Minimum value "+min);
        System.out.println("Maximum value "+max);
    }
}
