package com.crm.curriculum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.curriculum.entities.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {

}