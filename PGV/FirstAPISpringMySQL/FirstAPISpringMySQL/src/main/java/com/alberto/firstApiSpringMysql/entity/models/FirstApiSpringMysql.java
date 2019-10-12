package com.alberto.firstApiSpringMysql.entity.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity (name="mods")
public class FirstApiSpringMysql implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column
	private String name;
	
	
	@Column
	@NotNull
	private int quantity;
	
	public FirstApiSpringMysql() {}

	public FirstApiSpringMysql(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}	
}
