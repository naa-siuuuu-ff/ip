import java.util.Scanner;
//change String returning functions to void, and just runt he function
public class Ozil {
    private static String intro = "____________________________________________________________\n"
                + "Hello! I'm Ozil!\n"
                + "How may I assist you?\n"
                + "____________________________________________________________\n";

    private static String bye = "____________________________________________________________\n"
                + "Bye. Hope to see you again soon!\n"
                + "____________________________________________________________\n";

    private Task[] list;
    private int index;

    public Ozil() {
        // initialize the list with a given size
        this.list = new Task[100];
        this.index = 0;
    }

    private static String echo(String userinput) {
        return "____________________________________________________________\n"
                + userinput + "\n" +
                "____________________________________________________________\n";
    }

    private String addToList(String userinput) {
        this.list[this.index] = new Task(userinput);
        this.index++;
        return "____________________________________________________________\n"
                + "Task added:" + userinput + "\n"
                + "____________________________________________________________\n";
    }

    private void markTask(int tasknum) {
        this.list[tasknum - 1].markAsDone();
        String res = "____________________________________________________________\n"
                + "Ok! I have marked this task as completed:\n"
                + this.list[tasknum - 1].toString() + "\n"
                + "____________________________________________________________\n";
        System.out.println(res);

    }

    private void unmarkTask(int tasknum) {
        this.list[tasknum - 1].markAsUndone();
        String res = "____________________________________________________________\n"
                + "Alright! I have marked this task as not being accomplished yet:\n"
                + this.list[tasknum - 1].toString() + "\n"
                + "____________________________________________________________\n";
        System.out.println(res);
    }

    private String printlist() {
        String res = "____________________________________________________________\n"
                + "Here are the tasks in your list:\n";
        for (int i = 0; i < this.index; i++) {
            res += (i + 1) + ". " + this.list[i].toString() + "\n";
        }
        res += "____________________________________________________________\n";
        return res;
    }




    public static void main(String[] args) {
        Ozil currentOzil = new Ozil();
        Scanner scanner = new Scanner(System.in);

        System.out.println(Ozil.intro);

        while (true) {
            String input = scanner.nextLine().trim();
            String[] sections = input.split("\\s+", 2);

            // mark/unmark handling
            if (sections[0].equalsIgnoreCase("mark")) {
                if (sections.length > 1) {
                    currentOzil.markTask(Integer.parseInt(sections[1]));
                } else {
                    System.out.println("Please provide a task number to mark.");
                }
                continue;
            }

            if (sections[0].equalsIgnoreCase("unmark")) {
                if (sections.length > 1) {
                    currentOzil.unmarkTask(Integer.parseInt(sections[1]));
                } else {
                    System.out.println("Please provide a task number to unmark.");
                }
                continue;
            }

            // bye
            if (sections[0].equalsIgnoreCase("bye")) {
                break;
            }

            // list
            if (sections[0].equalsIgnoreCase("list")) {
                System.out.println(currentOzil.printlist());
                continue;
            }

            // otherwise: treat input as new task
            System.out.println(currentOzil.addToList(input));
        }

        System.out.println(Ozil.bye);
        scanner.close();
    }

}
