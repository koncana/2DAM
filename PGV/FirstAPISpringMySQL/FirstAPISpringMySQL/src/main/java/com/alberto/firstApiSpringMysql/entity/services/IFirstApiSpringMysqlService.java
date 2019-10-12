package com.alberto.firstApiSpringMysql.entity.services;

import java.util.List;

import com.alberto.firstApiSpringMysql.entity.models.FirstApiSpringMysql;

public interface IFirstApiSpringMysqlService {		

	public List<FirstApiSpringMysql> getAllMods();
	
	public List<FirstApiSpringMysql> getMod(String name);
	
	public void addMod(FirstApiSpringMysql firstApiSpringMysql);
	
	public void updateMod(FirstApiSpringMysql firstApiSpringMysql, String name);
	
	public void removeMod(String name);
}
