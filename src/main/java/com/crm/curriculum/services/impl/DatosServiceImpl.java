package com.crm.curriculum.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.curriculum.dtos.DatosRequestDto;
import com.crm.curriculum.dtos.DatosResponseDto;
import com.crm.curriculum.entities.Datos;
import com.crm.curriculum.repository.DatosRepository;
import com.crm.curriculum.services.DatosService;

@Service
public class DatosServiceImpl implements DatosService {
	private DatosRepository datosRepository;

	public DatosServiceImpl(DatosRepository datosRepository) {
		this.datosRepository = datosRepository;
	}

	@Override
	public List<DatosResponseDto> listarTodosLosDatos() {
		return datosRepository.findAll().stream().map(this::convertirDatosEncontrados).toList();
	}

	@Override
	public DatosResponseDto buscarDatosPorId(Integer id_datos) {
		Datos datosEncontrados = datosRepository.findById(id_datos).orElseThrow(() -> new RuntimeException("Datos no encontrados."));
			return convertirDatosEncontrados(datosEncontrados);
	}

	@Override
	public DatosResponseDto crearDatos(DatosRequestDto creacion) {
		Datos nuevosDatos = new Datos();
			nuevosDatos.setNombreCompleto(creacion.nombreCompleto());
			nuevosDatos.setContacto(creacion.contacto());
			nuevosDatos.setDomicilio(creacion.domicilio());
			nuevosDatos.setSobreMi(creacion.sobreMi());
				datosRepository.save(nuevosDatos);
					return convertirDatosEncontrados(nuevosDatos);
	}

	@Override
	public DatosResponseDto actualizarDatosPorId(Integer id_datos, DatosRequestDto datos_actualizados) {
		Datos datosEncontrados = datosRepository.findById(id_datos).orElseThrow(() -> new RuntimeException("Datos no encontrados."));
			datosEncontrados.setNombreCompleto(datos_actualizados.nombreCompleto());
			datosEncontrados.setContacto(datos_actualizados.contacto());
			datosEncontrados.setDomicilio(datos_actualizados.domicilio());
			datosEncontrados.setSobreMi(datos_actualizados.sobreMi());
				datosRepository.save(datosEncontrados);
					return convertirDatosEncontrados(datosEncontrados);
	}

	@Override
	public void eliminarDatosPorId(Integer id_datos) {
		Datos datosEncontrados = datosRepository.findById(id_datos).orElseThrow(() -> new RuntimeException("Datos no encontrados."));
		datosRepository.delete(datosEncontrados);
	}

	public DatosResponseDto convertirDatosEncontrados(Datos datosEncontrados) {
		return new DatosResponseDto(
			datosEncontrados.getId_datos(),
			datosEncontrados.getNombreCompleto(),
			datosEncontrados.getContacto(),
			datosEncontrados.getDomicilio(),
			datosEncontrados.getSobreMi()
		);
	}
}
