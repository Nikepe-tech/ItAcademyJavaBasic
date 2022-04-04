package homework08.task02;

public class DebitCardMastercard extends MasterCard{
    @Override
    public String GetName() {
        return super.GetName() + " Debit";
    }
}
