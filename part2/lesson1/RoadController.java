import core.*; // а мы делаем импорт класса, получается?
import core.Camera; // а все равно, зачем * а потом camera
                    // разве * не подключит все классы, или только первый встретившийся?

import java.util.Scanner; // получается есть пакет util и внем класс scanner?

public class RoadController {
    // задание начальных значений
    private static double passengerCarMaxWeight = 3500.0; // kg
    private static int passengerCarMaxHeight = 2000; // mm
    private static int controllerMaxHeight = 4000; // mm

    private static int passengerCarPrice = 100; // RUB
    private static int cargoCarPrice = 250; // RUB
    private static int vehicleAdditionalPrice = 200; // RUB
    // главный метод проекта, точка входа, получается
    public static void main(String[] args) {
        // вывод в консоль
        System.out.println("Сколько автомобилей сгенерировать?");
        // создание объекта Scanner для считывая откуда угодно и передача в него 
        // входного потока, как я понимаю
        Scanner scanner = new Scanner(System.in);
        // получение целого числа из входного потока и запись
        // в переменную
        int carsCount = scanner.nextInt();
        // главный цикл
        for (int i = 0; i < carsCount; i++) {
            // создание объекта car вызовом метода getNextCar класса Camera
            Car car = Camera.getNextCar();
            // вывод объекта Car на экран, по факту вызов метода toString класса Car
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                // вызов метода open way текущего класса
                openWay();
                //переход к следующей итерации цикла
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car); // вызов метода calculatePrice текущего класса
            // c аргументом car
            if (price == -1) {
                continue;
            }
            // вывод в консоль
            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car) {
        // объявление перемнных
        int carHeight = car.height;
        int price = 0;
        // проверка высоты
        if (carHeight > controllerMaxHeight) {
            // вызов метода blockWay текущего класса с аргументтом строкой 
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            // завершение метода и возвращение -1
            return -1;
        } else if (carHeight > passengerCarMaxHeight) { // проверка высоты пассажрский/грузовой
            double weight = car.weight;
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight) { 
                // проверка веса пассажрский/грузовой
                price = passengerCarPrice;
                if (car.hasVehicle) { // проверка наличия прицепа
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = cargoCarPrice;
            }
        } else {
            price = passengerCarPrice;
        }
        // завершение метода возвращение накопленного price
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() { // метод был там раньше его вызов
        // вывод в консоль
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) { // метод был там раньше его вызов
        // вывод в консоль сообщения и аргумента метода
        System.out.println("Проезд невозможен: " + reason);
    }
}