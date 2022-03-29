import homework08.task01.ElectricalAppliances;
import homework08.task01.Fridge;
import homework08.task01.Mixer;
import homework08.task01.Toaster;
import homework08.task02.*;
import homework08.task03.*;

public class HomeWork08 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    /*
    Создать цепочку наследования (минимум 3 звена) классов, описывающих бытовую технику.
    Создать несколько объектов описанных классов, часть из них включить в розетку.
    Иерархия должна иметь хотя бы три уровня.
     */
    public static void task1() {
        ElectricalAppliances[] electricalAppliances = new ElectricalAppliances[]{
                new Toaster(), new Mixer(), new Fridge()
        };
        for (int i = 0; i < electricalAppliances.length; i++) {
            System.out.println("Начинаем работу с прибором №" + (i + 1));
            electricalAppliances[i].startJob();
            electricalAppliances[i].plugin();
            electricalAppliances[i].startJob();
            electricalAppliances[i].plugin();
        }
    }

    /*
    Создать цепочку наследования (минимум 3 звена) классов, описывающих банковские карточки.
    Иерархия должна иметь хотя бы три уровня.
     */
    public static void task2() {
        BankCards[] bankCards = new BankCards[]{
                new CreditCardMastercard(), new DebitCardMastercard(), new CreditCardVisa(), new DebitCardVisa()
        };
        for (int i = 0; i < bankCards.length; i++){
            System.out.println( bankCards[i].GetName());
        }
    }

    /*
    Создать цепочку наследования (минимум 3 звена) классов, описывающих должностную структуру на заводе.
    Реализовать методы по начислению зарплаты в зависимости от должности (почасовая, процентная, смешанная).
    Иерархия должна иметь хотя бы три уровня.
     */
    public static void task3() {
        Director[] directors = new Director[]{
                new Director(),new DeputyDirector(),new Foreman(),new SeniorMaster(),new Master()
        };
        for (int i = 0; i< directors.length; i++){
            System.out.println(directors[i].getClass().getName() + ": " + directors[i].salary());
        }
    }
}
