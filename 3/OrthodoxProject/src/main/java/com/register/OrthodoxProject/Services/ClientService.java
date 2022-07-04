package com.register.OrthodoxProject.Services;
import com.register.OrthodoxProject.Repository.ClientRepository;
import com.register.OrthodoxProject.TableInfo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
@Service
public class ClientService {
    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getClient(){return clientRepository.findAll();}
    public void addNewClient(Client client){
        clientRepository.save(client);
        System.out.println("client:"+client.getId()+"is added");
    }
    public void deleteClient(Long id){
        boolean exists = clientRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException("Client with id: "+id+" does not exists");
        }
        else{
            clientRepository.deleteById(id);
            System.out.println("Client with id: "+id+" was delete");
        }
    }

    public void updateClient(Long id, String name, Double money){
        Client client = clientRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Client with id: "+id+" does not exists"));
        if (name!=null && name.length()>0 && !Objects.equals(client.getName(), name)){
            client.setName(name);
        }
        if(money!=null && money>0 &&
                client.getMoney()!=money
        ){
            client.setMoney(money);
        }
    }

}
