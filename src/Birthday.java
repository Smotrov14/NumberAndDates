import java.time.LocalDate;

    public class Birthday {
    private final LocalDate birthday;
    private final LocalDate today;

    public Birthday(int year, int month, int day) {
        this.birthday = LocalDate.of(year, month, day);
        this.today = LocalDate.now();
    }

    public LocalDate getToday() {
        return today;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}