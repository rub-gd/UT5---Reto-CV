package com.crm.curriculum.services;

import java.util.List;

import com.crm.curriculum.dtos.ExperienciaRequestDto;
import com.crm.curriculum.dtos.ExperienciaResponseDto;

public interface ExperienciaService {
	List<ExperienciaResponseDto> listarTodasLasExperiencias();

	ExperienciaResponseDto buscarExperienciaPorId(Integer id_experiencia);

	ExperienciaResponseDto crearExperiencia(ExperienciaRequestDto creacion);

	ExperienciaResponseDto actualizarExperienciaPorId(Integer id_experiencia, ExperienciaRequestDto datos_actualizados);

	void eliminarExperienciaPorId(Integer id_experiencia);
}
