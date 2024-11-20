import java.util.Scanner;

public class mini_project {
    public static void main(String[] args) {
        var con = System.console();
        Scanner sc = new Scanner(con.reader());
        int My_Number;
        My_Number = (int) (Math.random() * 100);
        int user_number;
        System.out.println("NOTE: if you want to get out of the game, entre a number <=0");
        System.out.println("guess My Number,from 1 to 100 : ");
        do {
            user_number = sc.nextInt();

            if (My_Number == user_number) {
                System.out.println("WOOHOO.... YOU FOUND THE CORRECT ONE");
                break;
            } else if (user_number < My_Number) {
                System.out.println("your number is too small...");
            } else if (user_number > My_Number) {
                System.out.println("your number is too big...");
            } else {
                System.out.println("please input the numbers from 1 to 100");
            }
        } while (user_number >= 0);
        System.out.print("The correct answer is : ");
        System.out.println(My_Number);
    }
}
