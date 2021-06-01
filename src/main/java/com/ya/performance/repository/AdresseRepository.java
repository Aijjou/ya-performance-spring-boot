package com.ya.performance.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ya.performance.entities.Adresse;

/**
 * Home object for domain model class Adresse.
 * @see com.ya.performance.dao.Adresse
 * @author Ahmed KECELI
 */

@Repository
public interface AdresseRepository extends CrudRepository<Adresse, Long> {	
}
