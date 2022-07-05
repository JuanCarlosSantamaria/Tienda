package com.tienda.dao;

import com.tienda.domain.Credito;
import org.springframework.data.repository.CrudRepository; //crtl J, ctrl H

public interface CreditoDao extends CrudRepository<Credito, Long> {
    
}

