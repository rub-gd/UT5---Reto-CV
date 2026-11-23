package com.crm.curriculum.services;

import java.util.List;

import com.crm.curriculum.dtos.FormacionRequestDto;
import com.crm.curriculum.dtos.FormacionResponseDto;

public interface FormacionService {
	List<FormacionResponseDto> listarTodasLasFormaciones();

	FormacionResponseDto buscarFormacionPorId(Integer id_formacion);

	FormacionResponseDto crearFormacion(FormacionRequestDto creacion);

	FormacionResponseDto actualizarFormacionPorId(Integer id_formacion, FormacionRequestDto datos_actualizados);

	void eliminarFormacionPorId(Integer id_formacion);
}
