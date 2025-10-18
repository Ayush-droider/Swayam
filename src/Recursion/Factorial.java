package Recursion;

import java.util.*;

public class Factorial {
    public static long fact(long n){
        if(n==0 || n==1)return 1;
        return n*fact(n-1);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number whose factorial is to be calculated:");
        long n=in.nextLong();
        System.out.println("The factorial of "+n+" is "+fact(n));
    }
}
