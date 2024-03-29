package com.Hartwig.ControleTotal.Services;

import com.Hartwig.ControleTotal.Models.Contato;
import com.Hartwig.ControleTotal.Models.Endereco;
import com.Hartwig.ControleTotal.Models.Membro;
import com.Hartwig.ControleTotal.Repositories.MembroRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    @Autowired
    MembroRepository membroRepository;
    @Autowired
    ContatoService contatoService;
    @Autowired
    EnderecoService enderecoService;


    @Transactional
    public Membro cadastrarMembro(Membro membro) throws IOException {
        membro.setDataCadastro(LocalDate.now());


        Endereco enderecoSalvo = enderecoService.cadastrarEndereco(membro.getEndereco());
        Contato contatoSalvo = contatoService.cadastrarContato(membro.getContato());
        membro.setEndereco(enderecoSalvo);
        membro.setContato(contatoSalvo);


        return membroRepository.save(membro);
    }

    public List<Membro> consultarMembros() {

        return membroRepository.findAll();
    }

    public Membro consultarByID(long idMembro) {
        Optional<Membro> obj = membroRepository.findById(idMembro);

        return obj.orElseThrow(() -> new EntityNotFoundException("Membro não encontrado"));
    }

    public Membro alterarMembro(long idMembro, Membro membro) throws IOException {
        Membro mem = this.consultarByID(idMembro);
        mem.setNomeCompleto(membro.getNomeCompleto());
        mem.setDataDeNascimento(membro.getDataDeNascimento());
        mem.setRegistroGeral(membro.getRegistroGeral());
        mem.setCpf(membro.getCpf());
        mem.setContato(membro.getContato());
        mem.setDeficiencia(membro.getDeficiencia());

        return this.cadastrarMembro(mem);
    }

    public Membro alterarContatos(long idMembro, Contato novoContato) throws IOException {
        Membro mem = this.consultarByID(idMembro);
        mem.setContato(novoContato);
        return this.cadastrarMembro(mem);
    }

    @Transactional
    public void excluirMembro(long idMembro) {

        membroRepository.delete(this.consultarByID(idMembro));
    }


}
