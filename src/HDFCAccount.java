import java.util.UUID;

public class HDFCAccount implements BankInterface
{

    private String userName;
    private String password;
    private String accNo;
    private int balance;
    private double ROI;

    public HDFCAccount(String userName, String password, int balance) {
        this.userName = userName;
        this.password = password;
        this.balance = balance;

        ROI = 7.2;
        accNo = String.valueOf(UUID.randomUUID());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public String depositeAmount(int amount) {
        balance += amount;
        return "Account Balance after credited " +amount+ "Rs. :" +balance;
    }

    @Override
    public String withdrawlAmount(String enteredPassword, int money) {
        if(enteredPassword.equals(this.password))
        {
            if(balance < money) return "InSufficient Balance " + balance;
            else{
                balance -= money;
                return "Account Balance after deduct "+ money + "Rs. : "+ balance;
            }
        }
        else return "Wong Password Entered";
    }

    @Override
    public Double calculateInterest(int time) {
        double amount_SI = (balance * ROI * time) / 100;
        return amount_SI;
    }
}
