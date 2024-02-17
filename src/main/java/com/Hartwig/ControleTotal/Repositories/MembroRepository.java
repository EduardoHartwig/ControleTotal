package com.Hartwig.ControleTotal.Repositories;

import com.Hartwig.ControleTotal.Models.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {



}
