import java.util.Scanner;


public class Loader {
    public static void main(String[] args) {
        System.out.println("\t\t\t\t\t\t\tSkillBox introduce: \n" +
                "\t\t\t\t=================================================\n"+
                "\t\t\t\tOUR NEW SCHOOL FOR COOKING in lowerCamelCase\n" +
                "\t\t\t\t\t\t\t\t\"notOnlyPelmeni\"");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much milk do you have? Answer in ml, please");
        int milkAmount = scanner.nextInt(); // ml
        System.out.println("How much powder do you have? Answer in g, please");
        int powderAmount = scanner.nextInt(); // g
        System.out.println("How many eggs do you have? Answer in items, please");
        int eggsCount = scanner.nextInt(); // items
        System.out.println("How much sugar do you have? Answer in g, please");
        int sugarAmount = scanner.nextInt(); // g
        System.out.println("How much oil do you have? Answer in ml, please");
        int oilAmount = scanner.nextInt(); // ml
        System.out.println("How many apples do you have? Answer in items, please");
        int appleCount = scanner.nextInt();
        boolean looser = true;
        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        String dish="";
        String recipe="";
        if ((powderAmount>=400) && (sugarAmount>=10) && (milkAmount>=1000) &&(oilAmount>=30)) {
            dish="Pancakes";
            recipe="powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml";
            looser = false;
        } else if ((powderAmount>=5) && (milkAmount>=300) &&(eggsCount>=5)) {
            dish="Omelette";
            recipe="milk - 300 ml, powder - 5 g, eggs - 5";
            looser = false;
        } else if ((powderAmount>=300) && (appleCount>=3) && (milkAmount>=100) &&(eggsCount>=4)) {
            dish="Apple pie";
            recipe="apples - 3, milk - 100 ml, powder - 300 g, eggs - 4";
            looser = false;
        }

        if (looser) {
            System.out.println("Well,you see, i have an advise for you:\n" +
                    "Learn Java, earn money, go to the best restaurant and find wife");
        } else {
            System.out.println(dish + ":\n" +
                     recipe +"\n" +
                    "and then ...\n" +
                    "wait,for a minute, my wife will come soon\n" +
                    "...\n");
            String s = scanner.nextLine();
            System.out.println("Sorry,she is busy(((");
        }
    }
}