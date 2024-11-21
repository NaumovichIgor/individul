class Dates {
    private int day;
    private int month;
    private int year;

    public Dates(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int compareTo(Dates other) {
        if (this.year != other.year) {
            return this.year - other.year;
        }
        if (this.month != other.month) {
            return this.month - other.month;
        }
        return this.day - other.day;
    }

    public int daysPassed() {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysPassed = 0;
        for (int i = 1; i < this.month; i++) {
            daysPassed += daysInMonth[i];
        }
        daysPassed += this.day;
        return daysPassed;
    }

    public int daysRemaining() {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDaysInYear = 365;
        return totalDaysInYear - this.daysPassed();
    }

    public Dates addDays(int daysToAdd) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int newDay = this.day;
        int newMonth = this.month;
        int newYear = this.year;

        newDay += daysToAdd;

        while (newDay > daysInMonth[newMonth]) {
            newDay -= daysInMonth[newMonth];
            newMonth++;
            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }

        return new Dates(newDay, newMonth, newYear);
    }

    public int difference(Dates other) {
        int totalDays1 = this.toDays();
        int totalDays2 = other.toDays();
        return Math.abs(totalDays1 - totalDays2);
    }

    private int toDays() {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;

        totalDays += this.year * 365;

        for (int i = 1; i < this.month; i++) {
            totalDays += daysInMonth[i];
        }

        totalDays += this.day;

        return totalDays;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    public static void main(String[] args) {
        Dates date1 = new Dates(20, 10, 2024);
        Dates date2 = new Dates(4, 10, 2024);

        System.out.println("Сравнение дат: " + date1 + " и " + date2);
        System.out.println("Результат сравнения: " + date1.compareTo(date2));

        System.out.println("Дней с начала года " + date1 + ": " + date1.daysPassed());

        System.out.println("Дней до конца года " + date1 + ": " + date1.daysRemaining());

        int daysToAdd = 10;
        Dates newDate = date1.addDays(daysToAdd);
        System.out.println("Новая дата после добавления " + daysToAdd + " дней к " + date1 + " будет " + newDate);
    }
}
