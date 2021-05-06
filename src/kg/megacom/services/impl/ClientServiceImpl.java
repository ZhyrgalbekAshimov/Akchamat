package kg.megacom.services.impl;

import kg.megacom.models.Client;
import kg.megacom.models.Credit;
import kg.megacom.services.ClientService;

import java.util.ArrayList;

public class ClientServiceImpl implements ClientService {

    private ArrayList<Client> clients = new ArrayList<>();

    @Override
    public Client findOrCreateClient(String phone, String idCard) {

        for (Client client : clients) {
            if (client.getPhone().equals(phone) && client.getIdCard().equals(idCard)) {
                return client;
            }
        }

        Client client = new Client(phone, idCard);
        clients.add(client);

        return client;

    }

    public int setCreditForClient(Client client, int creditOption){
        for (Client cl : clients) {
            if (cl.getCredits().size()!=0) return 1;
            if (cl.isBlocked()) return 2;
            if (client==cl && !cl.isBlocked() && cl.getCredits().size()==0) {
                switch (creditOption){
                    case 1: cl.getCredits().add(new Credit(1000, 10, 1));
                        return 0;
                    case 2: cl.getCredits().add(new Credit(2000, 15, 7));
                        return 0;
                    case 3: cl.getCredits().add(new Credit(5000, 20, 30));
                        return 0;
                }
            }
        }
        return 3;
    }

    public boolean payCredit(String phone, String idCard, double amount){
        for (Client client : clients) {
            if (client.getPhone().equals(phone) && client.getIdCard().equals(idCard)) {
                if (client.getCredits().size()==1){
                    client.getCredits().get(0).setSumm(client.getCredits().get(0).getSumm()-amount);
                    return true;
                }
            }
        }
        return false;

    }



    @Override
    public void blockClient() {

    }
}
