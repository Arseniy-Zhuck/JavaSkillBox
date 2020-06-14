package core;

public class Car {
    // общедоступная переменная объекта типа String
    public String number;
    // общедоступная переменная объекта типа int
    public int height;
    // общедоступная переменная объекта типа double
    public double weight;
    // общедоступная переменная объекта типа boolean
    public boolean hasVehicle;
    // общедоступная переменная объекта типа boolean
    public boolean isSpecial;

    public String toString() {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}