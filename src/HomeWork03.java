public class HomeWork03 {
    public static void main(String[] arks) {
        HomeWork03 homeWork03 = new HomeWork03();
        System.out.println(homeWork03.task1(207));
        System.out.println(homeWork03.task1(198));

        System.out.println(homeWork03.task2(3, 4, 3));
        System.out.println(homeWork03.task2(3, 4, 2));

        System.out.println(homeWork03.task3(111));
        System.out.println(homeWork03.task3(201));
        System.out.println(homeWork03.task3(212));
        System.out.println(homeWork03.task3(13));
        System.out.println(homeWork03.task3(314));
        System.out.println(homeWork03.task3(152));
        System.out.println(homeWork03.task3(73));
        System.out.println(homeWork03.task3(84));
        System.out.println(homeWork03.task3(777));

        System.out.println(homeWork03.task4(31, 12, 1991));
        System.out.println(homeWork03.task4(31, 1, 1991));
        System.out.println(homeWork03.task4(31, 2, 1991));
        System.out.println(homeWork03.task4(28, 2, 1991));
        System.out.println(homeWork03.task4(31, 3, 1991));
        System.out.println(homeWork03.task4(13, 3, 1991));
        System.out.println(homeWork03.task4(31, 4, 1991));
        System.out.println(homeWork03.task4(30, 4, 1991));
        System.out.println(homeWork03.task4(31, 5, 2001));
        System.out.println(homeWork03.task4(30, 6, 2001));
        System.out.println(homeWork03.task4(31, 7, 2001));
        System.out.println(homeWork03.task4(31, 8, 2001));
        System.out.println(homeWork03.task4(30, 9, 2001));
        System.out.println(homeWork03.task4(31, 10, 2001));
        System.out.println(homeWork03.task4(30, 11, 2001));
        System.out.println(homeWork03.task4(1, 7, 2001));
        System.out.println(homeWork03.task4(-1, 7, 2001));

        System.out.println(homeWork03.task5(17, 19, 10, 20, 31, 20));
        System.out.println(homeWork03.task5(17, 19, 10, 20, 25, 20));
        System.out.println(homeWork03.task5(17, 19, 10, 20, 25, 19));
        System.out.println(homeWork03.task5(17, 19, 10, 20, 25, 43));

        System.out.println(homeWork03.task6(1));
        System.out.println(homeWork03.task6(2));
        System.out.println(homeWork03.task6(3));
        System.out.println(homeWork03.task6(4));
        System.out.println(homeWork03.task6(5));
        System.out.println(homeWork03.task6(6));
        System.out.println(homeWork03.task6(7));
        System.out.println(homeWork03.task6(8));
        System.out.println(homeWork03.task6(-8));
    }

    public boolean task1(int parameter) {
        return parameter % 10 == 7;
    }

    public boolean task2(int a, int b, int r) {
        return Math.sqrt(a * a + b * b) / 2 <= r;
    }

    public String task3(int money) {
        if (money % 10 == 1 && money % 100 != 11) {
            return money + " рубль";
        } else if (money % 10 == 2 && money % 100 != 12
                || money % 10 == 3 && money % 100 != 13
                || money % 10 == 4 && money % 100 != 14) {
            return money + " рубля";
        } else {
            return money + " рублей";
        }
    }

    public String task4(int day, int month, int year) {
        if (day == 31 && month == 12) {
            return "1 1 " + (year + 1);
        } else if (day == 31 &&
                (month == 1
                        || month == 3
                        || month == 5
                        || month == 7
                        || month == 8
                        || month == 10)
                || day == 30 &&
                (month == 4
                        || month == 6
                        || month == 9
                        || month == 11)
                || day == 28 && month == 2) {
            return "1 " + (month + 1) + " " + year;
        } else if (day < 1 || day > 31 || (month == 4
                || month == 6
                || month == 9
                || month == 11) && day > 30 || day > 28 && month == 2) {
            return "не верные вводные данные";
        } else {
            return (day + 1) + " " + month + " " + year;
        }
    }

    public boolean task5(float a, float b, float c, float d, float e, float f) {
        return a + c <= e && b <= f && d <= f || b + d <= f && a <= e && c <= e;
    }

    public String task6(int day) {
        switch (day) {
            case 1:
                return "Задание на понедельник";
            case 2:
                return "Задание на вторник";
            case 3:
                return "Задание на среду";
            case 4:
                return "Задание на четверг";
            case 5:
                return "Задание на пятницу";
            case 6:
                return "Задание на субботу";
            case 7:
                return "Задание на воскресение";
            default:
                return "Дня с таким номером не существует";
        }
    }
}
