package com.diegoasmat.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegoasmat.modelos.Dojo;
import com.diegoasmat.servicios.ServicioDojos;

@Controller
@RequestMapping("/dojos")
public class ControladorDojos {

	@Autowired
	private ServicioDojos servicioDojos;
	
	@GetMapping("/new")
	public String renderCreateDojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "dojos/new.jsp";
	}
	
	@PostMapping("")
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "dojos/new.jsp";
		}
		
		servicioDojos.crearDojo(dojo);
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/{id}")
	public String renderDojo(Model model, @PathVariable("id")Long id) {
		Dojo dojo = servicioDojos.obtenerDojoPorId(id);
		
		model.addAttribute("dojo", dojo);
		
		return "/dojos/dojo.jsp";
	}
}
