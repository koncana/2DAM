package com.alberto.prueba.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alberto.prueba.entity.dao.IPruebaDao;
import com.alberto.prueba.entity.models.Prueba;

@Service
public class PruebaServiceImpl implements IPruebaService{
	
	@Autowired
	private IPruebaDao pruebaDao;

	@Override
	public List<Prueba> getAllPruebas() {
		return (List<Prueba>) pruebaDao.findAll();
	}

	@Override
	public void addPrueba(Prueba prueba) {
		pruebaDao.save(prueba);
	}
}
