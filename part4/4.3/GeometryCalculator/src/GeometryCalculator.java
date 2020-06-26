import static java.lang.Math.*;

public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius - квадрат, необязательно
    public static double getCircleSquare(double radius) {
        return PI*radius*radius;
    }

    // метод должен использовать абсолютное значение radius
    // объем сферы - чушь с математической точки зрения, объем шара, подправьте)))
    public static double getSphereVolume(double radius) {
        return 4.0 / 3 * PI * pow(abs(radius), 3);
    }

    public static boolean isTriangleRightAngled(double a, double b, double c) {
        return (a < b + c) && (b < a + c) && (c < a + b);
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTriangleRightAngled, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTriangleRightAngled(a, b, c)) {
            double p = (a + b + c) / 2.0;
            double s = sqrt(p * (p - a) * (p - b) * (p - c));
            return s;
        } else return  -1;
    }
}
