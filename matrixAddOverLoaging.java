import java.util.ArrayList;
import java.util.Scanner;

class matrixLoading {
    static void matrixAdd(ArrayList<Integer> num) {
        System.out.println("Entered 2*2 Matrix addition");
        int k = 0;
        int arr[][] = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = num.get(k) + num.get(k + 4);
                k++;
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void matrixAdd(int arr[][], int arr1[][], int size) {
        System.out.println("Entered 3*3 matrix addition");
        int sum[][] = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum[i][j] = arr[i][j] + arr1[i][j];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static void matrixAdd(int arr[][], int arr1[][]) {
        System.out.println("Entered the arr addition");
        int sum[][] = new int[arr.length][arr[0].length];
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                sum[i][j] = arr[i][j] + arr1[i][j];
            }
        }
        for (int i = 0; i < sum.length; i++) {
            for (int j = 0; j < sum[0].length; j++) {
                System.out.print(sum[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

public class matrixAddOverLoaging {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of Matrix 1 m:n");
        int m = sc.nextInt(), n = sc.nextInt();
        int arr[][] = new int[m][n];
        System.out.println("Enter the first array");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the size of Matrix 2 m:n");
        int m1 = sc.nextInt(), n1 = sc.nextInt();
        int arr1[][] = new int[m1][n1];
        System.out.println("Enter the second array");
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                arr1[i][j] = sc.nextInt();
            }
        }
        ArrayList<Integer> num = new ArrayList<>();
        if (m == m1 && n == n1) {
            if (m == 2 && n == 2) {
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        num.add(arr[i][j]);
                    }
                }
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        num.add(arr1[i][j]);
                    }
                }
                matrixLoading.matrixAdd(num);
            } else if (m == 3 && n == 3) {
                matrixLoading.matrixAdd(arr, arr1, 3);
            } else {
                matrixLoading.matrixAdd(arr, arr1);
            }
        } else {
            System.out.println("Addition not possible");
        }

    }
}