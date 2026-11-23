package com.crm.curriculum.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.curriculum.dtos.AptitudesRequestDto;
import com.crm.curriculum.dtos.AptitudesResponseDto;
import com.crm.curriculum.services.AptitudesService;

@RestController
@RequestMapping("/crm/aptitudes")
public class AptitudesController {
	private AptitudesService aptitudesService;

	public AptitudesController(AptitudesService aptitudesService) {
		this.aptitudesService = aptitudesService;
	}

	@GetMapping
	public ResponseEntity<List<AptitudesResponseDto>> listarTodasLasAptitudes() {
		return ResponseEntity.ok(aptitudesService.listarTodasLasAptitudes());
	}

	@GetMapping("/{id_aptitudes}")
	public ResponseEntity<AptitudesResponseDto> buscarAptitudesPorId(@PathVariable Integer id_aptitudes) {
		return ResponseEntity.ok(aptitudesService.buscarAptitudesPorId(id_aptitudes));
	}

	@PostMapping
	public ResponseEntity<AptitudesResponseDto> crearAptitudes(@RequestBody AptitudesRequestDto creacion) {
		return ResponseEntity.ok(aptitudesService.crearAptitudes(creacion));
	}

	@PutMapping("/{id_aptitudes}")
	public ResponseEntity<AptitudesResponseDto> actualizarAptitudesPorId(@PathVariable Integer id_aptitudes, @RequestBody AptitudesRequestDto datos_actualizados) {
		return ResponseEntity.ok(aptitudesService.actualizarAptitudesPorId(id_aptitudes, datos_actualizados));
	}

	@DeleteMapping("/{id_aptitudes}")
	public ResponseEntity<Void> eliminarAptitudesPorId(@PathVariable Integer id_aptitudes) {
		aptitudesService.eliminarAptitudesPorId(id_aptitudes);
			return ResponseEntity.noContent().build();
	}
}
