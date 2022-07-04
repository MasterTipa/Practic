package com.register.OrthodoxProject.Repository;

import com.register.OrthodoxProject.TableInfo.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasketRepository
    extends JpaRepository<Basket, Long>{
}
