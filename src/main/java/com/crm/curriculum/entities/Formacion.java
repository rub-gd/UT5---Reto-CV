package com.crm.curriculum.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Formacion", schema = "curriculum")
public class Formacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_formacion")private Integer id_formacion;
	@Column(name = "titulo")private String titulo;
	@Column(name = "lugarCursado")private String lugarCursado;
	@Column(name = "inicioFecha")private LocalDate inicioFecha;
	@Column(name = "finFecha")private LocalDate finFecha;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curriculum")private Curriculum curriculum;
	
	public Formacion() {
		
	}

	public Integer getId_formacion() {
		return id_formacion;
	}

	public void setId_formacion(Integer id_formacion) {
		this.id_formacion = id_formacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getLugarCursado() {
		return lugarCursado;
	}

	public void setLugarCursado(String lugarCursado) {
		this.lugarCursado = lugarCursado;
	}

	public LocalDate getInicioFecha() {
		return inicioFecha;
	}

	public void setInicioFecha(LocalDate inicioFecha) {
		this.inicioFecha = inicioFecha;
	}

	public LocalDate getFinFecha() {
		return finFecha;
	}

	public void setFinFecha(LocalDate finFecha) {
		this.finFecha = finFecha;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
}
