import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Задача №1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во ящиков");
        TrucksAndContainers boxCount = new TrucksAndContainers(scanner.nextInt());
        boxCount.printInfo();


        // Задача № 2
        System.out.print("Введите год рождения: ");
        int year = new Scanner(System.in).nextInt();
        System.out.print("Введите месяц рождения: ");
        int month = new Scanner(System.in).nextInt();
        System.out.print("Введите день рождения: ");
        int day = new Scanner(System.in).nextInt();

        System.out.println(collectBirthdays(year, month, day));
    }

    public static String collectBirthdays(int year, int month, int day){
        Birthday birthday = new Birthday(year,month,day);
        LocalDate dateCounter = birthday.getBirthday();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String result="";
        int yearCounter = 0;
        while(dateCounter.isBefore(birthday.getToday()) || dateCounter.isEqual(birthday.getToday())){
            String result1 = String.valueOf(yearCounter) + "-" + dateCounter.format(formatter) + "-" + dateCounter.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH)+  System.lineSeparator();
            dateCounter = dateCounter.plusYears(1);
            yearCounter ++;
            result =result + result1;
        }
        return result;
    }
}