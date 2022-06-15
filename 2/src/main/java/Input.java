import java.util.Scanner;

public class Input {
    public int FirstMessage(){
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();
        in.close();
        return num;
    }

}
