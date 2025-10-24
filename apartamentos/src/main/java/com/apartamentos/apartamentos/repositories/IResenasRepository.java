package com.apartamentos.apartamentos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apartamentos.apartamentos.models.resenaModel;

public interface IResenasRepository extends JpaRepository<resenaModel, Long> {

    
} 
