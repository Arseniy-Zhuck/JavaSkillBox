package core; // видимо пакет, но не знаю, что это такое - разбираюсь, много вопросов
// а получается классы внутри одного пакеты не надо import???

public class Camera { // класс Camera
    // доступный метод класса возвращает объект класса Car
    public static Car getNextCar() { 

        // построение случайного номера
        /* 
            получается у класса Double (видимо для работы с числами double)
            есть метод toString ему передаем случайное число от 0.0 до 1.0
            и получается что у результата строки вызываем метод substring
            аргументы наверно от 2 до 4???? символа 
        */
        String randomNumber = Double.toString(Math.random()).substring(2, 5);
        // задаем случайную высоту (int) видимо преобразает полученный double в int
        int randomHeight = (int) (1000 + 3500. * Math.random());
        // задаем случайные вес
        double randomWeight = 600 + 10000 * Math.random();
        // создаем объект класса Car
        Car car = new Car();
        // задаем его свойства сгенеренными рандомами
        car.number = randomNumber;
        car.height = randomHeight;
        car.weight = randomWeight;
        // случайное число от 0.0 до 1.0 сравниваем с 0,5 итог типа bool записываем в соответсвующие
        // атрибуты
        car.hasVehicle = Math.random() > 0.5;
        car.isSpecial = Math.random() < 0.15;
        // завершаем метод, возвращаем объект car
        return car;
    }
}