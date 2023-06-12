package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Q51
 * @Description: https://leetcode-cn.com/problems/n-queens/
 * @author: libo
 * @date: 2020/9/3 14:56
 * @Version: 1.0
 */
@Slf4j
public class Q51 {
    public static void main(String[] args) {
        Q51 q = new Q51();
        q.solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        if (n < 3) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>(n);
        int[][] arr = new int[n][n];
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==0 && a[i]==0 && b[j]==0){
                    arr[i][j]=1;
                    a[i]=1;
                    b[j]=1;
                    System.out.print(arr[i][j]+",");
                    break;
                }
                System.out.print(arr[i][j]+",");
            }
            System.out.println();
        }
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                System.out.print(arr[i][j]+",");
//            }
//            System.out.println();
//        }
        return new ArrayList<>();
    }
    public void sovle(int[][] arr,int n,boolean isSuccess){

    }
}
