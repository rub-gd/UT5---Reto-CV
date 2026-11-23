package com.crm.curriculum.services;

import java.util.List;

import com.crm.curriculum.dtos.CurriculumRequestDto;
import com.crm.curriculum.dtos.CurriculumResponseDto;

public interface CurriculumService {
	List<CurriculumResponseDto> listarTodosLosCurriculums();

	CurriculumResponseDto buscarCurriculumPorId(Integer id_curriculum);

	CurriculumResponseDto crearCurriculum(CurriculumRequestDto creacion);

	CurriculumResponseDto actualizarCurriculumPorId(Integer id_curriculum, CurriculumRequestDto datos_actualizados);

	void eliminarCurriculumPorId(Integer id_curriculum);
}
