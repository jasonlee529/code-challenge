package cn.lee.leetcode.probolems.g8;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @author libo
 * @Title: Q841
 * @Description:
 * @date 2020/8/31 15:38
 * @Version 1.0
 */
@Slf4j
public class Q841 {
    public static void main(String[] args) {
        Q841 q = new Q841();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(Integer.valueOf(1)));
        rooms.add(Arrays.asList(Integer.valueOf(2)));
        rooms.add(Arrays.asList(Integer.valueOf(3)));
        rooms.add(new ArrayList<>());
        System.out.println(q.canVisitAllRooms(rooms));
        rooms = new ArrayList<>();
        rooms.add(Arrays.asList(Integer.valueOf(1), 3));
        rooms.add(Arrays.asList(Integer.valueOf(2), 0, 1));
        rooms.add(Arrays.asList(Integer.valueOf(2)));
        rooms.add(Arrays.asList(Integer.valueOf(0)));
        System.out.println(q.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, Integer> opend = new HashMap<>();
        Map<Integer, Integer> locked = new HashMap<>();
        LinkedList<Integer> queue=new LinkedList<>();
        queue.add(0);

        for (int i = 0; i < rooms.size(); i++) {
            locked.put(i, 0);
        }
        while (queue.size() != 0) {
                Integer r = queue.poll();
                locked.remove(r);

                opend.put(r, 1);
                List<Integer> newKeys = rooms.get(r);
                for (Integer k : newKeys) {
                    if (!opend.containsKey(k)) {

                        queue.add(k);
                    }
                }
        }
        return locked.size() == 0;
    }

}
