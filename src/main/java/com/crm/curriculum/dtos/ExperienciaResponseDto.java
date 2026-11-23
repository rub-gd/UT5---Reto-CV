package com.crm.curriculum.dtos;

import java.time.LocalDate;

public record ExperienciaResponseDto(
	Integer id_experiencia,
	String puesto,
	String nombreEmpresa,
	LocalDate inicioFecha,
	LocalDate finFecha
){}
