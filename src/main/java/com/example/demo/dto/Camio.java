package com.example.demo.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="camio")
public class Camio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "matricula")//no hace falta si se llama igual
	private String matricula;
	
	@Column(name = "marca_model")//no hace falta si se llama igual
	private String marca_model;
	
	@OneToMany(mappedBy = "id_camio", orphanRemoval = false)
    @JsonIgnoreProperties("id_camio")
	private List<Xofer> xofer;
	
	@OneToMany(mappedBy = "id_camio", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("camio")
	private List<CamioNoDisponible> camio_no_disponible;

	public Camio() {
		super();
	}

	public Camio(int id, String matricula, String marca_model, List<Xofer> xofer,
			List<CamioNoDisponible> camio_no_disponible) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca_model = marca_model;
		this.xofer = xofer;
		this.camio_no_disponible = camio_no_disponible;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca_model() {
		return marca_model;
	}

	public void setMarca_model(String marca_model) {
		this.marca_model = marca_model;
	}

	public List<Xofer> getXofer() {
		return xofer;
	}

	public void setXofer(List<Xofer> xofer) {
		this.xofer = xofer;
	}

	public List<CamioNoDisponible> getCamio_no_disponible() {
		return camio_no_disponible;
	}

	public void setCamio_no_disponible(List<CamioNoDisponible> camio_no_disponible) {
		this.camio_no_disponible = camio_no_disponible;
	}

	@Override
	public String toString() {
		return "Camio [id=" + id + ", matricula=" + matricula + ", marca_model=" + marca_model + ", xofer=" + xofer
				+ ", camio_no_disponible=" + camio_no_disponible + "]";
	}
	
}
