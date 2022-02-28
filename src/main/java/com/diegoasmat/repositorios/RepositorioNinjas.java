package com.diegoasmat.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegoasmat.modelos.Ninja;

@Repository
public interface RepositorioNinjas extends CrudRepository<Ninja, Long>{

	public List<Ninja> findAll();
	
}
