package cn.lee.leetcode.G15;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.TreeSet;

/**
    * @Title: Q1562
    * @Description: 
    * @author libo
    * @date 2020/8/28 17:09
    * @Version 1.0
    */
@Slf4j
public class Q1562 {
    public static void main(String[] args) {
        System.out.println(findLatestStep(new int[]{3,5,1,2,4},1));
        System.out.println(findLatestStep(new int[]{3,1,5,4,2},2));
        System.out.println(findLatestStep(new int[]{1},1));
    }


    public static int findLatestStep(int[] arr, int m) {
        TreeSet<Integer> set=new TreeSet<>();
        set.add(0);
        set.add(arr.length+1);
        if(arr.length==m) return arr.length;
        int n=arr.length;
        for (int i = n-1; i >=0; i--) {
            int index=arr[i];
            int a=set.lower(index);
            int b=set.higher(index);
            if(index-a-1==m||b-index-1==m){
                return i;
            }
            set.add(index);
        }
        return -1;

    }
    public static int findLatestStep2(int[] arr, int m) {
        int maxP = -1;
        int[] pos = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            pos[arr[i]-1]=1;
            if(i+1<m){
                continue;
            }else{
                maxP = isEqual(pos,m)?i+1:maxP;
            }
        }
        return maxP;
    }

    private static boolean isEqual(int[] pos, int m) {
        int start=0;
        for(int i=0;i<pos.length;i++){
            if(pos[i]==0){
                continue;
            }
            if(pos[i]==1&&i==0){
                start=0;
            }
            if(pos[i]==1&&i>0&&pos[i-1]==0){
                start=i;
            }
            if((pos[i]==1 && i==pos.length-1)||(pos[i]==1 && pos[i+1]==0)){
                if(i-start+1 == m){
                    return true;
                }
            }
        }
        return false;
    }
}
