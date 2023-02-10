public interface BankInterface
{
    int getBalance();
    String depositeAmount(int amount);
    String withdrawlAmount(String password, int amount);
    Double calculateInterest(int time);
}
