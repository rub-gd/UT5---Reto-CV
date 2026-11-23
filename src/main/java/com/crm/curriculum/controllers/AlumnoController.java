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

import com.crm.curriculum.dtos.AlumnoRequestDto;
import com.crm.curriculum.dtos.AlumnoResponseDto;
import com.crm.curriculum.services.AlumnoService;

@RestController
@RequestMapping("/crm/alumnos")
public class AlumnoController {
	private AlumnoService alumnoService;

	public AlumnoController(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}

	@GetMapping
	public ResponseEntity<List<AlumnoResponseDto>> listarTodosLosAlumnos() {
		return ResponseEntity.ok(alumnoService.listarTodosLosAlumnos());
	}

	@GetMapping("/{id_alumno}")
	public ResponseEntity<AlumnoResponseDto> buscarAlumnoPorId(@PathVariable Integer id_alumno) {
		return ResponseEntity.ok(alumnoService.buscarAlumnoPorId(id_alumno));
	}

	@PostMapping
	public ResponseEntity<AlumnoResponseDto> crearAlumno(@RequestBody AlumnoRequestDto creacion) {
		return ResponseEntity.ok(alumnoService.crearAlumno(creacion));
	}

	@PutMapping("/{id_alumno}")
	public ResponseEntity<AlumnoResponseDto> actualizarAlumnoPorId(@PathVariable Integer id_alumno, @RequestBody AlumnoRequestDto datos_actualizados) {
		return ResponseEntity.ok(alumnoService.actualizarAlumnoPorId(id_alumno, datos_actualizados));
	}

	@DeleteMapping("/{id_alumno}")
	public ResponseEntity<Void> eliminarAlumnoPorId(@PathVariable Integer id_alumno) {
		alumnoService.eliminarAlumnoPorId(id_alumno);
			return ResponseEntity.noContent().build();
	}
}
