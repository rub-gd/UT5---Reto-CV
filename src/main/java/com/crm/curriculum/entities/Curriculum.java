package com.crm.curriculum.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name = "Curriculum", schema = "curriculum")
public class Curriculum {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_curriculum")private Integer id_curriculum;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_datos")private Datos datos;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")private List<Experiencia> experiencia;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")private List<Formacion> formacion;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")private List<Aptitudes> aptitudes;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "curriculum")private List<FormacionComplementaria> formacionComplementaria;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_alumno") private Alumno alumno;
	
	public Curriculum() {
		
	}

	public Integer getId_curriculum() {
		return id_curriculum;
	}

	public void setId_curriculum(Integer id_curriculum) {
		this.id_curriculum = id_curriculum;
	}

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	public List<Experiencia> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(List<Experiencia> experiencia) {
		this.experiencia = experiencia;
	}

	public List<Formacion> getFormacion() {
		return formacion;
	}

	public void setFormacion(List<Formacion> formacion) {
		this.formacion = formacion;
	}

	public List<Aptitudes> getAptitudes() {
		return aptitudes;
	}

	public void setAptitudes(List<Aptitudes> aptitudes) {
		this.aptitudes = aptitudes;
	}

	public List<FormacionComplementaria> getFormacionComplementaria() {
		return formacionComplementaria;
	}

	public void setFormacionComplementaria(List<FormacionComplementaria> formacionComplementaria) {
		this.formacionComplementaria = formacionComplementaria;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
}
