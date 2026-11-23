package com.crm.curriculum.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.curriculum.dtos.ExperienciaRequestDto;
import com.crm.curriculum.dtos.ExperienciaResponseDto;
import com.crm.curriculum.entities.Experiencia;
import com.crm.curriculum.repository.ExperienciaRepository;
import com.crm.curriculum.services.ExperienciaService;

@Service
public class ExperienciaServiceImpl implements ExperienciaService {
	private ExperienciaRepository experienciaRepository;

	public ExperienciaServiceImpl(ExperienciaRepository experienciaRepository) {
		this.experienciaRepository = experienciaRepository;
	}

	@Override
	public List<ExperienciaResponseDto> listarTodasLasExperiencias() {
		return experienciaRepository.findAll().stream().map(this::convertirExperienciaEncontrada).toList();
	}

	@Override
	public ExperienciaResponseDto buscarExperienciaPorId(Integer id_experiencia) {
		Experiencia experienciaEncontrada = experienciaRepository.findById(id_experiencia).orElseThrow(() -> new RuntimeException("Experiencia no encontrada."));
			return convertirExperienciaEncontrada(experienciaEncontrada);
	}

	@Override
	public ExperienciaResponseDto crearExperiencia(ExperienciaRequestDto creacion) {
		Experiencia nuevaExperiencia = new Experiencia();
			nuevaExperiencia.setPuesto(creacion.puesto());
			nuevaExperiencia.setNombreEmpresa(creacion.nombreEmpresa());
			nuevaExperiencia.setInicioFecha(creacion.inicioFecha());
			nuevaExperiencia.setFinFecha(creacion.finFecha());
				experienciaRepository.save(nuevaExperiencia);
					return convertirExperienciaEncontrada(nuevaExperiencia);
	}

	@Override
	public ExperienciaResponseDto actualizarExperienciaPorId(Integer id_experiencia, ExperienciaRequestDto datos_actualizados) {
		Experiencia experienciaEncontrada = experienciaRepository.findById(id_experiencia).orElseThrow(() -> new RuntimeException("Experiencia no encontrada."));
			experienciaEncontrada.setPuesto(datos_actualizados.puesto());
			experienciaEncontrada.setNombreEmpresa(datos_actualizados.nombreEmpresa());
			experienciaEncontrada.setInicioFecha(datos_actualizados.inicioFecha());
			experienciaEncontrada.setFinFecha(datos_actualizados.finFecha());
				experienciaRepository.save(experienciaEncontrada);
					return convertirExperienciaEncontrada(experienciaEncontrada);
	}

	@Override
	public void eliminarExperienciaPorId(Integer id_experiencia) {
		Experiencia experienciaEncontrada = experienciaRepository.findById(id_experiencia).orElseThrow(() -> new RuntimeException("Experiencia no encontrada."));
			experienciaRepository.delete(experienciaEncontrada);
	}

	public ExperienciaResponseDto convertirExperienciaEncontrada(Experiencia experienciaEncontrada) {
		return new ExperienciaResponseDto(
			experienciaEncontrada.getId_experiencia(),
			experienciaEncontrada.getPuesto(),
			experienciaEncontrada.getNombreEmpresa(),
			experienciaEncontrada.getInicioFecha(),
			experienciaEncontrada.getFinFecha()
		);
	}
}
