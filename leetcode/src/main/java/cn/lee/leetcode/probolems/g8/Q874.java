package cn.lee.leetcode.probolems.g8;

import org.junit.Assert;

/**
 * @Title : Q874
 * @Description: :
 * @author: liboar@yonyou.com 81915
 * @date: 2023/7/19 19:06
 * @Version:1.0 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 * <p>
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 * <p>
 *  
 * 注意：
 * <p>
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 * 示例 2：
 * <p>
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/walking-robot-simulation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q874 {

    public static void main(String[] args) {
        Assert.assertEquals(25, robotSim(new int[]{4, -1, 3}, new int[][]{}));
        Assert.assertEquals(65, robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
        Assert.assertEquals(36, robotSim(new int[]{6,-1,-1,6}, new int[][]{}));

    }

    public static int robotSim(int[] commands, int[][] obstacles) {
        int res = 0;
        String dir = "+Y";
        int x =3*1000, y = 3*1000;
        int[][] all = new int[2 * x][2 * y];
        // 初始位置
        int[] pos = new int[]{x, y};
        for (int[] ob : obstacles) {
            // 障碍位置
            all[ob[0] + x][ob[1] + y] = 1;
        }
        for (int command : commands) {
            if (command < 0) {
                dir = forwardChange(dir, command);
            } else {
                int t = 0;
                boolean move = true;
                while (t < command && move) {
                    movePos(dir, pos);
                    move = canMove(dir, pos, all);
                    t++;
                }
                res = Math.max(res,(pos[0] - x) * (pos[0] - x) + (pos[1] - y) * (pos[1] - y));
            }
        }
        return res;
    }

    private static boolean canMove(String dir, int[] pos, int[][] all) {
        boolean canMove = true;
        switch (dir) {
            case "+Y":
                canMove = all[pos[0]][pos[1] + 1] != 1;
                break;
            case "+X":
                canMove = all[pos[0]+ 1][pos[1]] != 1;
                break;
            case "-Y":
                canMove = all[pos[0]][pos[1] - 1] != 1;
                break;
            case "-X":
                canMove = all[pos[0]- 1][pos[1]] != 1;
                break;
        }
        return canMove;
    }

    private static int[] movePos(String dir, int[] pos) {
        switch (dir) {
            case "+Y":
                pos[1] = pos[1] + 1;
                break;
            case "+X":
                pos[0] = pos[0] + 1;
                break;
            case "-Y":
                pos[1] = pos[1] - 1;
                break;
            case "-X":
                pos[0] = pos[0] - 1;
                break;
        }
        return pos;
    }

    /**
     * 改变方向
     *
     * @param dir
     * @param command
     * @return
     */
    private static String forwardChange(String dir, int command) {
        if (command == -1) {
            switch (dir) {
                case "+Y":
                    dir = "+X";
                    break;
                case "+X":
                    dir = "-Y";
                    break;
                case "-Y":
                    dir = "-X";
                    break;
                case "-X":
                    dir = "+Y";
                    break;
            }
        } else {
            switch (dir) {
                case "+Y":
                    dir = "-X";
                    break;
                case "-X":
                    dir = "-Y";
                    break;
                case "-Y":
                    dir = "+X";
                    break;
                case "+X":
                    dir = "+Y";
                    break;
            }
        }
        return dir;
    }
}