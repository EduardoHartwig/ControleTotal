package com.Hartwig.ControleTotal.Repositories;

import com.Hartwig.ControleTotal.Models.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {



}
