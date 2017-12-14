package cn.lee.hackerrank.algrithms.warmup.booking_com;

/**
 * Created by jason on 17-12-14.
 */
public class DeltaEncoding {
    static int[] delta_encode(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i] - array[i - 1];
        }
        int[] re = new int[array.length * 2];
        re[0] = array[0];
        int j = 1;
        int token = -128;
        for (int i = 1; i < array.length; i++) {
            if (Math.abs(array[i]) >= 127) {
                re[j] = token;
                j++;
            }
            re[j] = array[i];
            j++;
        }
        for(int i:array){
            System.out.println(i);
        }
        array = new int[j];
        System.arraycopy(re, 0, array, 0, j);
        return array;
    }

    public static void main(String[] args) {
        int [] ar = delta_encode(new int[]{25626,25757,24367,24267,16,100,2,7277,128,0});
        for(int i:ar){
            System.out.println(i);
        }
    }
}
