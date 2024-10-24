import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Date {

    private LocalDate date;

    public Date(LocalDate date) {
        this.date = date;
    }

    public int compareDates(LocalDate otherDate) {
        return date.compareTo(otherDate);
    }

    public long daysSinceStartOfYear() {
        LocalDate startOfYear = LocalDate.of(date.getYear(), 1, 1);
        return ChronoUnit.DAYS.between(startOfYear, date);
    }

    public long daysUntilEndOfYear() {
        LocalDate endOfYear = LocalDate.of(date.getYear(), 12, 31);
        return ChronoUnit.DAYS.between(date, endOfYear);
    }

    public LocalDate addDays(int days) {
        return date.plusDays(days);
    }

    public long daysBetweenDates(LocalDate otherDate) {
        return Math.abs(ChronoUnit.DAYS.between(date, otherDate));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите год:");
        int year = scanner.nextInt();

        System.out.println("Введите месяц:");
        int month = scanner.nextInt();

        System.out.println("Введите число:");
        int day = scanner.nextInt();

        Date dateUtility = new Date(LocalDate.of(2024, 9, 16));
        System.out.println("Введите количество дней для прибавления:");
        int daysToAdd = scanner.nextInt();
        LocalDate otherDate = LocalDate.of(2024, 10, 20);

        System.out.println("Результат сравнения: " + dateUtility.compareDates(otherDate));
        System.out.println("Дней с начала года: " + dateUtility.daysSinceStartOfYear());
        System.out.println("Дней до конца года: " + dateUtility.daysUntilEndOfYear());
        System.out.println("Новая дата после добавления " + daysToAdd + " дней: " + dateUtility.addDays(daysToAdd));
        System.out.println("Дней между датами: " + dateUtility.daysBetweenDates(otherDate));
    }
}