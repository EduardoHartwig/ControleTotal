package com.Hartwig.ControleTotal.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty
    private String cep;

    private String logradouro;//Rua

    private String complemento;

    private String bairro;

    private String localidade;//Cidade

    private String uf;//Estado / SP

    @NotNull
    private long numero;



}
