package com.register.OrthodoxProject.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.register.OrthodoxProject.Services.ProviderService;
import com.register.OrthodoxProject.TableInfo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "provider")
public class ProviderController {
    private final ProviderService providerService;
    @Autowired
    public ProviderController(ProviderService providerService){
        this.providerService=providerService;
    }
    @GetMapping
    public List<Provider> getProvider(){
        return providerService.getProvider();
    }
    @PostMapping
    public void registerNewProvider(@RequestBody Provider provider){
        providerService.addNewProvider(provider);
    }
    @DeleteMapping(path = "{id}")
    public void deleteProvider(
            @PathVariable("id") Long id) {
        providerService.deleteProvider(id);
    }
    @Transactional
    @PutMapping(path = "{id}")
    public void updateProvider(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name
    ){
        providerService.updateProvider(id, name);
    }

}
