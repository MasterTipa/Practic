import java.util.Scanner;

public class Input {
    public int IntScan(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            if (scan.hasNextInt()) {
                int i = scan.nextInt();
                return i;
            } else {
                scan.next();
                System.out.println("input number!!!");
                String s = scan.nextLine();
            }
        }

    }
    public String StrScan(){
        Scanner scan = new Scanner(System.in);
        while (true) {
                String i = scan.nextLine();
                return i;
        }
    }
}
