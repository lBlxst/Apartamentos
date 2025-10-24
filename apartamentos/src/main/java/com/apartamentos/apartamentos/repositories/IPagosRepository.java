package com.apartamentos.apartamentos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apartamentos.apartamentos.models.pagosModel;

public interface IPagosRepository extends JpaRepository<pagosModel, Long> {
    
}
