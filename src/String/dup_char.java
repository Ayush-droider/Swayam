package String;

import java.util.Scanner;

public class dup_char {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str = in.nextLine();
        int[] ch=new int[256];
        StringBuilder st=new StringBuilder();
        for(char c:str.toCharArray()){
            if(ch[c]==0){
                st.append(c);
                ch[c]++;
            }
        }
        System.out.println("After duplicates removed: "+st.toString());
    }
}
