package com.alberto.firstApiSpringMysql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alberto.firstApiSpringMysql.entity.models.FirstApiSpringMysql;
import com.alberto.firstApiSpringMysql.entity.services.IFirstApiSpringMysqlService;

@CrossOrigin(origins = "*")
@RestController
public class FirstApiSpringMysqlController {

	@Autowired
	private IFirstApiSpringMysqlService firstApiSpringMysqlService;

	@GetMapping("/api/getMods")
	private List<FirstApiSpringMysql> getMods() {
		return firstApiSpringMysqlService.getAllMods();
	}

	@GetMapping("/api/getMod/{name}")
	public List<FirstApiSpringMysql> getOne(@PathVariable(value = "name") String name) {
		if (name == null || name.equals("") || name.matches(".*\\d.*")) {
			System.out.println("Please, write the url name input properly");
		}
		return firstApiSpringMysqlService.getMod(name);

	}

	@PostMapping("/api/addMod")
	private void addFirstApiSpringMysqlPost(FirstApiSpringMysql firstApiSpringMysql) {
		if (firstApiSpringMysql.getName().matches(".*\\d.*")) {
			System.out.println("Please, write the url name input properly");
		} else {
			firstApiSpringMysqlService.addMod(firstApiSpringMysql);
		}
	}

	@PutMapping("/api/updateMod/{name}")
	private void updateFirstApiSpringMysqlPut(FirstApiSpringMysql firstApiSpringMysql,
			@PathVariable(value = "name") String name) {
		if (name == null || name.equals("") || name.matches(".*\\d.*")
				|| firstApiSpringMysql.getName().matches(".*\\d.*")) {
			if (firstApiSpringMysql.getName().matches(".*\\d.*")) {
				System.out.println("Please, write the body name input properly");
			} else {
				System.out.println("Please, write the url name input properly");
			}
		} else {
			try {
				firstApiSpringMysqlService.updateMod(firstApiSpringMysql, name);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	@DeleteMapping("/api/removeMod/{name}")
	private void removeFirstApiSpringMysqlDelete(@PathVariable(value = "name") String name) {
		if (name == null || name.equals("") || name.matches(".*\\d.*")) {
			System.out.println("Please, write the url name input properly");
		} else {
			firstApiSpringMysqlService.removeMod(name);
		}
	}
}
