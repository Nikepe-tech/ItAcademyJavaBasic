package homework08.task02;

public class CreditCardMastercard extends MasterCard{
    @Override
    public String GetName() {
        return super.GetName() + " Credit";
    }
}
