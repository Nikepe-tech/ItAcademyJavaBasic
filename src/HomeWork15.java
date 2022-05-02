import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Scanner;

public class HomeWork15 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    /*
    Ввести с клавиатуры номер месяца текущего года. Вывести на экран все его даты в формате d::MMM::yyyy.
     */
    public static void task1() {
        System.out.print("Введите номер месяца: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int month = scanner.nextInt();
            if (month > 12 || month < 1) {
                System.out.println("Такого месяца несуществует");
            }
            LocalDate localDate = LocalDate.now();
            LocalDate with = localDate.with(ChronoField.MONTH_OF_YEAR, month).with(ChronoField.DAY_OF_MONTH, 1);
            for (int i = 0; i < with.lengthOfMonth() && with.getMonthValue() == month; i++) {
                System.out.println(with.format(DateTimeFormatter.ofPattern("d::MMM::yyyy")));
                with = with.plusDays(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    От текущей даты вывести расписание всех встреч, которые происходят еженедельно в 13:00 в течение 2 месяцев.
     */
    public static void task2() {
        LocalDateTime startDateTime = LocalDateTime.now().withHour(13).withMinute(0).withSecond(0).withNano(0);
        for (LocalDateTime meeting = LocalDateTime.from(startDateTime);
             meeting.isBefore(startDateTime.plusMonths(2));
             meeting = meeting.plus(Period.ofWeeks(1))) {
            System.out.println(meeting.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        }
    }

    /*
    От текущей даты вывести на экран дату, которая была 60 дней назад.
     */
    public static void task3() {
        LocalDate result = LocalDate.now().minusDays(60);
        System.out.println(result.format(DateTimeFormatter.ofPattern("dd/MMMM/yyyy")));
    }
}
