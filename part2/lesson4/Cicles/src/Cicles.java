import java.io.IOException;

public class Cicles {

    public static String printChoose() throws IOException {
        System.out.println("What do you want, please type for/while/quit");
        return SimpleReading.readString();
    }

    public static int choice (String text){
        if (text.toLowerCase().equals("for")) {
            return 1;
        } else if (text.toLowerCase().equals("while")) {
            return 2;
        } else if (text.toLowerCase().equals("quit")) {
            return 3;
        } else return 0;
    }

    public static void printFor(int start,int finish){
        for (int i=start;i<=finish;i++) {
            System.out.println("Ticket № "+i);
        }
    }

    public static void printWhile(int start,int finish){
        int i = start;
        while (i<=finish){
            System.out.println("Ticket № "+(i++));
        }
    }

    public static void main(String[] args) throws IOException {
        int choice = 0;
        while (choice!=3) {
            switch (choice) {
                case 1: printFor(200000,210000);
                        printFor(220000, 235000);
                        break;
                case 2: printWhile(200000,210000);
                        printWhile(220000, 235000);
                        break;
                case 0: System.out.println("Command is unknown, please, repeat it");
                        break;
                default:
            }
        choice = choice(printChoose());
        }
        System.out.println("gooBye");
    }

}
