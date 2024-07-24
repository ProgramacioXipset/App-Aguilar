package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="viatge")
public class Viatge {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//Anada ultimo valor e incrementa desde id final de db
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_direccio_origen")
    @JsonIgnoreProperties({ "anada", "tornada", "avui_x_avui" })
	Direccio id_direccio_origen;
	
	@ManyToOne
	@JoinColumn(name = "id_direccio_desti")
    @JsonIgnoreProperties({ "anada", "tornada", "avui_x_avui" })
	Direccio id_direccio_desti;
	
	@Column(name = "comentari")//no hace falta si se llama igual
	private String comentari;
	
	@Column(name = "dia")//no hace falta si se llama igual
	private String dia;
	
	@ManyToOne
	@JoinColumn(name = "id_ruta")
    @JsonIgnoreProperties({ "viatge" })
	Ruta id_ruta;
	
	@Column(name = "externa")//no hace falta si se llama igual
	private String externa;
	
	@Column(name = "tipus")//no hace falta si se llama igual
	private Integer tipus;
	
	@Column(name = "data_inicial")//no hace falta si se llama igual
	private String data_inicial;
	
	@Column(name = "n_comanda")//no hace falta si se llama igual
	private String n_comanda;
	
	@Column(name = "amagat")//no hace falta si se llama igual
	private Integer amagat;
	
	@Column(name = "dividit")//no hace falta si se llama igual
	private Integer dividit;
	
	@Column(name = "ordre")//no hace falta si se llama igual
	private Integer ordre;

	public Viatge() {
		super();
	}

	public Viatge(int id, Direccio id_direccio_origen, Direccio id_direccio_desti, String comentari, String dia,
			Ruta id_ruta, String externa, Integer tipus, String data_inicial, String n_comanda, Integer amagat,
			Integer dividit, Integer ordre) {
		super();
		this.id = id;
		this.id_direccio_origen = id_direccio_origen;
		this.id_direccio_desti = id_direccio_desti;
		this.comentari = comentari;
		this.dia = dia;
		this.id_ruta = id_ruta;
		this.externa = externa;
		this.tipus = tipus;
		this.data_inicial = data_inicial;
		this.n_comanda = n_comanda;
		this.amagat = amagat;
		this.dividit = dividit;
		this.ordre = ordre;
	}

	@PrePersist
	protected void onCreate() {
		this.ordre = Math.toIntExact(this.id);
	}
	
	public Integer getAmagat() {
		return amagat;
	}

	public void setAmagat(Integer amagat) {
		this.amagat = amagat;
	}

	public String getN_comanda() {
		return n_comanda;
	}

	public void setN_comanda(String n_comanda) {
		this.n_comanda = n_comanda;
	}

	public String getData_inicial() {
		return data_inicial;
	}

	public void setData_inicial(String data_inicial) {
		this.data_inicial = data_inicial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Direccio getId_direccio_origen() {
		return id_direccio_origen;
	}

	public void setId_direccio_origen(Direccio id_direccio_origen) {
		this.id_direccio_origen = id_direccio_origen;
	}

	public Direccio getId_direccio_desti() {
		return id_direccio_desti;
	}

	public void setId_direccio_desti(Direccio id_direccio_desti) {
		this.id_direccio_desti = id_direccio_desti;
	}

	public String getComentari() {
		return comentari;
	}

	public void setComentari(String comentari) {
		this.comentari = comentari;
	}
	
	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Ruta getId_ruta() {
		return id_ruta;
	}

	public void setId_ruta(Ruta id_ruta) {
		this.id_ruta = id_ruta;
	}
	
	public String getExterna() {
		return externa;
	}

	public void setExterna(String externa) {
		this.externa = externa;
	}
	
	public Integer getTipus() {
		return tipus;
	}

	public void setTipus(Integer tipus) {
		this.tipus = tipus;
	}

	public Integer getDividit() {
		return dividit;
	}

	public void setDividit(Integer dividit) {
		this.dividit = dividit;
	}

	public Integer getOrdre() {
		return ordre;
	}

	public void setOrdre(Integer ordre) {
		this.ordre = ordre;
	}

	@Override
	public String toString() {
		return "Viatge [id=" + id + ", id_direccio_origen=" + id_direccio_origen + ", id_direccio_desti="
				+ id_direccio_desti + ", comentari=" + comentari + ", dia=" + dia + ", id_ruta=" + id_ruta
				+ ", externa=" + externa + ", tipus=" + tipus + ", data_inicial=" + data_inicial + ", n_comanda="
				+ n_comanda + ", amagat=" + amagat + ", dividit=" + dividit + ", ordre=" + ordre + "]";
	}

}
