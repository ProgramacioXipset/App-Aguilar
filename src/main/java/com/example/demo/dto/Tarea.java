package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="tarea")
public class Tarea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Anada ultimo valor e incrementa desde id final de db
	private int id;
	
	@Column(name = "fecha_inicio")//no hace falta si se llama igual
	private LocalDateTime fecha_inicio;
	
	@Column(name = "fecha_final")//no hace falta si se llama igual
	private LocalDateTime fecha_final;
	
	@Column(name = "duracion")//no hace falta si se llama igual
	private Integer duracion;
	
	@ManyToOne
	@JoinColumn(name = "usuario")
    @JsonIgnoreProperties({ "tarea" })
	Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "grua")
    @JsonIgnoreProperties({ "tarea" })
	Grua grua;
	
	@ManyToOne
	@JoinColumn(name = "cliente")
    @JsonIgnoreProperties({ "tarea" })
	Cliente cliente;
	
	@Column(name = "nota")//no hace falta si se llama igual
	private String nota;

	public Tarea() {
		super();
	}

	public Tarea(int id, LocalDateTime fecha_inicio, LocalDateTime fecha_final, Integer duracion, Usuario usuario,
			Grua grua, Cliente cliente, String nota) {
		super();
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.duracion = duracion;
		this.usuario = usuario;
		this.grua = grua;
		this.cliente = cliente;
		this.nota = nota;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDateTime fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDateTime getFecha_final() {
		return fecha_final;
	}

	public void setFecha_final(LocalDateTime fecha_final) {
		this.fecha_final = fecha_final;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grua getGrua() {
		return grua;
	}

	public void setGrua(Grua grua) {
		this.grua = grua;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", fecha_inicio=" + fecha_inicio + ", fecha_final=" + fecha_final + ", duracion="
				+ duracion + ", usuario=" + usuario + ", grua=" + grua + ", cliente=" + cliente + ", nota=" + nota
				+ "]";
	}
}
