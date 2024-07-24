package com.example.demo.dto;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="camio_no_disponible")
public class CamioNoDisponible {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
	private int id;
	
    @ManyToOne
    @JoinColumn(name = "id_camio")
    @JsonIgnoreProperties("camio_no_disponible")
	Camio id_camio;
	
	@Column(name = "dia")//no hace falta si se llama igual
	private Date dia;

	public CamioNoDisponible() {
		super();
	}

	public CamioNoDisponible(int id, Camio id_camio, Date dia) {
		super();
		this.id = id;
		this.id_camio = id_camio;
		this.dia = dia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Camio getCamio() {
		return id_camio;
	}

	public void setCamio(Camio id_camio) {
		this.id_camio = id_camio;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "CamioNoDisponible [id=" + id + ", id_camio=" + id_camio + ", dia=" + dia + "]";
	}
	
}
