package com.crm.curriculum.services;

import java.util.List;

import com.crm.curriculum.dtos.AlumnoRequestDto;
import com.crm.curriculum.dtos.AlumnoResponseDto;

public interface AlumnoService {
	List<AlumnoResponseDto> listarTodosLosAlumnos();

	AlumnoResponseDto buscarAlumnoPorId(Integer id_alumno);

	AlumnoResponseDto crearAlumno(AlumnoRequestDto creacion);

	AlumnoResponseDto actualizarAlumnoPorId(Integer id_alumno, AlumnoRequestDto datos_actualizados);

	void eliminarAlumnoPorId(Integer id_alumno);
}
