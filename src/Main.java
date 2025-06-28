//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Bank bank = Bank.getInstance();
        Employer employer = new Employer("Moderator#1", "moder1@gmail.com", "qwwertylang11");
        bank.addEmployer(employer);

        Menu menu = new Menu();
        menu.showMainMenu();

    }
}