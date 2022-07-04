package com.register.OrthodoxProject.Repository;

import com.register.OrthodoxProject.TableInfo.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.lang.Override;
@Repository
public interface CafeRepository
    extends JpaRepository<Cafe, Long>{

    Optional<Cafe> findById(Long id);

}
