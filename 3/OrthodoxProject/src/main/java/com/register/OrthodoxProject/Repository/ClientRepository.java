package com.register.OrthodoxProject.Repository;

import com.register.OrthodoxProject.TableInfo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository
    extends JpaRepository<Client, Integer> {
}
