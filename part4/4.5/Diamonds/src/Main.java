import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // here we replace "<345<22>fdd>222" with "***fdd>222"
    public static String searchAndReplaceDiamonds(String text, String placeholder) {
        String s = text;
        String result = "";
        int diamondStartIndex = s.indexOf("<");
        while (diamondStartIndex >= 0) {
            if (s.indexOf(">") >= 0) {
                String s1 = s.substring(0, diamondStartIndex);
                s = s.substring(s.indexOf(">") + 1);
                result += s1 + placeholder;
                diamondStartIndex = s.indexOf("<");
            } else break;
        }
        return result + s;
    }

    // here we replace "<345<22>fdd>222" with "***222"
    public static String searchAndReplaceDiamonds1 (String text, String placeholder) throws InterruptedException {
        String s = text;
        String result = "";
        int diamondStartIndex = s.indexOf("<");
        while (diamondStartIndex >= 0) {
            int diamondFinishIndex = s.indexOf('>');
            //System.out.println(diamondFinishIndex);
            //Thread.sleep(6000);
            int posPar = positionParameter(s, diamondFinishIndex);
            //System.out.println(posPar);
            //Thread.sleep(6000);
            while (posPar != 0) {
                diamondFinishIndex = s.indexOf('>', diamondFinishIndex + 1);
                //System.out.println(diamondFinishIndex);
                //Thread.sleep(6000);
                if (diamondFinishIndex == -1) break;

                posPar = positionParameter(s, diamondFinishIndex);
                //System.out.println(posPar);
                //Thread.sleep(6000);
            }
            if (diamondFinishIndex == -1) break;
            String s1 = s.substring(0, diamondStartIndex);
            s = s.substring(diamondFinishIndex + 1);
            result += s1 + placeholder;
            diamondStartIndex = s.indexOf("<");
        }
        return result + s;
    }

    public static int positionParameter(String s, int position) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i <= position; i++) {
            if (chars[i]=='<') result++;
            if (chars[i]=='>') result--;
        }
        return result;
    }

    public static String searchAndReplaceDiamondsReg(String text, String placeholder) {
        return text.replaceAll("<.*?>",placeholder);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, write string");
        String s = bufferedReader.readLine();
        System.out.println("Please, write replacement");
        String replacement = bufferedReader.readLine();
        System.out.println(searchAndReplaceDiamonds(s, replacement));
        System.out.println(searchAndReplaceDiamondsReg(s, replacement));

    }


}
