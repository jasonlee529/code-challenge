package cn.lee.leetcode.probolems.g0;

import cn.lee.leetcode.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Q83
 * @Description: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * @author: libo
 * @date: 2020/9/8 18:07
 * @Version: 1.0
 */
@Slf4j
public class Q83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head==null?null : head.next;
        ListNode pre = head;
        while (cur != null) {
            if(cur.val==pre.val){
                pre.next=cur.next;
                cur=cur.next;
            }else{
                pre=cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
