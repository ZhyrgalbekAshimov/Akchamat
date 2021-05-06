package kg.megacom;

import kg.megacom.models.Client;
import kg.megacom.services.ClientService;

public class Main {

    public static void main(String[] args) {

        ClientService clientService = ClientService.INSTANCE;


        //***Получить деньги***

        //Введите номер телефона:
            String phone = "+996555102030";
        //Введите ID card:
            String idCard = "ID0775048";
        //Выберите один вариант получения кредита:
            // 1. 1000 на 1 день + 10%
            // 2. 2000 на 7 дней + 15%
            // 3. 5000 на 30 дней + 20%
            int creditOption = 1;

        Client client = clientService.findOrCreateClient(phone, idCard);
        switch (clientService.setCreditForClient(client, creditOption)){
            case 1:
                System.out.println("У клиента уже имеется кредит. Операция невозможна");
                break;
            case 2:
                System.out.println("Клиент заблокирован. Операция невозможна");
                break;
            case 0:
                System.out.println("Кредит успешно загрегистрирован на клиента");
                break;
        }



        // ***Погасить долг***

        //Введите номер телефона:
        phone = "+996555102030";
        //Введите ID card:
        idCard = "ID0775048";
        // Введите сумму погашения кредита
        int amount = 500;

        if(clientService.payCredit(phone, idCard, amount)) {
            System.out.println("Сумма погашена");
        }else {
            System.out.println("Клиент не найден");
        }

    }
}
