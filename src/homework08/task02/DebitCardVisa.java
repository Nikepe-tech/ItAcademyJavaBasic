package homework08.task02;

public class DebitCardVisa extends VISA{
    @Override
    public String GetName() {
        return super.GetName() + " Debit";
    }
}
