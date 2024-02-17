package com.Hartwig.ControleTotal.Controllers;

import com.Hartwig.ControleTotal.Models.Contato;
import com.Hartwig.ControleTotal.Models.Membro;
import com.Hartwig.ControleTotal.Services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membro")
public class MembroController {

    @Autowired
    MembroService membroService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Membro> cadastrarMembro(@RequestBody Membro membro) {

        return ResponseEntity.status(HttpStatus.OK).body(membroService.cadastrarMembro(membro));
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<Membro>> consultarMembro() {

        return ResponseEntity.status(HttpStatus.OK).body(membroService.consultarMembros());
    }

    @GetMapping("/consultar/{idmembro}")
    public ResponseEntity<Membro> consultarMembro(@PathVariable("idmembro") long idMembro) {

        return ResponseEntity.status(HttpStatus.OK).body(membroService.consultarByID(idMembro));
    }

    @PutMapping("/alterar/{idmembro}")
    public ResponseEntity<Membro> alterarMembro(@PathVariable("idmembro") long idMembro, @RequestBody Membro membro) {

        return ResponseEntity.status(HttpStatus.OK).body(membroService.alterarMembro(idMembro, membro));
    }

    @DeleteMapping("/excluir/{idmembro}")
    public ResponseEntity<Void> excluirMembro(@PathVariable("idmembro") long idMembro) {
        membroService.excluirMembro(idMembro);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/alterar/contatos/{idmembro}")
    public ResponseEntity<Membro> alterarContatosDeMembro(@PathVariable("idmembro") long idMembro, @RequestBody Contato contato) {

        return ResponseEntity.status(HttpStatus.OK).body(membroService.alterarContatos(idMembro, contato));
    }

}
