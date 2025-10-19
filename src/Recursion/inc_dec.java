package Recursion;

import java.util.Scanner;

public class inc_dec {
    public static void print(int n){
        if(n==5)return;
        System.out.print(n+" ");
        print(n-1);
        System.out.print(n+" ");
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the no. of terms to be printed");
        int n=in.nextInt();
        print(n);
    }
}
