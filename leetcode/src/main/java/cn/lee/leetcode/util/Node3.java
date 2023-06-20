package cn.lee.leetcode.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Node3
 * @Description:
 * @author: libo
 * @date: 2021/9/24 9:55
 * @Version: 1.0
 */
@Slf4j
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Node3 {
	public int val;
	public Node3 prev;
	public Node3 next;
	public Node3 child;


}
