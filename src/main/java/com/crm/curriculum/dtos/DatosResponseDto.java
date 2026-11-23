package com.crm.curriculum.dtos;

public record DatosResponseDto(
	Integer id_datos,
	String nombreCompleto,
	String contacto,
	String domicilio,
	String sobreMi
){}
