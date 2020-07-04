public class Main {
    public static void main(String[] args) {
        System.out.println((int) 'A');
        System.out.println((int) 'a');
        for (int i = 65; i < 91; i++) {
            System.out.println(i + "  " + ((char) i) + ",  " + (i + 32) + "  " + ((char) (i + 32)));
        }
    }
}
