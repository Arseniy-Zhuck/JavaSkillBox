public class Main {
    public static final int PATIENCE_COUNT = 30;
    public static final float MINIMAL_TEMPERATURE = 32;
    public static final float MAXIMAL_TEMPERATURE = 42;
    public static final float MINIMAL_HEALTHY_TEMPERATURE = (float) 36.2;
    public static final float MAXIMAL_HEALTHY_TEMPERATURE = (float) 36.9;

    public static float[] getTemperaturesArray() {
        float[] temp = new float[PATIENCE_COUNT];
        for (int i = 0; i < PATIENCE_COUNT; i++) {
            temp[i] = (float) (MINIMAL_TEMPERATURE + Math.random()*(MAXIMAL_TEMPERATURE - MINIMAL_TEMPERATURE));
        }
        return temp;
    }

    public static void printTemperatures(float[] temp) {
        System.out.print("Температуры пациентов:");
        for (float t : temp) System.out.print(" " + t);
        System.out.println();
    }

    public static float averageTemperature(float[] temp) {
        float sum = 0;
        for (float t : temp) sum += t;
        return (float) (sum / PATIENCE_COUNT);
    }

    public static int healthyCount(float[] temp) {
        int count = 0;
        for (float t : temp)
            if ((t >= MINIMAL_HEALTHY_TEMPERATURE) && (t <= MAXIMAL_HEALTHY_TEMPERATURE))
                count++;
        return count;
    }

    public static void main(String[] args) {
        float[] temperatures = getTemperaturesArray();
        printTemperatures(temperatures);
        System.out.println("Средняя температура: " + averageTemperature(temperatures));
        System.out.println("Количество здоровых: " + healthyCount(temperatures));
    }

}
