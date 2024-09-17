/* 1. Создайте объекты класса Double, используя методы valueOf().
2. Преобразовать значение типа String к типу double. Используем
метод Double.parseDouble().
3. Преобразовать объект класса Double ко всем примитивным типам.
4. Вывести значение объекта Double на консоль.
5. Преобразовать литерал типа double к строке: String d = Double.toString */
import java.util.Scanner;
public class Wrapper_Classes {
    public static void main(String[] args) {

        // Создание объектов класса Double с использованием методов valueOf()
        Scanner sc = new Scanner(System.in); // создаем объект класса Scanner, связываем со стандартным потоком ввода (клавиатура - System.in)
        System.out.println("Введите значение d1:");
        Double d1 = Double.valueOf(sc.nextDouble());
        System.out.println("Введите значение d2:");
        Double d2 = Double.valueOf(sc.next());

        // Преобразование значение типа String к типу double ч/з метод Double.parseDouble()
        System.out.println("Введите значение d3:");
        double d3 = Double.parseDouble(sc.next());

        /* Преобразование объекта класса Double ко всем примитивным типам.
        Для этого используем методы ПримитивныйТип.Value */
        byte byte_v = d1.byteValue();
        short short_v = d1.shortValue();
        int int_v = d1.intValue();
        long long_v = d1.longValue();
        float float_v = d1.floatValue();
        char char_v = (char) d1.intValue(); // Преобразование в char может привести к потере данных

        // Вывести значение объекта Double на консоль
        System.out.println("Значение объекта d1: " + d1);
        System.out.println("Значение объекта d2: " + d2);

        // Преобразовать литерал типа double к строке
        System.out.println("Введите значение d4:");
        double d4 = sc.nextDouble(); // с потока ввода получаем значение типа double
        String d4_str = Double.toString(d4); // с помощью метода класса Double переводим значение в его строковое представление

        // Вывод остальных значений
        System.out.println("Значение объекта d3: " + d3);
        System.out.println("d1 -> byte: " + byte_v);
        System.out.println("d1 -> short: " + short_v);
        System.out.println("d1 -> int: " + int_v);
        System.out.println("d1 -> long: " + long_v);
        System.out.println("d1 -> float: " + float_v);
        System.out.println("d1 -> char: " + char_v);
        System.out.println("Значение строки d4_str: " + d4_str);
    }
}
