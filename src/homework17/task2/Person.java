package homework17.task2;

public class Person {
    private final String name;
    private final String surname;
    private final int yearOfBirth;

    private Person(String name, String surname, int yearOfBirth) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ' ' +
                "Фамилия: " + surname + ' ' +
                "Год рождения: " + yearOfBirth;
    }

    public static class PersonBuilder {

        private String name;
        private String surname;
        private int yearOfBirth;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder setYearOfBirth(int yearOfBirth) {
            this.yearOfBirth = yearOfBirth;
            return this;
        }

        public Person build() {
            return new Person(name, surname, yearOfBirth);
        }
    }
}
