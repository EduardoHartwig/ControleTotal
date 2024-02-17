package com.Hartwig.ControleTotal.Models;

import com.Hartwig.ControleTotal.Enums.Deficiencia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    private Date dataCadastro;
    private String nomeCompleto;
    private Date dataDeNascimento;
    private String registroGeral;
    private String cpf;
    @OneToOne
    private Contato contato;
    private Deficiencia deficiencia;
    //private Membro responsavel;

     /*long cep;
    Endereço
    Número
    Bairro
    Cidade
    Complemento
    https://viacep.com.br
    */

}
