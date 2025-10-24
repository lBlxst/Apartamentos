package com.apartamentos.apartamentos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apartamentos.apartamentos.models.disponibilidadModel;

public interface IDisponibilidadRepository extends JpaRepository<disponibilidadModel, Long> {
    
}
