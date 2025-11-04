package Arrays;

import java.util.*;

public class SetZeroes {
    public void setZeroes(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean fr = false, fc = false;

        for (int i = 0; i < m; i++)
            if (mat[i][0] == 0) fc = true;
        for (int j = 0; j < n; j++)
            if (mat[0][j] == 0) fr = true;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (mat[i][j] == 0)
                    mat[i][0] = mat[0][j] = 0;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (mat[i][0] == 0 || mat[0][j] == 0)
                    mat[i][j] = 0;

        if (fr) Arrays.fill(mat[0], 0);
        if (fc) for (int i = 0; i < m; i++) mat[i][0] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SetZeroes obj = new SetZeroes();
        System.out.print("Enter rows and cols: ");
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] mat = new int[m][n];
        System.out.println("Enter matrix elements:");
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = sc.nextInt();
        obj.setZeroes(mat);
        System.out.println("Matrix after setting zeros:");
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }
}
