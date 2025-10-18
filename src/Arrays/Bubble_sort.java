package Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Bubble_sort {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Array size--->");
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println("Sorted Array "+ Arrays.toString(arr));
    }
}
