package com.crm.curriculum.services;

import java.util.List;

import com.crm.curriculum.dtos.DatosRequestDto;
import com.crm.curriculum.dtos.DatosResponseDto;

public interface DatosService {
	List<DatosResponseDto> listarTodosLosDatos();

	DatosResponseDto buscarDatosPorId(Integer id_datos);

	DatosResponseDto crearDatos(DatosRequestDto creacion);

	DatosResponseDto actualizarDatosPorId(Integer id_datos, DatosRequestDto datos_actualizados);

	void eliminarDatosPorId(Integer id_datos);
}
