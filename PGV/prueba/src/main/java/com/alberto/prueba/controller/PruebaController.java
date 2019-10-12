package com.alberto.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.alberto.prueba.entity.models.Prueba;
import com.alberto.prueba.entity.services.IPruebaService;

@RestController
public class PruebaController {
	
	@Autowired
	private IPruebaService pruebaService;
	

	@GetMapping("/api/pruebas")
	private List<Prueba> getPruebas(){
		return pruebaService.getAllPruebas();
	}
	
	@PostMapping("/api/prueba")
	private void addPruebaPost(Prueba prueba) {
		pruebaService.addPrueba(prueba);
	}
}
