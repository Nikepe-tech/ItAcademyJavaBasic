package homework16;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Academy {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface AcademyInfo {
        int year();
    }

    @AcademyInfo(year = 2020)
    public static void endAcademicYear() {
        System.out.println("Я закончил обучение");
    }

    public static void annualEvent() {
        System.out.println("Это мероприятие проходит каждый год");
    }
}
