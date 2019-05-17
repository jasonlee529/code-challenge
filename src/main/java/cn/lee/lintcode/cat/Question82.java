package cn.lee.lintcode.cat;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question82 {

    public int singleNumber(int[] A) {
        int[] B = new int[A.length];
        Map<Integer,Integer> map = new HashMap<>();
        int t = A[0];
        for (int i : A) {
           if(map.get(i) == null){
               map.put(i,1);
           }else{
               map.put(i,map.get(i)+1);
           }
        }
        for(Integer i : map.keySet()){
            if(map.get(i) ==1){
                t = i;
            }
        }
        System.out.println(t);
        return t;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Question82 question8 = new Question82();
        question8.singleNumber(new int[]{1, 1, 2, 2, 3, 4, 4});
        question8.singleNumber(new int[]{-1});
    }
}
