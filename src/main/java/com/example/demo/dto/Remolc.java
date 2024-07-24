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
@Table(name="remolc")
public class Remolc {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "matricula")//no hace falta si se llama igual
	private String matricula;
	
	@OneToMany(mappedBy = "id_remolc", orphanRemoval = false)
    @JsonIgnoreProperties("id_remolc")
	private List<Xofer> xofer;
	
	@OneToMany(mappedBy = "id_remolc", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("id_remolc")
	private List<RemolcNoDisponible> poden_estar_remolc;

	public Remolc() {
		super();
	}

	public Remolc(int id, String matricula, List<Xofer> xofer, List<RemolcNoDisponible> poden_estar_remolc) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.xofer = xofer;
		this.poden_estar_remolc = poden_estar_remolc;
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

	public List<Xofer> getXofer() {
		return xofer;
	}

	public void setXofer(List<Xofer> xofer) {
		this.xofer = xofer;
	}

	public List<RemolcNoDisponible> getPoden_estar_remolc() {
		return poden_estar_remolc;
	}

	public void setPoden_estar_remolc(List<RemolcNoDisponible> poden_estar_remolc) {
		this.poden_estar_remolc = poden_estar_remolc;
	}

	@Override
	public String toString() {
		return "Remolc [id=" + id + ", matricula=" + matricula + ", xofer=" + xofer + ", poden_estar_remolc="
				+ poden_estar_remolc + "]";
	}
	
}
