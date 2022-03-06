package cn.lee.newcoder.hw.y2022;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Title: Q1
 * @Description:
 * @author: libo
 * @date: 2022/3/6 0006 23:02
 * @Version: 1.0
 */
@Slf4j
public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] data = new int[n][3];
        for(int i=0;i<n;i++){
            data[i][0]=sc.nextInt();
            data[i][2]=i+1;
        }
        for(int i=0;i<n;i++){
            data[i][1]=sc.nextInt();
        }
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        for(int[] t:data){
            System.out.print(t[2]+" ");
        }
    }
}