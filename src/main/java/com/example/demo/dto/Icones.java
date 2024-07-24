package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="icones")
public class Icones {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Anada ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "icona")//no hace falta si se llama igual
	private String icona;
	
	@Column(name = "data")//no hace falta si se llama igual
	private String data;

	@ManyToOne
	@JoinColumn(name = "id_xofer")
    @JsonIgnoreProperties("icones")
	Xofer id_xofer;

	public Icones(int id, String icona, String data, Xofer id_xofer) {
		super();
		this.id = id;
		this.icona = icona;
		this.data = data;
		this.id_xofer = id_xofer;
	}

	public Icones() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIcona() {
		return icona;
	}

	public void setIcona(String icona) {
		this.icona = icona;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Xofer getId_xofer() {
		return id_xofer;
	}

	public void setId_xofer(Xofer id_xofer) {
		this.id_xofer = id_xofer;
	}

	@Override
	public String toString() {
		return "Icones [id=" + id + ", icona=" + icona + ", data=" + data + ", id_xofer=" + id_xofer + "]";
	}
	
}
