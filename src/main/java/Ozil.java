import java.util.Scanner;

public class Ozil {
    private static String intro = "____________________________________________________________\n"
                + "Hello! I'm Ozil!\n"
                + "What can I do for you?\n"
                + "____________________________________________________________\n";

    private static String bye = "____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";

    private String[] list;
    private int index;

    public Ozil() {
        // initialize the list with a given size
        this.list = new String[100];
        this.index = 0;
    }

    private static String echo(String userinput) {
        return "____________________________________________________________\n"
                + userinput + "\n" +
                "____________________________________________________________\n";
    }

    private String addToList(String text) {
        this.list[this.index] = text;
        this.index++;
        return "____________________________________________________________\n"
                + "added:" + text + "\n"
                + "____________________________________________________________\n";
    }

    private String printlist() {
        String res = "____________________________________________________________\n";
        for (int i = 0; i < this.index; i++) {
            res += (i + 1) + ". " + this.list[i] + "\n";
        }
        res += "____________________________________________________________\n";
        return res;
    }

    public static void main(String[] args) {
        Ozil currentOzil = new Ozil();

        Scanner scanner = new Scanner(System.in);

        System.out.println(Ozil.intro);

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("bye")) {
                break;
            }

            if (input.equalsIgnoreCase("list")) {
                System.out.println(currentOzil.printlist());
                continue;
            }

            System.out.println(currentOzil.addToList(input));
        }

        System.out.println(Ozil.bye);
        scanner.close();


    }
}
