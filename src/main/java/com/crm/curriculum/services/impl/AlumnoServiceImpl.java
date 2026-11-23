package com.crm.curriculum.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.curriculum.dtos.AlumnoRequestDto;
import com.crm.curriculum.dtos.AlumnoResponseDto;
import com.crm.curriculum.entities.Alumno;
import com.crm.curriculum.repository.AlumnoRepository;
import com.crm.curriculum.services.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	private AlumnoRepository alumnoRepository;

	public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
		this.alumnoRepository = alumnoRepository;
	}

	@Override
	public List<AlumnoResponseDto> listarTodosLosAlumnos() {
		return alumnoRepository.findAll().stream().map(this::convertirAlumnoEncontrado).toList();
	}

	@Override
	public AlumnoResponseDto buscarAlumnoPorId(Integer id_alumno) {
		Alumno alumnoEncontrado = alumnoRepository.findById(id_alumno).orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
			return convertirAlumnoEncontrado(alumnoEncontrado);
	}

	@Override
	public AlumnoResponseDto crearAlumno(AlumnoRequestDto creacion) {
		Alumno nuevoAlumno = new Alumno();
			nuevoAlumno.setNombre(creacion.nombre());
			nuevoAlumno.setApellidos(creacion.apellidos());
				alumnoRepository.save(nuevoAlumno);
					return convertirAlumnoEncontrado(nuevoAlumno);
	}

	@Override
	public AlumnoResponseDto actualizarAlumnoPorId(Integer id_alumno, AlumnoRequestDto datos_actualizados) {
		Alumno alumnoEncontrado = alumnoRepository.findById(id_alumno).orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
			alumnoEncontrado.setNombre(datos_actualizados.nombre());
			alumnoEncontrado.setApellidos(datos_actualizados.apellidos());
				alumnoRepository.save(alumnoEncontrado);
					return convertirAlumnoEncontrado(alumnoEncontrado);
	}

	@Override
	public void eliminarAlumnoPorId(Integer id_alumno) {
		Alumno alumnoEncontrado = alumnoRepository.findById(id_alumno).orElseThrow(() -> new RuntimeException("Alumno no encontrado."));
			alumnoRepository.delete(alumnoEncontrado);
	}

	public AlumnoResponseDto convertirAlumnoEncontrado(Alumno alumnoEncontrado) {
		return new AlumnoResponseDto(
			alumnoEncontrado.getId_alumno(),
			alumnoEncontrado.getNombre(),
			alumnoEncontrado.getApellidos()
		);
	}
}
