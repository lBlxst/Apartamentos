package com.apartamentos.apartamentos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apartamentos.apartamentos.models.mensajesModel;

public interface IMensajesRepository extends JpaRepository<mensajesModel, Long> {
    
}
