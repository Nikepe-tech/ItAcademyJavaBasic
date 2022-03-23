package homework06.task01;

public class Time {
    int sec;
    int min;
    int hour;

    public Time(final int sec) {
        this.hour = sec / 3600;
        this.min = sec % 3600 / 60;
        this.sec = sec % 3600 % 60;
    }

    public Time(final int hour, final int min, final int sec) {
        this.hour = hour;
        this.min = min;
        this.sec = sec;
    }

    public int fullSec() {
        return sec + min * 60 + hour * 3600;
    }

    public int compereTo(final Time anotherTime) {
        if (anotherTime == null) {
            return 1;
        }
        return Integer.compare(this.fullSec(), anotherTime.fullSec());
    }
}
