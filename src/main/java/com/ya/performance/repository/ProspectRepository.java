package com.ya.performance.repository;


import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ya.performance.entities.Prospect;

/**
 * Home object for domain model class Prospect.
 * @see com.ya.performance.entities.Prospect
 * @author Ahmed KECELI
 */

@Repository
public interface ProspectRepository extends CrudRepository<Prospect, Serializable>{
	
}
