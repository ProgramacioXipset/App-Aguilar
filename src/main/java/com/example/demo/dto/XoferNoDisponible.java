package com.example.demo.dto;

import java.sql.Date;

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
@Table(name="xofer_no_disponible")
public class XoferNoDisponible {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_xofer")
    @JsonIgnoreProperties("xofer_no_disponible")
	Xofer id_xofer;
	
	@Column(name = "dia")//no hace falta si se llama igual
	private Date dia;

	public XoferNoDisponible() {
		super();
	}

	public XoferNoDisponible(int id, Xofer id_xofer, Date dia) {
		super();
		this.id = id;
		this.id_xofer = id_xofer;
		this.dia = dia;
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

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "XoferNoDisponible [id=" + id + ", id_xofer=" + id_xofer + ", dia=" + dia + "]";
	}
	
}
