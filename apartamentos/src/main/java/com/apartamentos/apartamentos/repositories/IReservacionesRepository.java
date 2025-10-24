package com.apartamentos.apartamentos.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.apartamentos.apartamentos.models.reservacionesModel;

public interface IReservacionesRepository extends JpaRepository<reservacionesModel, Long> {
    
}
