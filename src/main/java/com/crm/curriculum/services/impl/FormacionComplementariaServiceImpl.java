package com.crm.curriculum.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.curriculum.dtos.FormacionComplementariaRequestDto;
import com.crm.curriculum.dtos.FormacionComplementariaResponseDto;
import com.crm.curriculum.entities.FormacionComplementaria;
import com.crm.curriculum.repository.FormacionComplementariaRepository;
import com.crm.curriculum.services.FormacionComplementariaService;

@Service
public class FormacionComplementariaServiceImpl implements FormacionComplementariaService {
	private FormacionComplementariaRepository formacionComplementariaRepository;

	public FormacionComplementariaServiceImpl(FormacionComplementariaRepository formacionComplementariaRepository) {
		this.formacionComplementariaRepository = formacionComplementariaRepository;
	}

	@Override
	public List<FormacionComplementariaResponseDto> listarTodasLasFormacionesComplementarias() {
		return formacionComplementariaRepository.findAll().stream().map(this::convertirFormacionComplementariaEncontrada).toList();
	}

	@Override
	public FormacionComplementariaResponseDto buscarFormacionComplementariaPorId(Integer id_formacionComplementaria) {
		FormacionComplementaria formacionComplementariaEncontrada = formacionComplementariaRepository.findById(id_formacionComplementaria).orElseThrow(() -> new RuntimeException("Formacion complementaria no encontrada."));
			return convertirFormacionComplementariaEncontrada(formacionComplementariaEncontrada);
	}

	@Override
	public FormacionComplementariaResponseDto crearFormacionComplementaria(FormacionComplementariaRequestDto creacion) {
		FormacionComplementaria nuevaFormacionComplementaria = new FormacionComplementaria();
			nuevaFormacionComplementaria.setTitulo(creacion.titulo());
			nuevaFormacionComplementaria.setLugarCursado(creacion.lugarCursado());
			nuevaFormacionComplementaria.setInicioFecha(creacion.inicioFecha());
			nuevaFormacionComplementaria.setFinFecha(creacion.finFecha());
				formacionComplementariaRepository.save(nuevaFormacionComplementaria);
					return convertirFormacionComplementariaEncontrada(nuevaFormacionComplementaria);
	}

	@Override
	public FormacionComplementariaResponseDto actualizarFormacionComplementariaPorId(Integer id_formacionComplementaria, FormacionComplementariaRequestDto datos_actualizados) {
		FormacionComplementaria formacionComplementariaEncontrada = formacionComplementariaRepository.findById(id_formacionComplementaria).orElseThrow(() -> new RuntimeException("Formacion complementaria no encontrada."));
			formacionComplementariaEncontrada.setTitulo(datos_actualizados.titulo());
			formacionComplementariaEncontrada.setLugarCursado(datos_actualizados.lugarCursado());
			formacionComplementariaEncontrada.setInicioFecha(datos_actualizados.inicioFecha());
			formacionComplementariaEncontrada.setFinFecha(datos_actualizados.finFecha());
				formacionComplementariaRepository.save(formacionComplementariaEncontrada);
					return convertirFormacionComplementariaEncontrada(formacionComplementariaEncontrada);
	}

	@Override
	public void eliminarFormacionComplementariaPorId(Integer id_formacionComplementaria) {
		FormacionComplementaria formacionComplementariaEncontrada = formacionComplementariaRepository.findById(id_formacionComplementaria).orElseThrow(() -> new RuntimeException("Formacion complementaria no encontrada."));
			formacionComplementariaRepository.delete(formacionComplementariaEncontrada);
	}

	public FormacionComplementariaResponseDto convertirFormacionComplementariaEncontrada(FormacionComplementaria formacionComplementariaEncontrada) {
		return new FormacionComplementariaResponseDto(
			formacionComplementariaEncontrada.getId_formacionComplementaria(),
			formacionComplementariaEncontrada.getTitulo(),
			formacionComplementariaEncontrada.getLugarCursado(),
			formacionComplementariaEncontrada.getInicioFecha(),
			formacionComplementariaEncontrada.getFinFecha()
		);
	}
}
