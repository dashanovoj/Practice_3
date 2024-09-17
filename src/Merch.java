import java.text.NumberFormat; // импортируем библиотеку для форматирования и разбора чисел
import java.util.Locale; // импортируем библиотеку для получения региональных символов (валюта)
import java.util.Scanner; // импортируем библиотеку для ввода данных с клавиатуры
public class Merch {

    // Функция для форматирования цены в выбранной валюте
    private static String formatPrice(double price, Locale locale) {
        // Экземпляр класса NumberFormat для форматирования чисел
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale); // возвращает экземпляр валюты
        return formatter.format(price); // отображение форматирования
    }

    // Функция для получения Locale для выбранной валюты
    private static Locale getLocaleForCurrency(int currencyChoice) {
        switch (currencyChoice) {
            case 1:
                return Locale.FRANCE; // используем Locale.FRANCE для евро (изначальная цена)
            case 2:
                return Locale.US; // Locale для доллара США
            case 3:
                return Locale.getDefault(); // Locale по умолчанию для рубля
            default:
                return Locale.FRANCE; // изначальная цена
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // создаем объект класса Scanner, связываем со стандартным потоком ввода (клавиатура - System.in)
        // Список товаров с ценами
        String [] products = {"Caps", "T-shirts", "Jackets"};
        double [] prices = {45.00, 70.00, 120.00}; // цена в евро

        // Вывод списка товаров
        System.out.println("List of products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " - " + prices[i] + " euro.");
        }

        // Выбор товара
        System.out.print("Choose the product (enter the number): ");
        int index = sc.nextInt() - 1; // считываем с потока ввода номер товара

        // Проверка корректности ввода номера товара
        if (index < 0 || index >= products.length) {
            System.out.println("Incorrect product number.");
            return; // Выход из программы
        }

        // Выбор валюты
        System.out.print("Choose the currency (1 - euro, 2 - dollar, 3 - ruble): ");
        int CurrencyChoice = sc.nextInt(); // считываем с потока ввода номер валюты

        // Курсы валют
        double EURtoRUB = 1.0 * 101.28; // 1 евро = 101.28 рубля
        double EURtoUSD = 1.0 * 1.11; // 1 евро = 1.11 долларов

        // Рассчет стоимости покупки
        double Total_Price = prices[index]; // получаем цену нужного товара
        switch (CurrencyChoice) { // выбираем валюту
            case 1: // Евро
                break; // Ничего не делаем, цена уже в евро
            case 2: // Доллар
                Total_Price *= EURtoUSD; // переводим евро в доллары
                break;
            case 3: // Рубль
                Total_Price *= EURtoRUB; // переводим евро в рубли
                break;
            default: // ни одно из значений case не совпадает с выражением
                System.out.println("Wrong currency");
                return; // Выход из программы
        }

        // Вывод результата
        // Возвращает отформатированную цену вместе с выбранной валютой
        System.out.println("Стоимость покупки: " + formatPrice(Total_Price, getLocaleForCurrency(CurrencyChoice)));
    }
    }

