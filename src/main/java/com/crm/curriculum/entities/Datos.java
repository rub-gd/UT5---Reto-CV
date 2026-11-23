package com.crm.curriculum.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Datos", schema = "curriculum")
public class Datos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_datos")private Integer id_datos;
	@Column(name = "nombreCompleto", nullable = true)private String nombreCompleto;
	@Column(name = "contacto", nullable = false)private String contacto;
	@Column(name = "domicilio", nullable = false)private String domicilio;
	@Column(name = "sobreMi")private String sobreMi;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "datos")private Curriculum curriculum;
	
	public Datos() {
		
	}

	public Integer getId_datos() {
		return id_datos;
	}

	public void setId_datos(Integer id_datos) {
		this.id_datos = id_datos;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getSobreMi() {
		return sobreMi;
	}

	public void setSobreMi(String sobreMi) {
		this.sobreMi = sobreMi;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
}
