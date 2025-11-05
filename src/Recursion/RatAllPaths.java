package Recursion;

import java.util.*;

public class RatAllPaths {
    static int n;
    static List<String> ans = new ArrayList<>();
    static int[][] dir = {{1,0},{0,-1},{0,1},{-1,0}};
    static String moves = "DLRU";

    static void solve(int[][] m, int x, int y, String path, boolean[][] vis) {
        if (x == n - 1 && y == n - 1) {
            ans.add(path);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && m[nx][ny] == 1 && !vis[nx][ny]) {
                vis[nx][ny] = true;
                solve(m, nx, ny, path + moves.charAt(i), vis);
                vis[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},{1,1,0,1},{1,1,0,0},{0,1,1,1}};
        n = maze.length;
        boolean[][] vis = new boolean[n][n];
        if (maze[0][0] == 1) {
            vis[0][0] = true;
            solve(maze, 0, 0, "", vis);
        }
        System.out.println(ans);
    }
}

