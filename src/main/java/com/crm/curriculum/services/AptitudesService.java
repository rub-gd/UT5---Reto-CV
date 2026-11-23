package com.crm.curriculum.services;

import java.util.List;

import com.crm.curriculum.dtos.AptitudesRequestDto;
import com.crm.curriculum.dtos.AptitudesResponseDto;

public interface AptitudesService {
	List<AptitudesResponseDto> listarTodasLasAptitudes();

	AptitudesResponseDto buscarAptitudesPorId(Integer id_aptitudes);

	AptitudesResponseDto crearAptitudes(AptitudesRequestDto creacion);

	AptitudesResponseDto actualizarAptitudesPorId(Integer id_aptitudes, AptitudesRequestDto datos_actualizados);

	void eliminarAptitudesPorId(Integer id_aptitudes);
}
