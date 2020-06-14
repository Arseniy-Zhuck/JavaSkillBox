import java.io.IOException;
import java.util.Scanner;

public class ageVasyaMashaMisha {

    public static int max3(int a,int b,int c) {
        if ((a>=b)&&(a>=c)) {
            return a;
        } else return b>=c ? b : c;
    }

    public static int min3(int a,int b,int c) {
        if ((a<=b)&&(a<=c)) {
            return a;
        } else return b<=c ? b : c;
    }
    
    public static int middle3(int a, int b, int c) {
        if (((a<=b)&&(a>=c))||((a>=b)&&(a<=c))) {
            return a;
        } else if (((b<=a)&&(b>=c))||((b>=a)&&(b<=c))) {
            return b;
        } else return c;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("\t\t\t\t\t\t\tSkillBox introduce: \n" +
                "\t\t\t\t=================================================\n"+
                "\t\t\t\tWELCOME TO OUR SWEDISH FAMILY\n" +
                "\t\t\t\t\t\t\t\tfor just a minute;) or more");
        Scanner scanner = new Scanner(System.in);
        //=================================================================
        System.out.println("What is your name, sweety?");
        String vasyaName = SimpleReading.readString();
        System.out.println("I will call you Vasya, "+vasyaName);
        System.out.println("How old are you, Vasya?");
        int vasyaAge = SimpleReading.readInteger();
        //=================================================================
        System.out.println("What is your name, honey?");
        String mashaName = SimpleReading.readString();
        System.out.println("I will call you Masha, "+mashaName);
        System.out.println("How old are you, Masha?");
        int mashaAge = SimpleReading.readInteger();
        //=================================================================
        System.out.println("What is your name, darling?");
        String mishaName = SimpleReading.readString();
        System.out.println("I will call you Misha, "+mishaName);
        System.out.println("How old are you, Misha?");
        int mishaAge = SimpleReading.readInteger();
        //=================================================================
        int min = min3(vasyaAge,mashaAge,mishaAge);
        int middle = middle3(vasyaAge,mashaAge,mishaAge);
        int max = max3(vasyaAge,mashaAge,mishaAge);
        System.out.println("Minimal Age: "+min);
        System.out.println("Middle Age: "+middle);
        System.out.println("Maximum Age: "+max);
        if (min>17) {
            System.out.println("Well, Vasya, Misha, Masha, let's youuuhuuu!!!");
        } else System.out.println("Sorry, you must go home");

    }
}
