package cn.lee.hackerrank.algrithms.warmup.booking_com;

/**
 * Created by jason on 17-12-14.
 */
public class CustomerServiceCapacity {

    static int howManyAgentsToAdd(int noOfCurrentAgents, int[][] callsTimes) {
        int total = noOfCurrentAgents;
        int[] agents = new int[total];
        for (int[] ar : callsTimes) {
            boolean isMore = true;
            for (int i = 0; i < total; i++) {
                if (agents[i] < ar[0]) {
                    isMore = false;
                    agents[i] = ar[1];
                    break;
                }
            }
            if (isMore) {
                total += 1;
                agents = new int[total];
                agents[total - 1] = ar[1];
            }
        }
        return total - noOfCurrentAgents;

    }

    static int howManyAgentsToAdd2(int noOfCurrentAgents, int[][] callsTimes) {
        int moreAgents = 0;
        int count = noOfCurrentAgents - 1;
        int lastend = callsTimes[0][1];
        for (int i = 1; i < callsTimes.length; i++) {
            int[] ar = callsTimes[i];
            if (ar[0] - lastend > 0) {
                lastend = ar[1];
                count--;
            } else {
                count++;
            }
            if (count < 0) {
                moreAgents++;
            }
        }
        return moreAgents;
    }
}
