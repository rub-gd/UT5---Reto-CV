package com.crm.curriculum.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Alumno", schema = "curriculum")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno")private Integer id_alumno;
	@Column(name = "nombre")private String nombre;
	@Column(name = "apellidos")private String apellidos;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "alumno")private Curriculum curriculum;
	
	public Alumno() {
		
	}

	public Integer getId_alumno() {
		return id_alumno;
	}

	public void setId_alumno(Integer id_alumno) {
		this.id_alumno = id_alumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Curriculum getCurriculum() {
		return curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}
}
