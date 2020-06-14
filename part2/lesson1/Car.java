package core; // а чтобы несколько классов в пакеты объединять, понял

public class Car { // класс Car
    // общедоступные свойства Объекта
    // а разве так можно делать???
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public String toString() { // общедоступный метод объекта возвращает строку
        /*
        если в hasVehicle сидит true то в строку special загнать текст
        иначе записать в нее пустую строку
        */
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : "";
        // возвращает сильно замороченную строку c переносами строк tabами и значениями
        // свойств конкретного объекта 

        return "\n=========================================\n" +
            special + "Автомобиль с номером " + number +
            ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
}