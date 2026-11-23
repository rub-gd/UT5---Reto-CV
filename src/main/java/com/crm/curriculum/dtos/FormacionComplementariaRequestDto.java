package com.crm.curriculum.dtos;

import java.time.LocalDate;

public record FormacionComplementariaRequestDto(
	String titulo,
	String lugarCursado,
	LocalDate inicioFecha,
	LocalDate finFecha
){}