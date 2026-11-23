package com.crm.curriculum.dtos;

import java.time.LocalDate;

public record FormacionComplementariaResponseDto(
	Integer id_formacionComplementaria,
	String titulo,
	String lugarCursado,
	LocalDate inicioFecha,
	LocalDate finFecha
){}