package com.apartamentos.apartamentos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apartamentos.apartamentos.models.propiedadesModel;

public interface IPropiedadesRepository extends JpaRepository<propiedadesModel, Long> {
    
}
