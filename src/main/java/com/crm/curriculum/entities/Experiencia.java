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
@Table(name = "Experiencia", schema = "curriculum")
public class Experiencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_experiencia")private Integer id_experiencia;
	@Column(name = "puesto")private String puesto;
	@Column(name = "nombreEmpresa")private String nombreEmpresa;
	@Column(name = "inicioFecha")private LocalDate inicioFecha;
	@Column(name = "finFecha")private LocalDate finFecha;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curriculum")private Curriculum curriculum;
	
	public Experiencia() {

	}

	public Integer getId_experiencia() {
		return id_experiencia;
	}

	public void setId_experiencia(Integer id_experiencia) {
		this.id_experiencia = id_experiencia;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
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
