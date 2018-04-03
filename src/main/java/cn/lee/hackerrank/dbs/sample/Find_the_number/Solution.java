package cn.lee.hackerrank.dbs.sample.Find_the_number;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * iptraf
 */
public class Solution {

    static String findNumber(int[] arr, int k) {
        String result = "NO";
        for(int i:arr){
            if(i==k){
                result = "YES";
            }
        }
        return result;
    }
    static int[] oddNumbers(int l, int r) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i=l;i<=r;i++){
            if(i%2==1){
                list.add(i);
            }
        }
        int [] result = new int[list.size()];
        int i=0;
        for(int m:list){
            result[i]=m;
            i++;
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        int _k;
        _k = Integer.parseInt(in.nextLine().trim());

        res = findNumber(_arr, _k);
        bw.write(res);
        bw.newLine();

        bw.close();
    }
}
