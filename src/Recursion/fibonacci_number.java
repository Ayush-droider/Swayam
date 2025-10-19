package Recursion;

import java.util.Scanner;

public class fibonacci_number {
    public static int fibo(int n){
        if(n==0 || n==1)return 1;
        return fibo(n-1)+fibo(n-2);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the term:");
        int n=in.nextInt();
        System.out.println("Fibonacci number at "+n+" is "+fibo(n));
    }
}
