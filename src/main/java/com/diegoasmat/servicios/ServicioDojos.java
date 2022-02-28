package com.diegoasmat.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegoasmat.modelos.Dojo;
import com.diegoasmat.repositorios.RepositorioDojos;

@Service
public class ServicioDojos {
	
	@Autowired
	private RepositorioDojos repositorioDojos;
	
	public List<Dojo> obtenerDojos(){
		return repositorioDojos.findAll();
	}
	
	public Dojo crearDojo(Dojo dojo) {
		return repositorioDojos.save(dojo);
	}
	
	public Dojo obtenerDojoPorId(Long id) {
		Optional<Dojo> dojo = repositorioDojos.findById(id);
		if(dojo.isPresent()) {
			return dojo.get();
		}
		return null;
		
	}
	
	public Dojo actualizarDojo(Dojo dojo) {
		Dojo dojoObtenido = obtenerDojoPorId(dojo.getId());
		if(dojoObtenido!=null) {
			return repositorioDojos.save(dojo);
		}
		return null;
	}
	
	public void borrarDojo(Long id) {
		repositorioDojos.deleteById(id);
	}
	
}
