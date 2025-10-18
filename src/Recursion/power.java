package Recursion;

import java.util.Scanner;

public class power {
    public static int pow(int a,int b){
        if(b==0)return 1;
        return a*pow(a,b-1);
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the number and power to be calculated:");
        int a=in.nextInt();
        int b=in.nextInt();
        System.out.println(a+" to the power "+b+" equals to "+pow(a,b));
    }
}
