package com.segurosvidaapi.repository;

import com.segurosvidaapi.model.Segurado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeguradoRepository extends JpaRepository<Segurado, Long> {
}
