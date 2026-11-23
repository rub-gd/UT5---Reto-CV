package com.crm.curriculum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.curriculum.entities.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}
