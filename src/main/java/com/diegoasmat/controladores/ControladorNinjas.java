package com.diegoasmat.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diegoasmat.modelos.Dojo;
import com.diegoasmat.modelos.Ninja;
import com.diegoasmat.servicios.ServicioDojos;
import com.diegoasmat.servicios.ServicioNinjas;

@Controller
@RequestMapping("/ninjas")
public class ControladorNinjas {
	
	@Autowired
	private ServicioDojos servicioDojos;
	@Autowired
	private ServicioNinjas servicioNinjas;
	
	@GetMapping("/new")
	public String renderCreateNinjaForm(Model model, @ModelAttribute("ninja")Ninja ninja) {
		List<Dojo> dojos = servicioDojos.obtenerDojos();
		
		model.addAttribute("dojoList", dojos);
		
		return "/ninjas/new.jsp";
	}
	
	@PostMapping("")
	public String createNinja(Model model, @Valid @ModelAttribute("ninja")Ninja ninja, BindingResult result) {
		System.out.println(ninja.getDojo());
		if(result.hasErrors()) {
			List<Dojo> dojos = servicioDojos.obtenerDojos();
			
			model.addAttribute("dojoList", dojos);
			return "/ninjas/new.jsp";
		}
		servicioNinjas.crearNinja(ninja);
		return "redirect:/ninjas/new";
	}
}
