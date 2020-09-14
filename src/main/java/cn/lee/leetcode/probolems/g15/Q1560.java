package cn.lee.leetcode.probolems.g15;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
    * @Title: Q1560
    * @Description: 
    * @author libo
    * @date 2020/8/27 17:26
    * @Version 1.0
    */
@Slf4j
public class Q1560 {
    public static void main(String[] args) {
        mostVisited(4,  new int[]{1,3,1,4});
    }
    public static List<Integer> mostVisited(int n, int[] rounds) {
        int [] arr = new int[n];
        arr[rounds[0]-1]=1;
        int max=1;
        for(int i=0;i<rounds.length-1;i++){
            if(rounds[i]<rounds[i+1]){
                for(int j=rounds[i];j<rounds[i+1];j++){
                    arr[j]=arr[j]+1;
                    max = max>arr[j]?max:arr[j];
                }
            }else{
                for(int j=rounds[i];j<rounds[i+1]+n;j++){
                    arr[j%n]=arr[j%n]+1;
                    max = max>arr[j%n]?max:arr[j%n];
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int a=0;a<arr.length;a++){
            if(arr[a]==max){
                res.add(a+1);
            }
        }
        return res;
    }
}
