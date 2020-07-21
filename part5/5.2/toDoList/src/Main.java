import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<String> toDoList;

    public static void printToDoList() {
        System.out.println(String.format("You have %d deals you must finish.", toDoList.size()));
        for (String deal : toDoList) System.out.println(deal);
    }

    public static void addDeal(String[] params) {
        String s = "";
        try {
            s = params[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR!!! You write no number and no deal");
            return;
        }

        Boolean withNumber = true;

        int number = 0;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            withNumber = false;
        }

        if (withNumber) {
            String deal;
            try {
                deal = params[2];
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("ERROR!!! You write no deal in command");
                return;
            }
            try {
                toDoList.add(number, deal);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("ERROR!!! You write wrong number");
                return;
            }
        } else {
            if (params.length == 3) s += " " + params[2];
            toDoList.add(s);
        }
    }

    public static void editDeal(String[] params) {
        String s = "";
        try {
            s = params[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR!!! You write no number and no deal");
            return;
        }

        int number = 0;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("ERROR!!! You write no position to edit");
            return;
        }

        String deal = "";
        try {
            deal = params[2];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR!!! You write no deal in command");
        }

        try {
            toDoList.set(number, deal);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR!!! You write wrong number");
            return;
        }
    }

    public static void deleteDeal(String[] params) {
        if (params.length > 2) {
            System.out.println("ERROR!!! DELETE command must have onle number");
            return;
        }

        String s = "";
        try {
            s = params[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ERROR!!! You write no number");
            return;
        }

        int number = 0;
        try {
            number = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("ERROR!!! You write no position to delete");
            return;
        }

        try {
            toDoList.remove(number);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ERROR!!! You write wrong number");
            return;
        }

    }

    public static void main(String[] args) throws IOException {
        toDoList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (;;) {
            System.out.println("/-----------------------------------------------------------------------------/");
            System.out.println("Please, type one of commands: ");
            System.out.println("LIST");
            System.out.println("ADD Какое-то дело");
            System.out.println("ADD 4 Какое-то дело на четвёртом месте");
            System.out.println("EDIT 3 Новое название дела");
            System.out.println("DELETE 7");
            System.out.println("EXIT");
            System.out.println("/-----------------------------------------------------------------------------/");
            String command = reader.readLine().trim();
            String[] commandComponents = command.split(" ", 3);
            if (commandComponents[0].equals("LIST")) printToDoList();
            else if (commandComponents[0].equals("ADD")) addDeal(commandComponents);
            else if (commandComponents[0].equals("EDIT")) editDeal(commandComponents);
            else if (commandComponents[0].equals("DELETE")) deleteDeal(commandComponents);
            else if (commandComponents[0].equals("EXIT")) break;
            else System.out.println("You write uknown command");

        }
    }



}
