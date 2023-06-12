package org.example.leetcode.probolems.g0;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Title: Q79
 * @Description: https://leetcode-cn.com/problems/word-search/
 * @author: libo
 * @date: 2020/9/13 12:02
 * @Version: 1.0
 */
@Slf4j
public class Q79 {

    public static void main(String[] args) {
        System.out.println(new Q79().exist(new char[][]{
                new char[]{'C', 'A', 'A'},
                new char[]{'A', 'A', 'A'},
                new char[]{'B', 'C', 'D'}
        }, "AAB"));
        System.out.println(new Q79().exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCCED"));
        System.out.println(new Q79().exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCB"));
    }

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int[][] arr = new int[rows][cols];
        Deque<Integer[]> path = new ArrayDeque<>();
                List<List<Integer[]>> rest = new ArrayList<>();
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (board[i][j] == word.charAt(0)) {
                            path.add(new Integer[]{i, j});
                            arr[i][j] = 1;
                            dfs(board, word, path, arr, 1, rest);
                            arr[i][j] = 0;
                            path.removeLast();
                        }
            }
        }
        return rest.size() > 0;
    }

    private void dfs(char[][] board, String word, Deque<Integer[]> path, int[][] arr, int i, List<List<Integer[]>> rest) {
        if (i >= word.length()) {
            rest.add(new ArrayList<>(path));
            return;
        }
        Integer[] pos = path.peekLast();
        char dest = word.charAt(i);
        //up
        if (pos[0] > 0 && arr[pos[0] - 1][pos[1]] == 0 && board[pos[0] - 1][pos[1]] == dest) {
            path.add(new Integer[]{pos[0] - 1, pos[1]});
            arr[pos[0] - 1][pos[1]] = 1;
            dfs(board, word, path, arr, i + 1, rest);
            arr[pos[0] - 1][pos[1]] = 0;
            path.removeLast();
        }
        //down
        if (pos[0] < board.length - 1 && arr[pos[0] + 1][pos[1]] == 0 && board[pos[0] + 1][pos[1]] == dest) {
            path.add(new Integer[]{pos[0] + 1, pos[1]});
            arr[pos[0] + 1][pos[1]] = 1;
            dfs(board, word, path, arr, i + 1, rest);
            arr[pos[0] + 1][pos[1]] = 0;
            path.removeLast();
        }
        //left
        if (pos[1] > 0 && arr[pos[0]][pos[1] - 1] == 0 && board[pos[0]][pos[1] - 1] == dest) {
            path.add(new Integer[]{pos[0], pos[1] - 1});
            arr[pos[0]][pos[1] - 1] = 1;
            dfs(board, word, path, arr, i + 1, rest);
            arr[pos[0]][pos[1] - 1] = 0;
            path.removeLast();
        }
        //right
        if (pos[1] < board[0].length - 1 && arr[pos[0]][pos[1] + 1] == 0 && board[pos[0]][pos[1] + 1] == dest) {
            path.add(new Integer[]{pos[0], pos[1] + 1});
            arr[pos[0]][pos[1] + 1] = 1;
            dfs(board, word, path, arr, i + 1, rest);
            arr[pos[0]][pos[1] + 1] = 0;
            path.removeLast();
        }
    }
}
