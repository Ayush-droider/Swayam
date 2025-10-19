package Recursion;

import java.util.Scanner;

public class SumofArray {
    static int arraySum(int arr[]) {
        return helper(arr,arr.length-1);
    }
    static int helper(int[] arr,int idx){
        if(idx==0){
            return arr[0];
        }
        return arr[idx]+helper(arr,idx-1);
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int [] arr=new int[5];
        System.out.println("Enter element:");
        for(int i=0;i<5;i++){
            arr[i]=in.nextInt();
        }
        System.out.println(arraySum(arr));
    }
}
