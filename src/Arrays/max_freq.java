package Arrays;

import java.util.*;

public class max_freq {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Array size--->");
        int n=in.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
            if(map.containsKey(arr[i]) && map.get(arr[i])>max){
                max=map.get(arr[i]);
            }
        }
        List<Integer> list=new ArrayList<>(map.values());
        int count=0;
        for(int num:list){
            if(num==max){
                count+=num;
            }
        }
        System.out.println(count);
    }
}
