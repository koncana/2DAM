package com.alberto.firstApiSpringMysql.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.alberto.firstApiSpringMysql.entity.models.FirstApiSpringMysql;

public interface IFirstApiSpringMysqlDao extends CrudRepository<FirstApiSpringMysql, String>{

}
