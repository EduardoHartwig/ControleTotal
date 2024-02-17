package com.Hartwig.ControleTotal.Enums;

public enum Deficiencia {
    Fisica("Deficiência física"),
    Visual("Deficiência visual"),
    Auditiva("Deficiência auditiva"),
    Mental("Deficiência mental"),
    Intelectual("Deficiência intelectual"),
    Autismo("Transtorno do espectro autista");

    private final String nome;

    Deficiencia(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
