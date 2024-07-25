package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="grua")
public class Grua {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "grua", orphanRemoval = false)
    @JsonIgnoreProperties("grua")
	private List<Tarea> tarea;

	public Grua() {
		super();
	}

	public Grua(int id, String nombre, List<Tarea> tarea) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tarea = tarea;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tarea> getTarea() {
		return tarea;
	}

	public void setTarea(List<Tarea> tarea) {
		this.tarea = tarea;
	}

	@Override
	public String toString() {
		return "Grua [id=" + id + ", nombre=" + nombre + ", tarea=" + tarea + "]";
	}
}
