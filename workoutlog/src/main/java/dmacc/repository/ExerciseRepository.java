package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dmacc.beans.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{}
