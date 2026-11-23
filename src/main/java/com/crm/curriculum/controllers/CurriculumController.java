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

import com.crm.curriculum.dtos.CurriculumRequestDto;
import com.crm.curriculum.dtos.CurriculumResponseDto;
import com.crm.curriculum.services.CurriculumService;

@RestController
@RequestMapping("/crm/curriculums")
public class CurriculumController {
	private CurriculumService curriculumService;

	public CurriculumController(CurriculumService curriculumService) {
		this.curriculumService = curriculumService;
	}

	@GetMapping
	public ResponseEntity<List<CurriculumResponseDto>> listarTodosLosCurriculums() {
		return ResponseEntity.ok(curriculumService.listarTodosLosCurriculums());
	}

	@GetMapping("/{id_curriculum}")
	public ResponseEntity<CurriculumResponseDto> buscarCurriculumPorId(@PathVariable Integer id_curriculum) {
		return ResponseEntity.ok(curriculumService.buscarCurriculumPorId(id_curriculum));
	}

	@PostMapping
	public ResponseEntity<CurriculumResponseDto> crearCurriculum(@RequestBody CurriculumRequestDto creacion) {
		return ResponseEntity.ok(curriculumService.crearCurriculum(creacion));
	}

	@PutMapping("/{id_curriculum}")
	public ResponseEntity<CurriculumResponseDto> actualizarCurriculumPorId(@PathVariable Integer id_curriculum, @RequestBody CurriculumRequestDto datos_actualizados) {
		return ResponseEntity.ok(curriculumService.actualizarCurriculumPorId(id_curriculum, datos_actualizados));
	}

	@DeleteMapping("/{id_curriculum}")
	public ResponseEntity<Void> eliminarCurriculumPorId(@PathVariable Integer id_curriculum) {
		curriculumService.eliminarCurriculumPorId(id_curriculum);
			return ResponseEntity.noContent().build();
	}
}
