package com.register.OrthodoxProject.Controllers;
import com.register.OrthodoxProject.Services.ClientService;
import com.register.OrthodoxProject.TableInfo.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
@RestController
@RequestMapping(path = "client")
public class ClientController {
    private final ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService){this.clientService=clientService;}
    @GetMapping
    public List<Client> getClient(){return clientService.getClient();}
    @PostMapping
    public void registerNewClient(@RequestBody Client client){
        clientService.addNewClient(client);
    }
    @DeleteMapping(path = "{id}")
    public void deleteClient(
            @PathVariable("id") Long id){
        clientService.deleteClient(id);
    }
    @Transactional
    @PutMapping(path = "{id}")
    public void updateClient(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Double money)
    {
        clientService.updateClient(id, name, money);
    }


}
