package com.desafiolike.demo.dto;

import com.desafiolike.demo.entity.ProdutoOrcamento;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoOrcamentoDto {

    private String nome;
    private float valor;
    private int quantidade;
    private int orcamentoId;

    public ProdutoOrcamento convertToEntity(){
        ProdutoOrcamento produtoOrcamento = new ProdutoOrcamento();

        produtoOrcamento.setNome(this.getNome());
        produtoOrcamento.setValor(this.getValor());
        produtoOrcamento.setQuantidade(this.getQuantidade());

        return produtoOrcamento;
    }

    public ProdutoOrcamentoDto() {
    }

    public ProdutoOrcamentoDto(String nome, float valor, int quantidade, int orcamentoId) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.orcamentoId = orcamentoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getOrcamentoId() {
        return orcamentoId;
    }

    public void setOrcamentoId(int orcamentoId) {
        this.orcamentoId = orcamentoId;
    }
}
