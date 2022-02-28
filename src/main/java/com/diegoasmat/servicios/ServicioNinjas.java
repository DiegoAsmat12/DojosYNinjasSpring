package com.diegoasmat.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegoasmat.modelos.Ninja;
import com.diegoasmat.repositorios.RepositorioNinjas;

@Service
public class ServicioNinjas {

	@Autowired
	private RepositorioNinjas repositorioNinjas;
	
	public List<Ninja> obtenerNinjas(){
		return repositorioNinjas.findAll();
	}
	
	public Ninja crearNinja(Ninja ninja) {
		return repositorioNinjas.save(ninja);
	}
	
	public Ninja obtenerNinjaPorId(Long id) {
		Optional<Ninja> ninja= repositorioNinjas.findById(id);
		if(ninja.isPresent()) {
			return ninja.get();
		}
		return null;
	}
	
	public Ninja actualizarNinja(Ninja ninja) {
		Ninja ninjaObtenido = obtenerNinjaPorId(ninja.getId());
		if(ninjaObtenido!=null) {
			return repositorioNinjas.save(ninja);
		}
		return null;
	}
	
	public void borrarNinja(Long id) {
		repositorioNinjas.deleteById(id);
	}
}
