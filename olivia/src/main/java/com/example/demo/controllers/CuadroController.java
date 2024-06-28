package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entities.Cuadro;
import com.example.demo.exceptions.MiServiceException;
import com.example.demo.services.CuadroService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = { "/", "/cuadros" })

public class CuadroController {
	@Autowired
	private CuadroService cuadroService;

	@GetMapping("/cuadros")
	public String listarCuadros(Model model) throws Exception {
		log.info("[listarCuadros]");
		log.debug("[listarCuadros]");
		model.addAttribute("cuadros", cuadroService.findAll());
		return "cuadros";
	}

	@GetMapping("/nuevo")
	public String mostrarFormularioNuevo(Model model) throws Exception {
		log.info("[mostrarFormularioNuevo]");
		model.addAttribute("cuadro", new Cuadro());
		// Revisar otra forma
		model.addAttribute("tiposCuadro", Cuadro.TipoCuadro.values());
		return "nuevoCuadrito";
	}

	@PostMapping("/guardar")
	public String guardarCuadro(@ModelAttribute Cuadro cuadro) throws Exception {
		log.info("[guardarCuadros]");
		
		
		

		cuadroService.save(cuadro);
		return "redirect:/cuadros";

	}

}
