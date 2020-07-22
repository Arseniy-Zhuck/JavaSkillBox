import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class Main {

    private Map<String, String> phoneBook;

    public Main() {
        phoneBook = new TreeMap<>();
    }

    public void printPhoneBook() {
        Iterator <Map.Entry<String, String>> iterator = phoneBook.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> node = iterator.next();
            System.out.println(node.getKey() + " has phonenumber " + node.getValue());
        }
    }

    public static boolean isFIO(String s) {
        return Pattern.compile("[А-ЯЁ&&[^ЪЬЫ]][а-яё]+\\s[А-ЯЁ&&[^ЪЬЫ]][а-яё]+\\s" +
                "[А-ЯЁ&&[^ЪЬЫ]][а-яё]+$").matcher(s).matches();
    }

    public static String formatPhone(String phone) {
        return phone.replaceAll("[^0-9]","");
    }

    public static Boolean isPhone(String phone) {
        return Pattern.compile("[0-9]{11}").matcher(phone).matches();
    }

    public Map.Entry<String, String> getNodeByPhone(String phone) {
        //Map.Entry<String, String> result = null;
        Map.Entry<String, String> pair = null;
        Iterator<Map.Entry<String, String>> iterator = phoneBook.entrySet().iterator();
        boolean res = false;
        while ((!res)&&(iterator.hasNext())) {
            pair = iterator.next();
            res = res | pair.getValue().equals(phone);
        }
        return pair;
    }

    public void programCicle() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please, type FIO or phone or command");
            String command = bufferedReader.readLine();
            if (command.equals("LIST")) {
                printPhoneBook();
                break;
            }
            if (isFIO(command)) {
                if (phoneBook.containsKey(command)) {
                    System.out.println(command + " has phonenumber " + phoneBook.get(command));
                    continue;
                } else {
                    System.out.println("New node:" + command);
                    System.out.println("Print phonenumber, please");
                    String s = bufferedReader.readLine();
                    String phonenumber = formatPhone(s);
                    phoneBook.put(command, phonenumber);
                    continue;
                }
            } else if (isPhone(formatPhone(command))) {
                String phone = formatPhone(command);
                if (phoneBook.containsValue(phone)) {
                    System.out.println(getNodeByPhone(phone).getKey() + " has phonenumber " + phone);
                    continue;
                } else {
                    System.out.println("New node: command");
                    boolean flag = false;
                    String FIO = "";
                    do {
                        System.out.println("Print correct FIO, please");
                        FIO = bufferedReader.readLine().trim();
                        flag = isFIO(FIO);
                    } while (!flag);
                    phoneBook.put(FIO,phone);
                    continue;
                }
            } else {
                System.out.println("Cannot recognize FIO, phone or command");
                continue;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        //Map<String,String> phoneBook = new TreeMap<>();
        System.out.println("Here we have intelligent phonebook");
        Main mainProg = new Main();
        mainProg.programCicle();
    }
}
