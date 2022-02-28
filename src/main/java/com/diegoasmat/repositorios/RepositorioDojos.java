package com.diegoasmat.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegoasmat.modelos.Dojo;

@Repository
public interface RepositorioDojos extends CrudRepository<Dojo, Long>{
	
	public List<Dojo> findAll();
	
}
