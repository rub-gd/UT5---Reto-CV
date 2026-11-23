package com.crm.curriculum.dtos;

import java.time.LocalDate;

public record FormacionResponseDto(
	Integer id_formacion,
	String titulo,
	String lugarCursado,
	LocalDate inicioFecha,
	LocalDate finFecha
){}
