package com.register.OrthodoxProject.Repository;

import com.register.OrthodoxProject.TableInfo.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository
        extends JpaRepository<Provider, Integer> {
}
