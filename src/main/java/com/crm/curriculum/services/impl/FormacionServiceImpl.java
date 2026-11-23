package com.crm.curriculum.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.curriculum.dtos.FormacionRequestDto;
import com.crm.curriculum.dtos.FormacionResponseDto;
import com.crm.curriculum.entities.Formacion;
import com.crm.curriculum.repository.FormacionRepository;
import com.crm.curriculum.services.FormacionService;

@Service
public class FormacionServiceImpl implements FormacionService {
	private FormacionRepository formacionRepository;

	public FormacionServiceImpl(FormacionRepository formacionRepository) {
		this.formacionRepository = formacionRepository;
	}

	@Override
	public List<FormacionResponseDto> listarTodasLasFormaciones() {
		return formacionRepository.findAll().stream().map(this::convertirFormacionEncontrada).toList();
	}

	@Override
	public FormacionResponseDto buscarFormacionPorId(Integer id_formacion) {
		Formacion formacionEncontrada = formacionRepository.findById(id_formacion).orElseThrow(() -> new RuntimeException("Formacion no encontrada."));
			return convertirFormacionEncontrada(formacionEncontrada);
	}

	@Override
	public FormacionResponseDto crearFormacion(FormacionRequestDto creacion) {
		Formacion nuevaFormacion = new Formacion();
			nuevaFormacion.setTitulo(creacion.titulo());
			nuevaFormacion.setLugarCursado(creacion.lugarCursado());
			nuevaFormacion.setInicioFecha(creacion.inicioFecha());
			nuevaFormacion.setFinFecha(creacion.finFecha());
				formacionRepository.save(nuevaFormacion);
					return convertirFormacionEncontrada(nuevaFormacion);
	}

	@Override
	public FormacionResponseDto actualizarFormacionPorId(Integer id_formacion, FormacionRequestDto datos_actualizados) {
		Formacion formacionEncontrada = formacionRepository.findById(id_formacion).orElseThrow(() -> new RuntimeException("Formacion no encontrada."));
			formacionEncontrada.setTitulo(datos_actualizados.titulo());
			formacionEncontrada.setLugarCursado(datos_actualizados.lugarCursado());
			formacionEncontrada.setInicioFecha(datos_actualizados.inicioFecha());
			formacionEncontrada.setFinFecha(datos_actualizados.finFecha());
				formacionRepository.save(formacionEncontrada);
					return convertirFormacionEncontrada(formacionEncontrada);
	}

	@Override
	public void eliminarFormacionPorId(Integer id_formacion) {
		Formacion formacionEncontrada = formacionRepository.findById(id_formacion).orElseThrow(() -> new RuntimeException("Formacion no encontrada."));
		formacionRepository.delete(formacionEncontrada);
	}

	public FormacionResponseDto convertirFormacionEncontrada(Formacion formacionEncontrada) {
		return new FormacionResponseDto(
			formacionEncontrada.getId_formacion(),
			formacionEncontrada.getTitulo(),
			formacionEncontrada.getLugarCursado(),
			formacionEncontrada.getInicioFecha(),
			formacionEncontrada.getFinFecha()
		);
	}
}
