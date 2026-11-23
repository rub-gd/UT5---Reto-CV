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

import com.crm.curriculum.dtos.FormacionComplementariaRequestDto;
import com.crm.curriculum.dtos.FormacionComplementariaResponseDto;
import com.crm.curriculum.services.FormacionComplementariaService;

@RestController
@RequestMapping("/crm/formaciones-complementarias")
public class FormacionComplementariaController {
	private FormacionComplementariaService formacionComplementariaService;

	public FormacionComplementariaController(FormacionComplementariaService formacionComplementariaService) {
		this.formacionComplementariaService = formacionComplementariaService;
	}

	@GetMapping
	public ResponseEntity<List<FormacionComplementariaResponseDto>> listarTodasLasFormacionesComplementarias() {
		return ResponseEntity.ok(formacionComplementariaService.listarTodasLasFormacionesComplementarias());
	}

	@GetMapping("/{id_formacionComplementaria}")
	public ResponseEntity<FormacionComplementariaResponseDto> buscarFormacionComplementariaPorId(@PathVariable Integer id_formacionComplementaria) {
		return ResponseEntity.ok(formacionComplementariaService.buscarFormacionComplementariaPorId(id_formacionComplementaria));
	}

	@PostMapping
	public ResponseEntity<FormacionComplementariaResponseDto> crearFormacionComplementaria(@RequestBody FormacionComplementariaRequestDto creacion) {
		return ResponseEntity.ok(formacionComplementariaService.crearFormacionComplementaria(creacion));
	}

	@PutMapping("/{id_formacionComplementaria}")
	public ResponseEntity<FormacionComplementariaResponseDto> actualizarFormacionComplementariaPorId(@PathVariable Integer id_formacionComplementaria, @RequestBody FormacionComplementariaRequestDto datos_actualizados) {
		return ResponseEntity.ok(formacionComplementariaService.actualizarFormacionComplementariaPorId(id_formacionComplementaria, datos_actualizados));
	}

	@DeleteMapping("/{id_formacionComplementaria}")
	public ResponseEntity<Void> eliminarFormacionComplementariaPorId(@PathVariable Integer id_formacionComplementaria) {
		formacionComplementariaService.eliminarFormacionComplementariaPorId(id_formacionComplementaria);
			return ResponseEntity.noContent().build();
	}
}
