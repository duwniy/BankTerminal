import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static Bank instance = new Bank();
    private List<Client> clientsList;
    private List<Employer> employerList;

    private Bank() {
        clientsList = new ArrayList<>();
        employerList = new ArrayList<>();
    }

    public void addClient(Client client) {
        clientsList.add(client);
    }

    public void addEmployer(Employer employer) {
        employerList.add(employer);
    }

    public Client findClientByLoginAndPassword(String login, String password){
        for(Client client : clientsList) {
            if (client.getLogin().equals(login) && client.getPassword().equals(password)) {
                return client;
            }
        }
        return null;
    }

    public Employer findEmployerByLoginAndPassword(String login, String password) {
       for(Employer employer : employerList) {
           if(employer.getLogin().equals(login) && employer.getPassword().equals(password)){
               return employer;
           }
       }
        return null;
    }

    public static Bank getInstance() {
        return instance;
    }

    public List<Client> getClientsList() {
        return clientsList;
    }


}
