package Recursion;

import java.util.*;

public class count_digits {
    public static int count(int n,int c){
        if(n==0)return c;
        return count(n/10,c+1);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter a number whose digits is to be counted");
        int n=in.nextInt();
        System.out.println("Number of digits in "+n+" is "+count(n,0));
    }
}
