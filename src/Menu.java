import java.util.Scanner;

public class Menu {
  public Bank bankMenu =  Bank.getInstance();
  Scanner scanner = new Scanner(System.in);


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


}
