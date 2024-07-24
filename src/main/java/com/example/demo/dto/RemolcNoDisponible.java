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
@Table(name="remolc_no_disponible")
public class RemolcNoDisponible {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_remolc")
    @JsonIgnoreProperties("id_remolc_no_disponible")
	Remolc id_remolc;
	
	@Column(name = "dia")//no hace falta si se llama igual
	private Date dia;

	public RemolcNoDisponible() {
		super();
	}

	public RemolcNoDisponible(int id, Remolc id_remolc, Date dia) {
		super();
		this.id = id;
		this.id_remolc = id_remolc;
		this.dia = dia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Remolc getId_remolc() {
		return id_remolc;
	}

	public void setId_remolc(Remolc id_remolc) {
		this.id_remolc = id_remolc;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "PodenEstarRemolc [id=" + id + ", id_remolc=" + id_remolc + ", dia=" + dia + "]";
	}
	
}
