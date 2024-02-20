package com.Hartwig.ControleTotal.Models;

import com.Hartwig.ControleTotal.Enums.Deficiencia;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate dataCadastro;

    @NotNull
    private String nomeCompleto;

    @NotNull
    private Date dataDeNascimento;

    private String registroGeral;

    private String cpf;

    @OneToOne
    private Contato contato;

    @OneToOne
    private Endereco endereco;

    private Deficiencia deficiencia;

    //private Boolean mensalista; ??

    //private Membro responsavel;


}
