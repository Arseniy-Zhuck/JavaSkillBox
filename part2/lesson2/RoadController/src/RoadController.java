import core.*;
import core.Camera;

import java.util.Scanner;

public class RoadController {
    // недоступная перенная класса типа double
    private static double passengerCarMaxWeight = 3500.0; // kg
    // недоступная перенная класса типа int
    private static int passengerCarMaxHeight = 2000; // mm
    // недоступная перенная класса типа int
    private static int controllerMaxHeight = 4000; // mm
    // недоступная перенная класса типа int
    private static int passengerCarPrice = 100; // RUB
    // недоступная перенная класса типа int
    private static int cargoCarPrice = 250; // RUB
    // недоступная перенная класса типа int
    private static int vehicleAdditionalPrice = 200; // RUB

    public static void main(String[] args) {
        System.out.println("Сколько автомобилей сгенерировать?");
        // переменная - ссылка на объект класса scanner
        Scanner scanner = new Scanner(System.in);
        // перенная типа int
        int carsCount = scanner.nextInt();
        // тут в цикле объявление i типа int
        for (int i = 0; i < carsCount; i++) {
            // переменная - ссылка на объект класса Car 
            Car car = Camera.getNextCar();
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            // перенная типа int
            int price = calculatePrice(car);
            if (price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car) {
        // перенная типа int
        int carHeight = car.height;
        // перенная типа int
        int price = 0;
        if (carHeight > controllerMaxHeight) {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        } else if (carHeight > passengerCarMaxHeight) {
            // перенная типа double
            double weight = car.weight;
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight) {
                price = passengerCarPrice;
                if (car.hasVehicle) {
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
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay() {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason) {
        System.out.println("Проезд невозможен: " + reason);
    }
}