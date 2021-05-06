package kg.megacom.services;

import kg.megacom.models.Client;
import kg.megacom.services.impl.ClientServiceImpl;

public interface ClientService {

    ClientService INSTANCE = new ClientServiceImpl();

    Client findOrCreateClient(String phone, String idCard);
    int setCreditForClient(Client client, int creditOption);
    boolean payCredit(String phone, String idCard, double amount);
    void blockClient();


}
