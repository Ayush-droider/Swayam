package Recursion;

public class RatInMaze {
    static int n;
    static int[][] sol;

    static boolean solveMaze(int[][] maze, int x, int y) {
        if (x == n - 1 && y == n - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }
        if (x >= 0 && y >= 0 && x < n && y < n && maze[x][y] == 1) {
            if (sol[x][y] == 1) return false;
            sol[x][y] = 1;
            if (solveMaze(maze, x + 1, y)) return true;
            if (solveMaze(maze, x, y + 1)) return true;
            sol[x][y] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}};
        n = maze.length;
        sol = new int[n][n];
        if (solveMaze(maze, 0, 0)) {
            for (int[] row : sol) {
                for (int x : row) System.out.print(x + " ");
                System.out.println();
            }
        } else System.out.println("No Path Found");
    }
}

