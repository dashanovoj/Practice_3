/* 1. Пользователь должен ввести с клавиатуры размер массива -
натуральное число, так, чтобы введенное пользователем число сохранялось в переменную n.
2. Если пользователь ввел не подходящее число, то
программа должна просить пользователя повторить ввод.
3. Создать массив из n случайных целых чисел из отрезка [0; n] и вывести его на экран.
4. Создать второй массив только из четных элементов первого массива, если они там есть, и
вывести его на экран */
import java.util.Arrays; // импортируем библиотеку для вывода массива чисел
import java.util.Scanner; // импортируем библиотеку для ввода данных с клавиатуры
import java.util.Random; // импортируем библиотеку для генерации случайных чисел

public class Math_Random {

    // Создаём метод для проверки вводимого с клавиатуры натурального числа
    public static boolean IsNaturalNumber (String s) {
        // для продолжения работы кода используем механизм try...catch от возникновения ошибки
        try {
            int n = Integer.parseInt(s); // метод для преобразования строки в число (обращаемся к оболочке Integer)
            if (n <= 0) { // если число целочисленное, но отрицательное выводим false
                return false;
            }
            else {
                return true;
            }
        } catch (NumberFormatException ex) { // если число нецелочисленное выводим false
            return false;
        }
    }

    public static void main(String[] args) {
        String s; // строка вводимого значения
        int n; // размер массива
        System.out.println("Введите размер массива:");
        Scanner sc = new Scanner(System.in); // создаем объект класса Scanner, связываем со стандартным потоком ввода (клавиатура - System.in)

        // Получение размера массива
        while (true) { // повторный ввод до получения натурального значения
            s = sc.next(); // с потока ввода получаем значение
            if (IsNaturalNumber(s)) { // если число натуральное
                n = Integer.parseInt(s); // получаем это значение, через перевод строки в число
                break; // выходим из цикла while
            }
            else { // иначе - число не натуральное, вывод ошибки и повторный вход в цикл while
                System.out.println("Ошибка! Вы ввели не натуральное число!");
                System.out.println("Введите размер массива ещё раз.");
            }
        }

        // Создание массива из случайных чисел
        int [] rand_n = new int[n]; // создаём массив размера n
        Random rand = new Random(); // создаём экземпляр класса Random
        for (int i = 0; i < n; i++) {
            rand_n[i] = rand.nextInt(n + 1); // генерируем случайные целые числа в интервале от 0 до n
        }
        // Вывод массива через его преобразование в строку
        System.out.println("Массив из " + n + " случайных целых чисел из отрезка [0;" + n + "]:\n" + Arrays.toString(rand_n));

        // Получение нового массива из четных значений первого
        int even_count = 0; // создаём переменную, в которой будет хранить кол-во четных элементов первого массива
        for (int i = 0; i < n; i++) {
            if (rand_n[i] % 2 == 0) even_count++; // счётчик увеличивается, если встречается чётный элемент
        }
        if (even_count > 0) { // если такие элементы нашлись
            int[] rand_even_n = new int[even_count]; // создаём новый массив (размер - количество найденных элементов)
            int even_index = 0; // создаём отдельно индекс для нового массива
            for (int i = 0; i < n; i++) { // проходимся по первому массиву
                if (rand_n[i] % 2 == 0) { // если встречается чётный элемент
                    rand_even_n[even_index] = rand_n[i]; // добавляем к новому массиву элемент первого массива
                    even_index++; // увеличиваем значение индекса нового массива
                }
            }
            System.out.println("Массив из чётных элементов первого массива:\n" + Arrays.toString(rand_even_n));
        }
        // иначе выводим, что такие элементы отсутствуют в первом массиве
        else System.out.println("В массиве отсутствуют чётные элементы");
    }
}