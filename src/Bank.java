public class Bank {
    private static Bank instance = new Bank();

    private Bank() {

    }

    public static Bank getInstance() {
        return instance;
    }


}
