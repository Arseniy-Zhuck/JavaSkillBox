import java.util.TreeSet;

public class EMailSet {
    private TreeSet<EMail> eMails;

    public EMailSet() {
        eMails = new TreeSet<>();
    }

    public static boolean correctCommand(String command) {
        boolean result = false;
        String[] parts = command.trim().split(" ");
        result |= (parts.length == 1)&&(parts[0].equals("LIST"));
        result |= (parts.length == 2)&&(EMail.isEMail(parts[1]))&&(parts[0].equals("ADD"));
        return result;
    }

    public static void showCommands() {
        System.out.println("/---------------------------------------------------------------------------------/");
        System.out.println("Write one of commands");
        System.out.println("LIST");
        System.out.println("ADD hello@skillbox.ru");
        System.out.println("/---------------------------------------------------------------------------------/");
    }

    public void makeCommand(String command) {
        String[] parts = command.trim().split(" ");
        if (parts.length == 1) {
            printEMails();
        } else  {
            addEMail(parts[1]);
        }
    }

    private void printEMails() {
        System.out.println(String.format("Here we have %d email" + (eMails.size() == 1 ? "" : "s"), eMails.size()));
        for (EMail eMail : eMails) System.out.println(eMail);
    }

    private void addEMail(String emailAddress) {
        if (EMail.isEMail(emailAddress)) eMails.add(new EMail(emailAddress));
        else System.out.println("Email address is not correct");
    }

}
