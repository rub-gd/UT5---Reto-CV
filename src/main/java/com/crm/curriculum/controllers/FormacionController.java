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

import com.crm.curriculum.dtos.FormacionRequestDto;
import com.crm.curriculum.dtos.FormacionResponseDto;
import com.crm.curriculum.services.FormacionService;

@RestController
@RequestMapping("/crm/formaciones")
public class FormacionController {
	private FormacionService formacionService;

	public FormacionController(FormacionService formacionService) {
		this.formacionService = formacionService;
	}

	@GetMapping
	public ResponseEntity<List<FormacionResponseDto>> listarTodasLasFormaciones() {
		return ResponseEntity.ok(formacionService.listarTodasLasFormaciones());
	}

	@GetMapping("/{id_formacion}")
	public ResponseEntity<FormacionResponseDto> buscarFormacionPorId(@PathVariable Integer id_formacion) {
		return ResponseEntity.ok(formacionService.buscarFormacionPorId(id_formacion));
	}

	@PostMapping
	public ResponseEntity<FormacionResponseDto> crearFormacion(@RequestBody FormacionRequestDto creacion) {
		return ResponseEntity.ok(formacionService.crearFormacion(creacion));
	}

	@PutMapping("/{id_formacion}")
	public ResponseEntity<FormacionResponseDto> actualizarFormacionPorId(@PathVariable Integer id_formacion, @RequestBody FormacionRequestDto datos_actualizados) {
		return ResponseEntity.ok(formacionService.actualizarFormacionPorId(id_formacion, datos_actualizados));
	}

	@DeleteMapping("/{id_formacion}")
	public ResponseEntity<Void> eliminarFormacionPorId(@PathVariable Integer id_formacion) {
		formacionService.eliminarFormacionPorId(id_formacion);
			return ResponseEntity.noContent().build();
	}
}
