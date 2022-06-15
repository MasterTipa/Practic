import by.maksimka.registry.controller.ClientControl;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        Input input = new Input();
        Output output = new Output();
        ClientControl clientControl = new ClientControl();
        output.FirstMessage();
        int answer = input.FirstMessage();
        System.out.printf("Your numbers: %d\n",answer);
        switch (answer) {
            case 1:
                clientControl.getAllClients();
                break;
            case 2:
                clientControl.getClient(2);
                break;
            case 3:
                clientControl.addClient("sfgdhdasdsfsdfsdwadsdasdwadf", 123);
                clientControl.getAllClients();
                break;
            case 4:
                clientControl.uppdateClient(1, 666);
                clientControl.getAllClients();
                break;
            case 5:
                clientControl.deleteClient("sfgdhdasdsfsdfsdwadsdasdwadf");
                clientControl.getAllClients();
                break;
        }
    }
}
