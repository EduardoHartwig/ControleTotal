package com.Hartwig.ControleTotal.Services;

import com.Hartwig.ControleTotal.Models.Contato;
import com.Hartwig.ControleTotal.Models.Membro;
import com.Hartwig.ControleTotal.Repositories.ContatoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    @Transactional
    public void cadastrarContato(Contato contato) {

        contatoRepository.save(contato);
    }

}
