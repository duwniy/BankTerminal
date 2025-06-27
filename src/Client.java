import java.sql.SQLOutput;

public class Client extends User{
    private final String bankAccount;
    private double balance;

    public Client() {
       bankAccount = " ";
       balance = 0.0f;
    }

    public Client(String bankAccount, double balance) {
        this.bankAccount = bankAccount;
        this.balance = balance;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public boolean clientDeposit(double depositAmount) {
        if(depositAmount<=0) {
            return false;
        }
        if(depositAmount>0){
            balance = balance + depositAmount;
        }
        return true;
    }

    public boolean clientWithdraw(double withdrawAmount) {
        if (withdrawAmount <= 0) {
            return false;
        }
        if (withdrawAmount > balance) {
            return false;
        }

        balance -= withdrawAmount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

}
