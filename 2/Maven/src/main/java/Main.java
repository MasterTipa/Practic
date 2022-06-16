import by.maksimka.registry.controller.BasketController;
import by.maksimka.registry.controller.ClientControl;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        Input input = new Input();
        Output output = new Output();
        ClientControl clientControl = new ClientControl();
        while (true) {
            BasketController basketController = new BasketController();
            output.FirstMessage();
            int answer = input.IntScan();
            System.out.printf("Your numbers: %d\n", answer);
            switch (answer) {
                case 1:
                    clientControl.getAllClients();
                    break;
                case 2:
                    int tmpidgetControl = input.IntScan();
                    clientControl.getClient(tmpidgetControl);
                    break;
                case 3:
                    int tmpmaddClient = input.IntScan();
                    clientControl.addClient("sfgdhdasdsfsdfsdwadsdasdwadf", tmpmaddClient);
                    clientControl.getAllClients();
                    break;
                case 4:
                    int tmpidupdateClient = input.IntScan();
                    int tmpmoneyupdateClient = input.IntScan();
                    clientControl.updateClient(tmpidupdateClient, tmpmoneyupdateClient);
                    clientControl.getAllClients();
                    break;
                case 5:
                    int tmpdeleteClient = input.IntScan();
                    clientControl.deleteClient(tmpdeleteClient);
                    clientControl.getAllClients();
                    break;
            }
        }
       /* basketController.getAllBasket();
        basketController.addBasket(1);
        basketController.getAllBasket();
        basketController.getBasket(1);
        basketController.updateBasket(1,1);
        basketController.getAllBasket();
        basketController.deleteBasket(1);
        basketController.getAllBasket();*/
    }
}
