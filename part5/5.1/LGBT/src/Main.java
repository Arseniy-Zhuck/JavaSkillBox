public class Main {
    public static void main(String[] args) {
        final String LGBT = "Каждый охотник желает знать, где сидит фазан.";
        String[] colorWords = LGBT.substring(0,LGBT.length() - 1).split(",?\\s+");
        for (String colorWord : colorWords) System.out.println(colorWord);
    }
}
