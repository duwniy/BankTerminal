import java.sql.SQLOutput;

public class Client extends User{
    private double balance;

    public Client() {
       balance = 0.0f;
    }

    public Client(String name, String login, String password, double balance) {
        super(name, login, password);
        this.balance = balance;
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
