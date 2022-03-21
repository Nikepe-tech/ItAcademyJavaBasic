package homework06.task02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
    int den20;
    int den50;
    int den100;

    public ATM(final int den20, final int den50, final int den100) {
        this.den20 = den20;
        this.den50 = den50;
        this.den100 = den100;
    }

    public void addCache(final int den20, final int den50, final int den100) {
        this.den20 += den20;
        this.den50 += den50;
        this.den100 += den100;
    }

    private int fullMoney() {
        return den20 * 20 + den50 * 50 + den100 * 100;
    }

    public boolean getCache() {
        System.out.print("Введите сумму: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int money = scanner.nextInt();
            if (money > fullMoney()) {
                System.out.println("В банкомате недостаточно средств.");
                return false;
            }
            int asked100 = money / 100;
            int asked50 = money % 100 / 50;
            int asked20 = money % 100 % 50 / 20;
            int askedOther = money % 100 % 50 % 20;
            if (asked100 == 0 && asked50 == 0 && asked20 == 0){
                System.out.println("Банкомат может выдавать только купюры номиналом 20, 50 и 100.");
                return false;
            }
            while (den100 < asked100){
                asked100--;
                asked50 += 2;
            }
            while (money - asked100 * 100 < 20 && money - asked100 * 100 < 50) {
                asked100--;
                    asked50++ ;
            }
            if (asked100 * 100 + asked50 * 50 == money) {}
            else if (money - (asked100 * 100 + asked50 * 50 + askedOther) < 20) {
                asked50--;
            }
             asked20 = (money - (asked100 * 100 + asked50 * 50)) / 20;
            if (asked100 * 100 + asked50 * 50 + asked20 * 20 == money) {
                askedOther = 0;
            }
            if (asked20 > den20
                    || asked50 > den50
                    || asked100 > den100 && asked50 * 2 > den100 && asked20 * 5 > den100) {
                System.out.println("Банкомат может выдавать только купюры номиналом 20, 50 и 100.");
                return false;
            } else {
                den20 -= asked20;
                den50 -= asked50;
                den100 -= asked100;
                System.out.println("Количество купюр номиналом 20 - " + asked20);
                System.out.println("Количество купюр номиналом 50 - " + asked50);
                System.out.println("Количество купюр номиналом 100 - " + asked100);
                return true;
            }

        } catch (InputMismatchException ex1) {
            System.out.println("Введена некорректная сумма, должно быть целое число.");
            return false;
        }
    }
}
