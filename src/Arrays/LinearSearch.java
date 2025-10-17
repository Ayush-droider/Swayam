package Arrays;

import java.util.Scanner;

public class LinearSearch {
    public static int search(int arr[], int x) {
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Array size--->");
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        System.out.println("Enter value to be searched");
        int x=in.nextInt();
        int ans=search(arr,x);
        if(ans==-1){
            System.out.println("Element not found");
        }
        System.out.println("Element found at "+ans);
    }
}
