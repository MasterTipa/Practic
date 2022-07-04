package com.register.OrthodoxProject.Services;

import com.register.OrthodoxProject.Repository.ProviderRepository;
import com.register.OrthodoxProject.TableInfo.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ProviderService {
    private final ProviderRepository providerRepository;
@Autowired
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getProvider() {
        return providerRepository.findAll();
    }

    public void addNewProvider(Provider provider) {
        providerRepository.save(provider);
        System.out.println("provider:"+provider.getId()+"is added");
    }

    public void deleteProvider(Long id) {
        boolean exists = providerRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Provider with id: "+id+" does not exists");
        }else{
            providerRepository.deleteById(id);
            System.out.println("Provider with id: "+id+" was delete");
        }
    }

    public void updateProvider(Long id, String name) {
    Provider provider = providerRepository.findById(id)
            .orElseThrow(()-> new IllegalStateException("Provider with id: "+id+" does not exists"));
        if (name!=null && name.length()>0 && !Objects.equals(provider.getName(), name)){
            provider.setName(name);
    }
}
}
