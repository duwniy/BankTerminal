import java.util.List;
import java.util.Scanner;

public class Menu {
  public Bank bankMenu =  Bank.getInstance();
  Scanner scanner = new Scanner(System.in);

  public void clientMenu(Client client) {
      while(true) {
          System.out.println("1.Check Balance.");
          System.out.println("2.Deposit.");
          System.out.println("3.Withdraw.");
          System.out.println("4.Change Login");
          System.out.println("5.Exit.");
          int choice = scanner.nextInt();
          scanner.nextLine();
          switch (choice) {
              case 1:
                  System.out.println(client.getBalance());
                  break;
              case 2:
                  System.out.println("Deposit Amount: ");
                  double depositAmount = scanner.nextDouble();
                  client.clientDeposit(depositAmount);
                  break;
              case 3:
                  System.out.println("Withdraw Amount: ");
                  double withdrawAmount = scanner.nextDouble();
                  client.clientWithdraw(withdrawAmount);
                  break;
              case 4:
                  System.out.println("Login Change");
                  clientChangeLogin(client);
                  break;
              case 5:
                  return;
              default:
                  System.out.println("Error occurred, please check your connection.");
          }
      }
  }

  public void registerNewClient() {
      String name, login, password;
      double balance;

      System.out.println("Please write your full name: ");
      name = scanner.nextLine();
      if (!Validator.isNotEmpty(name)) {System.out.println("Name cannot be empty."); return;}

      System.out.println("Please write your login: ");
      login = scanner.nextLine();
      if(!Validator.isValidLogin(login)) {System.out.println("Not valid login!"); return;}

      System.out.println("Please write your password: ");
      password = scanner.nextLine();
      if(!Validator.isValidPassword(password)) {System.out.println("Incorrect password!"); return;}

      System.out.println("Write your balance: ");
      while (!scanner.hasNextDouble()) {
          System.out.println("Please enter a valid number for balance:");
          scanner.next();
      }
      balance = scanner.nextDouble();
      scanner.nextLine();
      if(!Validator.isPositiveAmount(balance)) {System.out.println("Only positive numbers can be entered!"); return;}

      Client client = new Client(name, login, password, balance);
      bankMenu.addClient(client);
      System.out.println("Client successfully registered!");
  }

    public void showClientsList() {
        List<Client> clients = bankMenu.getClientsList();

        if (clients.isEmpty()) {
            System.out.println("No registered clients.");
            return;
        }

        System.out.println("List of registered clients:");
        for (Client client : clients) {
            System.out.println("Name: " + client.getName() +
                    ", Login: " + client.getLogin() +
                    ", Balance: " + client.getBalance());
        }
    }



    public void moderatorMenu(Employer ignoredEmployer) {
        while (true) {
            System.out.println("1. Client Registration");
            System.out.println("2. Clients List");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    registerNewClient();
                    break;
                case 2:
                    showClientsList();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void clientLogin() {
        System.out.print("Enter your login: ");
        String login = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        Client client = bankMenu.findClientByLoginAndPassword(login, password);

        if (client != null) {
            System.out.println("Login successful!");
            clientMenu(client);
        } else {
            System.out.println("Incorrect login or password.");
        }
    }

    public void moderatorLogin() {
        System.out.println("Enter your login: ");
        String login = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();

        Employer employer = bankMenu.findEmployerByLoginAndPassword(login, password);

        if(employer != null) {
            System.out.println("Login successful!");
            moderatorMenu(employer);
        } else {
            System.out.println("Incorrect login or password.");
        }
  }

  public void showMainMenu() {
      while (true) {
          System.out.println("1.Client");
          System.out.println("2.Moderator");
          System.out.println("3.Exit");
          int choice = scanner.nextInt();
          switch (choice) {
              case 1:
                  clientLogin();
                  break;
              case 2:
                  moderatorLogin();
                  break;
              case 3:
                  System.exit(0) ;
                  break;
              default:
                  System.out.println("Error while logging...");
          }
      }
  }

    public boolean clientChangeLogin(Client client) {
        while (true) {
            System.out.println("Please write your full name: ");
            String name = scanner.nextLine();
            if (!name.equals(client.getName())) {
                System.out.println("Incorrect full name. Try again.");
                continue;
            }

            System.out.println("Please write your password: ");
            String password = scanner.nextLine();
            if (!password.equals(client.getPassword())) {
                System.out.println("Incorrect password. Try again.");
                continue;
            }

            while (true) {
                System.out.println("Please create a new login: ");
                String login = scanner.nextLine();
                if (!Validator.isValidLogin(login)) {
                    System.out.println("Not valid login! Try again.");
                    continue;
                }
                client.setLogin(login);
                System.out.println("Login successfully changed!");
                return true;
            }
        }
    }
}
