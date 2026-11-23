package com.crm.curriculum.entities;

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
@Table(name = "Aptitutdes")
public class Aptitudes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aptitudes")private Integer id_aptitudes;

	@Column(name = "nombreAptitud")private String nombreAptitud;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_curriculum")private Curriculum curriculum;
	
	public Aptitudes() {
		
	}

	public Integer getId_aptitudes() {
		return id_aptitudes;
	}

	public void setId_aptitudes(Integer id_aptitudes) {
		this.id_aptitudes = id_aptitudes;
	}

	public String getNombreAptitud() {
		return nombreAptitud;
	}

	public void setNombreAptitud(String nombreAptitud) {
		this.nombreAptitud = nombreAptitud;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
}
