package com.apartamentos.apartamentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apartamentos.apartamentos.models.usuariosModel;


public interface IUsuariosRepository extends JpaRepository<usuariosModel, Long> {
    
}
