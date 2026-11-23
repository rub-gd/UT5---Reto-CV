	package com.crm.curriculum.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.crm.curriculum.dtos.CurriculumRequestDto;
import com.crm.curriculum.dtos.CurriculumResponseDto;
import com.crm.curriculum.entities.Alumno;
import com.crm.curriculum.entities.Curriculum;
import com.crm.curriculum.entities.Datos;
import com.crm.curriculum.repository.AlumnoRepository;
import com.crm.curriculum.repository.CurriculumRepository;
import com.crm.curriculum.repository.DatosRepository;
import com.crm.curriculum.services.CurriculumService;

@Service
public class CurriculumServiceImpl implements CurriculumService {
	private CurriculumRepository curriculumRepository;
	private DatosRepository datosRepository;
	private AlumnoRepository alumnoRepository;
	
	public CurriculumServiceImpl(CurriculumRepository curriculumRepository, DatosRepository datosRepository, AlumnoRepository alumnoRepository) {
		this.curriculumRepository = curriculumRepository;
		this.datosRepository = datosRepository;
		this.alumnoRepository = alumnoRepository;
	}
	@Override
	@Transactional(readOnly = true)
	public List<CurriculumResponseDto> listarTodosLosCurriculums() {
		return curriculumRepository.findAll().stream().map(this::convertirCurriculumEncontrado).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public CurriculumResponseDto buscarCurriculumPorId(Integer id_curriculum) {
		Curriculum curriculumEncontrado = curriculumRepository.findById(id_curriculum).orElseThrow(() -> new RuntimeException("Curriculum no encontrado."));
			return convertirCurriculumEncontrado(curriculumEncontrado);
	}

	@Override
	@Transactional
	public CurriculumResponseDto crearCurriculum(CurriculumRequestDto creacion) {
		Curriculum nuevoCurriculum = new Curriculum();
			Datos datosEncontrados = datosRepository.findById(creacion.id_datos()).orElseThrow(() -> new RuntimeException("Curriculum no encontrado"));
				nuevoCurriculum.setDatos(datosEncontrados);
				nuevoCurriculum.setExperiencia(creacion.experiencia());
				nuevoCurriculum.setFormacion(creacion.formacion());
				nuevoCurriculum.setAptitudes(creacion.aptitudes());
				nuevoCurriculum.setFormacionComplementaria(creacion.formacionComplementaria());
			Alumno alumnoEncontrado = alumnoRepository.findById(creacion.id_alumno()).orElseThrow(() -> new RuntimeException("Curriculum no encontrado"));
				nuevoCurriculum.setAlumno(alumnoEncontrado);
					curriculumRepository.save(nuevoCurriculum);
						return convertirCurriculumEncontrado(nuevoCurriculum);
	}

	@Override
	@Transactional
	public CurriculumResponseDto actualizarCurriculumPorId(Integer id_curriculum, CurriculumRequestDto datos_actualizados) {
		Curriculum curriculumEncontrado = curriculumRepository.findById(id_curriculum).orElseThrow(() -> new RuntimeException("Curriculum no encontrado."));
			Datos datosEncontrados = datosRepository.findById(datos_actualizados.id_datos()).orElseThrow(() -> new RuntimeException("Curriculum no encontrado"));
				curriculumEncontrado.setDatos(datosEncontrados);
				curriculumEncontrado.setExperiencia(datos_actualizados.experiencia());
				curriculumEncontrado.setFormacion(datos_actualizados.formacion());
				curriculumEncontrado.setAptitudes(datos_actualizados.aptitudes());
				curriculumEncontrado.setFormacionComplementaria(datos_actualizados.formacionComplementaria());
			Alumno alumnoEncontrado = alumnoRepository.findById(datos_actualizados.id_alumno()).orElseThrow(() -> new RuntimeException("Curriculum no encontrado"));
				curriculumEncontrado.setAlumno(alumnoEncontrado);
					curriculumRepository.save(curriculumEncontrado);
						return convertirCurriculumEncontrado(curriculumEncontrado);
	}

	@Override
	@Transactional
	public void eliminarCurriculumPorId(Integer id_curriculum) {
		Curriculum curriculumEncontrado = curriculumRepository.findById(id_curriculum).orElseThrow(() -> new RuntimeException("Curriculum no encontrado."));
			curriculumRepository.delete(curriculumEncontrado);
	}
	
	public CurriculumResponseDto convertirCurriculumEncontrado(Curriculum curriculuCogido) {
		return new CurriculumResponseDto(
			curriculuCogido.getId_curriculum(),
			curriculuCogido.getDatos().getId_datos(),
			curriculuCogido.getExperiencia(),
			curriculuCogido.getFormacion(),
			curriculuCogido.getAptitudes(),
			curriculuCogido.getFormacionComplementaria(),
			curriculuCogido.getAlumno().getId_alumno()
		);
	}
}
