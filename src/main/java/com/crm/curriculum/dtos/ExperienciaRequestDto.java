package com.crm.curriculum.dtos;

import java.time.LocalDate;

public record ExperienciaRequestDto(
	String puesto,
	String nombreEmpresa,
	LocalDate inicioFecha,
	LocalDate finFecha
){}