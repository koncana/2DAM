package com.alberto.prueba.entity.services;

import java.util.List;

import com.alberto.prueba.entity.models.Prueba;

public interface IPruebaService {

	public List<Prueba> getAllPruebas();
	
	public void addPrueba(Prueba prueba);
}
