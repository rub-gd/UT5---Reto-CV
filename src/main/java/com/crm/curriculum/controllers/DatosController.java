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

import com.crm.curriculum.dtos.DatosRequestDto;
import com.crm.curriculum.dtos.DatosResponseDto;
import com.crm.curriculum.services.DatosService;

@RestController
@RequestMapping("/crm/datos")
public class DatosController {
	private DatosService datosService;

	public DatosController(DatosService datosService) {
		this.datosService = datosService;
	}

	@GetMapping
	public ResponseEntity<List<DatosResponseDto>> listarTodosLosDatos() {
		return ResponseEntity.ok(datosService.listarTodosLosDatos());
	}

	@GetMapping("/{id_datos}")
	public ResponseEntity<DatosResponseDto> buscarDatosPorId(@PathVariable Integer id_datos) {
		return ResponseEntity.ok(datosService.buscarDatosPorId(id_datos));
	}

	@PostMapping
	public ResponseEntity<DatosResponseDto> crearDatos(@RequestBody DatosRequestDto creacion) {
		return ResponseEntity.ok(datosService.crearDatos(creacion));
	}

	@PutMapping("/{id_datos}")
	public ResponseEntity<DatosResponseDto> actualizarDatosPorId(@PathVariable Integer id_datos, @RequestBody DatosRequestDto datos_actualizados) {
		return ResponseEntity.ok(datosService.actualizarDatosPorId(id_datos, datos_actualizados));
	}

	@DeleteMapping("/{id_datos}")
	public ResponseEntity<Void> eliminarDatosPorId(@PathVariable Integer id_datos) {
		datosService.eliminarDatosPorId(id_datos);
			return ResponseEntity.noContent().build();
	}
}
