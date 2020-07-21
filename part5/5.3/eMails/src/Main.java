import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {


    public static void main(String[] args) throws IOException {
        InputStreamReader streamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        System.out.println("Here you can work with e-mails");
        EMailSet eMailSet = new EMailSet();
        for (;;) {
            EMailSet.showCommands();
            String command = bufferedReader.readLine();
            if (command.equals("EXIT")) break;
            if (EMailSet.correctCommand(command)) eMailSet.makeCommand(command);
            else System.out.println("Wrong command");
        }
        bufferedReader.close();
        streamReader.close();

    }
}
