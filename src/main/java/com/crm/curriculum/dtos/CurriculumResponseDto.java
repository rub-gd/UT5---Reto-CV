package com.crm.curriculum.dtos;

import java.util.List;

import com.crm.curriculum.entities.Aptitudes;
import com.crm.curriculum.entities.Experiencia;
import com.crm.curriculum.entities.Formacion;
import com.crm.curriculum.entities.FormacionComplementaria;

public record CurriculumResponseDto(
	Integer id_curriculum,
	Integer id_datos,
	List<Experiencia> experiencia,
	List<Formacion> formacion,
	List<Aptitudes> aptitudes,
	List<FormacionComplementaria> formacionComplementaria,
	Integer id_alumno
) {}