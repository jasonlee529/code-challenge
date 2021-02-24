package cn.lee.interview._2020;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @Title: Main
 * @Description:
 * @author: libo
 * @date: 2020/12/18 22:40
 * @Version: 1.0
 */
@Slf4j
public class Netease {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();
        Integer[] arr = new Integer[line];
        for (int i = 0; i < line; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        int cnt = 0;
        List<Integer> cnts = Arrays.asList(arr);
        while (cnts.size() > 0) {
            int start = cnts.get(0);
            boolean del = false;
            for (int i = cnts.size() - 1; i >= 0; i--) {
                if (cnts.get(i) % start == 0) {
                    del = true;
                    cnts.remove(i);
                }
            }
            if (del) {
                cnt++;
            }
        }


        System.out.println(cnt);
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, colors(new Integer[]{2, 3, 4, 9}));
    }

    public int colors(Integer[] arr) {
        Arrays.sort(arr);
        int cnt = 0;
        List<Integer> cnts = new ArrayList<>(Arrays.asList(arr));
        while (cnts.size() > 0) {
            int start = cnts.get(0);
            boolean del = false;
            for (int i = cnts.size() - 1; i >= 0; i--) {
                if (cnts.get(i) % start == 0) {
                    del = true;
                    cnts.remove(i);
                }
            }
            if (del) {
                cnt++;
            }
        }
        return cnt;
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, cars(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}));
        Assert.assertEquals(4, cars(new int[]{1, 1, 0, 0, 1, 1, 1, 1, 0, 1}));
        Assert.assertEquals(4, cars(new int[]{0, 1, 0, 0, 1, 1, 1, 1, 0, 1}));
    }

    public int cars(int[] cars) {
        int cnt = 0;
        int t = 0;
        for (int n : cars) {
//            int n=Integer.parseInt(m);
            if (n == 1 && t == 0) {
                t++;
                cnt++;
            } else if (n == 1 && t > 0) {
                t++;
            }
            t = t % 3;
            if (n == 0) {
                t = 0;
            }
        }

        System.out.println(cnt);
        return cnt;
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, block(new int[]{3, 6, 6, 3}));
        Assert.assertEquals(-1, block(new int[]{1, 4, 2, 3, 6}));
    }

    public static void main2(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] lines = line.split(" ");
        int [] blocks = new int[lines.length];
        for(int i=0;i<lines.length;i++){
            blocks[i]=Integer.parseInt(lines[i]);
        }
        int ans = new Netease().block(blocks);
        System.out.println(ans);
    }
    public int block(int[] blocks) {

        Arrays.sort(blocks);
        int sum = 0;
        for (int n : blocks) {
            sum += n;
        }
        int t1 = 0, t2 = 0;
        if (sum % blocks[blocks.length - 1] == 0) {
            //最长的一块独立一行
            int target = blocks[blocks.length - 1];
            List<ArrayList<Integer>> res = new ArrayList<>();
            Stack<Integer> path = new Stack();
            dfs(blocks, 0, blocks.length - 1, 2, target, path, res);
            t1=res.size()+1;
        } else if (sum % (blocks[blocks.length - 1] + blocks[0]) == 0) {
            //最长+最短 是一行
            int target = blocks[blocks.length - 1]+blocks[0];
            List<ArrayList<Integer>> res = new ArrayList<>();
            Stack<Integer> path = new Stack();
            dfs(blocks, 1, blocks.length - 1, 2, target, path, res);
            t2=res.size()+1;
        } else {
            return -1;
        }

        return Math.max(t1, t2) > 1 ? Math.max(t1, t2) : -1;
    }

    private void dfs(int[] blocks, int start, int end, int len, int target, Stack<Integer> path, List<ArrayList<Integer>> res) {

        if (sum(path) == target) {
            res.add(new ArrayList<Integer>(path));
        } else if (path.size() == len) {
            return;
        } else {
            for (int i = start; i < end; i++) {
                path.add(blocks[i]);
                dfs(blocks, i + 1, end, len, target, path, res);
                path.pop();
            }
        }
    }

    private int sum(Stack<Integer> path) {
        int sum = 0;
        for (Integer n : path) {
            sum += n;
        }
        return sum;
    }
}
