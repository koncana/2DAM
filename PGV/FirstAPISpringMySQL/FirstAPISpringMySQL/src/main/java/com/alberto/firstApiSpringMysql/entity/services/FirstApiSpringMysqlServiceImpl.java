package com.alberto.firstApiSpringMysql.entity.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alberto.firstApiSpringMysql.entity.dao.IFirstApiSpringMysqlDao;
import com.alberto.firstApiSpringMysql.entity.models.FirstApiSpringMysql;

@Service
public class FirstApiSpringMysqlServiceImpl implements IFirstApiSpringMysqlService {

	@Autowired
	private IFirstApiSpringMysqlDao firstApiSpringMysqlDao;

	@Override
	public List<FirstApiSpringMysql> getAllMods() {
		return (List<FirstApiSpringMysql>) firstApiSpringMysqlDao.findAll();
	}

	@Override
	public List<FirstApiSpringMysql> getMod(String name) {
		List<FirstApiSpringMysql> list = getAllMods();
		List<FirstApiSpringMysql> res = new ArrayList<>();
		
		for (FirstApiSpringMysql str : list) {
			if (str.getName().contains(name)) {
				res.add(str);
			}
		}
		return res;
	}

	@Override
	public void addMod(FirstApiSpringMysql firstApiSpringMysqlService) {
		firstApiSpringMysqlDao.save(firstApiSpringMysqlService);
	}

	@Override
	@Transactional
	public void updateMod(FirstApiSpringMysql firstApiSpringMysql, String name) {
		firstApiSpringMysqlDao.findById(name).ifPresent((x) -> {
			firstApiSpringMysqlDao.deleteById(name);
			firstApiSpringMysql.setName(firstApiSpringMysql.getName());
			firstApiSpringMysqlDao.save(firstApiSpringMysql);
		});
	}

	@Override
	public void removeMod(String name) {
		firstApiSpringMysqlDao.deleteById(name);
	}
}
