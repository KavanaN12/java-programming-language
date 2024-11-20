import java.util.Scanner;

public class matrixmultiply {
    public static void main(String[] args) {
        int m, n, o, p;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        int arr1[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        o = sc.nextInt();
        p = sc.nextInt();
        if (o == n) {
            int arr2[][] = new int[n][p];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < p; j++) {
                    arr2[i][j] = sc.nextInt();
                }
            }
            int arr3[][] = new int[m][p];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    for (int k = 0; k < n; k++) {
                        arr3[i][j] += (arr1[i][k] * arr2[k][j]);
                    }
                }
            }
            System.out.println();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    System.out.print(arr3[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Error: the matrix cannot be multiplied");
        }
    }
}
