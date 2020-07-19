import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // вопрос, а как в Java можно тип или метод передавать в качестве параметра?
    public static BufferedReader bufferedReader;


    public static void main(String[] args) throws IOException {
        System.out.println("А за ним комарики на воздушном шарике");
        System.out.println("A за ними КОТ, ЗАДОМ НАПЕРЕД");
        System.out.println("Ехали медведи, на велосипеде");

        System.out.println("С чем хотите работать?");
        System.out.println("0. Целые числа");
        System.out.println("1. Дробные числа");
        System.out.println("2. Символы");
        System.out.println("3. Строки");
        System.out.println("4. Коты");
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(bufferedReader.readLine());
        System.out.println("How many elements do you want?");
        int n = Integer.parseInt(bufferedReader.readLine());
        Object[] array = null;
        switch (choice) {
            case 0: array = new Integer[n];
                    fillArrayWithIntegers(array);
                    break;
            case 1: array = new Double[n];
                    fillArrayWithDoubles(array);
                    break;
            case 2: array = new Character[n];
                    fillArrayWithCharacters(array);
                    break;
            case 3: array = new String[n];
                    fillArrayWithStrings(array);
                    break;
            case 4:
                System.out.println("ШУтка!!! КОтов Больше не Будет, ураааааа");
                break;
            default:
                System.out.println("Неправильная команда");
                System.out.println("Программа завершена");
                System.exit(0);
        }
        printArray(array);
        arrayReverse(array);
        printArray(array);

    }

    public static void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Элемент № " + i + ": " + array[i]);
        }
    }

    public static void arrayReverse(Object[] array) {
        for (int i = 0; i < (array.length / 2); i++) {
            Object t = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = t;
        }
    }

    public static void fillArrayWithIntegers(Object[] ar) throws IOException {
        for (int i = 0; i < ar.length; i++) {
            System.out.println(String.format("Введите число № %d:", i));
            ar[i] = Integer.parseInt(bufferedReader.readLine());
        }
    }

    public static void fillArrayWithDoubles(Object[] ar) throws IOException {
        for (int i = 0; i < ar.length; i++) {
            System.out.println(String.format("Введите число № %d:", i));
            ar[i] = Double.parseDouble(bufferedReader.readLine());
        }
    }

    public static void fillArrayWithCharacters(Object[] ar) throws IOException {
        System.out.println(String.format("Введите строку из символов длины %d", ar.length));
        String s = bufferedReader.readLine();
        while (s.length() != ar.length) {
            System.out.println("Строка неверной длины, попробуйте снова");
            System.out.println(String.format("Введите строку из символов длины %d", ar.length));
            s = bufferedReader.readLine();
        }
        char[] ar1 = s.toCharArray();
        for(int i = 0; i < ar1.length; i++) ar[i] = ar1[i];
        // вопрос, а нельзя как то поиграться типами и сделать это одной командой?
    }

    public static void fillArrayWithStrings(Object[] ar) throws IOException {
        for (int i = 0; i < ar.length; i++) {
            System.out.println(String.format("Введите строку № %d:", i));
            ar[i] = bufferedReader.readLine();
        }
    }

}
