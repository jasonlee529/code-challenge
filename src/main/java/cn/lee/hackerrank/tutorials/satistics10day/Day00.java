package cn.lee.hackerrank.tutorials.satistics10day;

import java.util.*;

/**
 * Created by jason on 17-12-20.
 */
public class Day00 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] ar = new int[n];
//        for (int i = 0; i < n; i++) {
//            ar[i] = sc.nextInt();
//        }
        int[] ar = new int[]{64630, 11735, 14216, 99233, 14470, 4978, 73429, 38120, 51135, 67060};
        System.out.println(String.format("%2.1f",mean(ar)));
        System.out.println(median(ar));
        System.out.println(mode(ar));
    }

    private static int mode(int[] ar) {
        Map<Integer, Integer> data = new HashMap<Integer, Integer>();
        for (int i : ar) {
            if (!data.containsKey(i)) {
                data.put(i, 0);
            }
            data.put(i, data.get(i) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(data.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return o1.getKey() - o2.getKey();
                }
                return 0;
            }
        });
        return list.get(0).getKey();
    }

    private static double median(int[] ar) {
        double l = ar.length - 1;
        Arrays.sort(ar);
        int a1 = (int) Math.floor(l / 2);
        int a2 = (int) Math.ceil(l / 2);
        return (double) (ar[a1] + ar[a2]) / 2;
    }

    private static double mean(int[] ar) {
        double sum = 0L;
        for (int i : ar) {
            sum = sum + i;
        }
        return sum / ar.length;
    }
}
