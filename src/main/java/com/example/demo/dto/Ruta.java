package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ruta")
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_xofer")
    @JsonIgnoreProperties("ruta")
	Xofer id_xofer;
	
	@OneToMany(mappedBy = "id_ruta", orphanRemoval = false)
    @JsonIgnoreProperties("id_ruta")
	private List<Viatge> viatge;

	public Ruta() {
		super();
	}

	public Ruta(int id, Xofer id_xofer, boolean externa, List<Viatge> viatge) {
		super();
		this.id = id;
		this.id_xofer = id_xofer;
		this.viatge = viatge;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Xofer getId_xofer() {
		return id_xofer;
	}

	public void setId_xofer(Xofer id_xofer) {
		this.id_xofer = id_xofer;
	}
	
	public List<Viatge> getViatge() {
		return viatge;
	}

	public void setViatge(List<Viatge> viatge) {
		this.viatge = viatge;
	}

	@Override
	public String toString() {
		return "Ruta [id=" + id + ", id_xofer=" + id_xofer
				+ ", anada=" + viatge
				+ "]";
	}
	
}
