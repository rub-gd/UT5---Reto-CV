package com.crm.curriculum.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crm.curriculum.dtos.AptitudesRequestDto;
import com.crm.curriculum.dtos.AptitudesResponseDto;
import com.crm.curriculum.entities.Aptitudes;
import com.crm.curriculum.repository.AptitudesRepository;
import com.crm.curriculum.services.AptitudesService;

@Service
public class AptitudesServiceImpl implements AptitudesService {
	private AptitudesRepository aptitudesRepository;

	public AptitudesServiceImpl(AptitudesRepository aptitudesRepository) {
		this.aptitudesRepository = aptitudesRepository;
	}

	@Override
	public List<AptitudesResponseDto> listarTodasLasAptitudes() {
		return aptitudesRepository.findAll().stream().map(this::convertirAptitudEncontrada).toList();
	}

	@Override
	public AptitudesResponseDto buscarAptitudesPorId(Integer id_aptitudes) {
		Aptitudes aptitudesEncontradas = aptitudesRepository.findById(id_aptitudes).orElseThrow(() -> new RuntimeException("Aptitud no encontrada."));
			return convertirAptitudEncontrada(aptitudesEncontradas);
	}

	@Override
	public AptitudesResponseDto crearAptitudes(AptitudesRequestDto creacion) {
		Aptitudes nuevasAptitudes = new Aptitudes();
			nuevasAptitudes.setNombreAptitud(creacion.nombreAptitud());
				aptitudesRepository.save(nuevasAptitudes);
					return convertirAptitudEncontrada(nuevasAptitudes);
	}

	@Override
	public AptitudesResponseDto actualizarAptitudesPorId(Integer id_aptitudes, AptitudesRequestDto datos_actualizados) {
		Aptitudes aptitudesEncontradas = aptitudesRepository.findById(id_aptitudes).orElseThrow(() -> new RuntimeException("Aptitud no encontrada."));
			aptitudesEncontradas.setNombreAptitud(datos_actualizados.nombreAptitud());
				aptitudesRepository.save(aptitudesEncontradas);
					return convertirAptitudEncontrada(aptitudesEncontradas);
	}

	@Override
	public void eliminarAptitudesPorId(Integer id_aptitudes) {
		Aptitudes aptitudesEncontradas = aptitudesRepository.findById(id_aptitudes).orElseThrow(() -> new RuntimeException("Aptitud no encontrada."));
			aptitudesRepository.delete(aptitudesEncontradas);
	}

	public AptitudesResponseDto convertirAptitudEncontrada(Aptitudes aptitudesEncontradas) {
		return new AptitudesResponseDto(
			aptitudesEncontradas.getId_aptitudes(),
			aptitudesEncontradas.getNombreAptitud()
		);
	}
}
