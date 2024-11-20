import java.util.Scanner;

public class selectionsort {
    public static void main(String[] args) {
        System.out.println("Enter the number of elements in the array");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter  the  elements");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            int min = i, t;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            t = arr[min];
            arr[min] = arr[i];
            arr[i] = t;
        }
        System.out.println("Array after sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

}
