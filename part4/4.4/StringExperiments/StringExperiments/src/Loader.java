
public class Loader
{
    public static void main(String[] args)
    {
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        int[] array = new int[10];
        int start = (int) '0';

        for (int i = 0; i < 10; i++) {
            char c = (char) (i + start);
            String s = "" + c;
            array[i] = text.indexOf(s);
        }
        int vasyaMoneyIndex = array[0];
        for (int i = 0; i < 10; i++) {
            if ((array[i] < vasyaMoneyIndex) && (array[i] != -1)) vasyaMoneyIndex = array[i];
        }
        int vasyaMoneyIndexStop = text.indexOf(" ", vasyaMoneyIndex);
        // System.out.println(vasyaMoneyIndex + " " +  vasyaMoneyIndexStop);
        int vasyaMoney = Integer.parseInt(text.substring(vasyaMoneyIndex, vasyaMoneyIndexStop));

        String text1 = text.substring(text.indexOf("Маша"));
        for (int i = 0; i < 10; i++) {
            char c = (char) (i + start);
            String s = "" + c;
            array[i] = text1.indexOf(s);
        }
        int mashaMoneyIndex = array[0];
        for (int i = 0; i < 10; i++) {
            if ((array[i] < mashaMoneyIndex) && (array[i] != -1)) mashaMoneyIndex = array[i];
        }
        int mashaMoneyIndexStop = text1.indexOf(" ", mashaMoneyIndex);
        int mashaMoney = Integer.parseInt(text1.substring(mashaMoneyIndex, mashaMoneyIndexStop));

        System.out.println(vasyaMoney + mashaMoney);
        // это как-то очень сложно, но лучше не придумал
        // был вариант вообще идти посимвольно, но надо же substring и indexof пользовать,
        // вышло только так, к сожалению

        //        System.out.println(text);
    }
}