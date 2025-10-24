package com.apartamentos.apartamentos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apartamentos.apartamentos.models.propiedadImagenModel;

public interface IPropiedadImagenRepository extends JpaRepository<propiedadImagenModel, Long> {
    
}
