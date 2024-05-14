package com.example.a08projetos.model;

public class IngressoVIP extends Ingresso {
    private String funcao;

    public IngressoVIP(String codigoIdentificador, float valor, String funcao) {
        super(codigoIdentificador, valor);
        this.funcao = funcao;
    }

    @Override
    public float valorFinal(float taxaConveniencia) {
        // Adiciona 18% para ingressos VIP
        return super.valorFinal(taxaConveniencia) * 1.18f;
    }

    public String getFuncao() {
        return funcao;
    }
}




