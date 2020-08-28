package cn.lee.leetcode;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author libo
 * @Title: https://leetcode-cn.com/problems/add-two-numbers/solution/
 * @Description:
 * @date 2020/8/28 13:40
 * @Version 1.0
 */
@Slf4j
public class Q2 {
    public static void main(String[] args) {
        System.out.println(new BigInteger("1000000000000000000000000000001").toString());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger s1 = sum(l1);
        BigInteger s2 = sum(l2);
        BigInteger s3 = s1.add(s2);
        //    System.out.println(s1);
        //     System.out.println(s2);
        //     System.out.println(s3);
        List<Integer> arr = new ArrayList();
        if (s3.toString().equalsIgnoreCase("0")) {
            arr.add(0);
        }
        while (!s3.toString().equalsIgnoreCase("0")) {
            arr.add(s3.mod(BigInteger.valueOf(10)).intValue());
            s3 = s3.divide(BigInteger.valueOf(10));
        }
        ListNode star = new ListNode(arr.get(0));
        ListNode pre = star;
        for (int i = 1; i <= arr.size() - 1; i++) {
            pre.next = new ListNode(arr.get(i));
            pre = pre.next;
        }
        return star;
    }

    private BigInteger sum(ListNode in) {
        BigInteger big = BigInteger.valueOf(0);
        StringBuilder sb = new StringBuilder();
        while (in != null) {
            sb.append(in.val);
            in = in.next;
        }

        big=new BigInteger( sb.reverse().toString());
        return big;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
