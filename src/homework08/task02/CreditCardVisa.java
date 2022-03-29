package homework08.task02;

public class CreditCardVisa extends VISA {
    @Override
    public String GetName() {
        return super.GetName() + " Credit";
    }
}
