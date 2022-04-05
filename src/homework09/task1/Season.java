package homework09.task1;

public enum Season {
    SUMMER("Hot", 92),
    AUTUMN("Rainmaking", 91),
    LEAP_WINTER("Snow making", 91),
    WINTER("Snow making", 90),
    SPRING("Rainmaking", 92);

    private final String description;
    private final int countOfDays;

    Season(String description, int countOfDays) {
        this.description = description;
        this.countOfDays = countOfDays;
    }

    public String getDescription() {
        return description;
    }

    public int getCountOfDays() {
        return countOfDays;
    }
}
