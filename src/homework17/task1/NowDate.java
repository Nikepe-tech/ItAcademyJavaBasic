package homework17.task1;

import java.util.Date;

public class NowDate {
    private static NowDate instance;

    private NowDate() {
    }

    public void displaysTheCurrentDate() {
        Date date = new Date();
        System.out.println(date);
    }

    public static NowDate getInstance() {
        if (instance == null) {
            instance = new NowDate();
        }
        return instance;
    }
}
