import java.util.Scanner;

public class insertionsort {
    public static void insertion(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

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

        
        System.out.println("Array after sorting");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
