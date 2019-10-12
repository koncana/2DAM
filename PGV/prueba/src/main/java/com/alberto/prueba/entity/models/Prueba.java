package com.alberto.prueba.entity.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity (name="pruebas")
public class Prueba implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Si se llama igual no hace falta hacer la referencia
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Forma en la que recoge el id
	private long id;
	
	@Column
	@NotEmpty // Como el not null pero también para vacío
	private String model;
	
	@Column(name = "model_price")
	private float price;

	public Prueba() {} // Hace falta hacer un constructor vacío
	
	public Prueba(long id, String model, float price) {
		super();
		this.id = id;
		this.model = model;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
