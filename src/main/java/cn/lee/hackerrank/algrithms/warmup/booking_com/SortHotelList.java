package cn.lee.hackerrank.algrithms.warmup.booking_com;

import java.util.*;

/**
 * Created by jason on 17-12-14.
 */
public class SortHotelList {

    public static void main(String[] args) {
        int[] ar = sort_hotels("breakfast beach citycenter location metro view staff price", new int[]{1,
                2,
                1,
                1,
                2}, new String[]{"This hotel has a nice view of the citycenter. The location is perfect.\n",
                "The breakfast is ok. Regarding location, it is quite far from citycenter but price is cheap so it is worth.\n",
                "Location is excellent, 5 minutes from citycenter. There is also a metro station very close to the hotel.\n",
                "They said I couldn't take my dog and there were other guests with dogs! That is not fair.\n",
                "Very friendly staff and good cost-benefit ratio. Location is a bit far from citycenter."});
        for (int a : ar) {
            System.out.println(a);
        }
    }

    static int[] sort_hotels(String keywords, int[] hotel_ids, String[] reviews) {
        Map<Integer, Integer> datas = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < hotel_ids.length; i++) {
            int hotelId = hotel_ids[i];
            String review = reviews[i];
            if (!datas.containsKey(hotelId)) {
                datas.put(hotelId, 0);
            }
            int count = datas.get(hotelId);
            String[] words = keywords.split(" ");
            for (String w : words) {
                while (review.contains(w)) {
                    count++;
                    review = review.replace(w, "");
                }
            }
            datas.put(hotelId, count);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(datas.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o2.getValue() - o1.getValue() == 0) {
                    return o2.getKey() - o1.getKey();
                }
                return o2.getValue() - o1.getValue();
            }
        });
        int[] r = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            r[i] = list.get(i).getKey();
        }
        return r;
    }
}
