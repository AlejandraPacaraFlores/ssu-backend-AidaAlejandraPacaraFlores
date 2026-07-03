package com.ssu.backend.repository;

import com.ssu.backend.entity.Convocatoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvocatoriaRepository extends JpaRepository<Convocatoria, Long> {

}