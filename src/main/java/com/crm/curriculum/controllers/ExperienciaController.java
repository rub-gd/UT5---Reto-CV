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

import com.crm.curriculum.dtos.ExperienciaRequestDto;
import com.crm.curriculum.dtos.ExperienciaResponseDto;
import com.crm.curriculum.services.ExperienciaService;

@RestController
@RequestMapping("/crm/experiencias")
public class ExperienciaController {
	private ExperienciaService experienciaService;

	public ExperienciaController(ExperienciaService experienciaService) {
		this.experienciaService = experienciaService;
	}

	@GetMapping
	public ResponseEntity<List<ExperienciaResponseDto>> listarTodasLasExperiencias() {
		return ResponseEntity.ok(experienciaService.listarTodasLasExperiencias());
	}

	@GetMapping("/{id_experiencia}")
	public ResponseEntity<ExperienciaResponseDto> buscarExperienciaPorId(@PathVariable Integer id_experiencia) {
		return ResponseEntity.ok(experienciaService.buscarExperienciaPorId(id_experiencia));
	}

	@PostMapping
	public ResponseEntity<ExperienciaResponseDto> crearExperiencia(@RequestBody ExperienciaRequestDto creacion) {
		return ResponseEntity.ok(experienciaService.crearExperiencia(creacion));
	}

	@PutMapping("/{id_experiencia}")
	public ResponseEntity<ExperienciaResponseDto> actualizarExperienciaPorId(@PathVariable Integer id_experiencia, @RequestBody ExperienciaRequestDto datos_actualizados) {
		return ResponseEntity.ok(experienciaService.actualizarExperienciaPorId(id_experiencia, datos_actualizados));
	}

	@DeleteMapping("/{id_experiencia}")
	public ResponseEntity<Void> eliminarExperienciaPorId(@PathVariable Integer id_experiencia) {
		experienciaService.eliminarExperienciaPorId(id_experiencia);
			return ResponseEntity.noContent().build();
	}
}
