import java.util.Scanner;

public class Ozil {
    private static String intro = "____________________________________________________________\n"
                + "Hello! I'm Ozil!\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";

    private static String bye = "____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";

    private static String echo(String userinput) {
        return "____________________________________________________________\n"
                + userinput + "\n" +
                "____________________________________________________________\n";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(intro);

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                break;
            }

            System.out.println(echo(input));
        }

        System.out.println(bye);
        scanner.close();


    }
}
