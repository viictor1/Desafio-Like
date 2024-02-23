package com.desafiolike.demo.dto;

import com.desafiolike.demo.entity.ProdutoOrcamento;

public class ProdutoOrcamentoDto {

    private String nome;
    private float valor;
    private int quantidade;
    private OrcamentoDto orcamento;

    public ProdutoOrcamento convertToEntity(){
        ProdutoOrcamento produtoOrcamento = new ProdutoOrcamento();

        produtoOrcamento.setNome(this.getNome());
        produtoOrcamento.setValor(this.getValor());
        produtoOrcamento.setQuantidade(this.getQuantidade());

        return produtoOrcamento;
    }

    public ProdutoOrcamentoDto() {
    }

    public ProdutoOrcamentoDto(String nome, float valor, int quantidade, OrcamentoDto orcamento) {
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.orcamento = orcamento;
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

    public OrcamentoDto getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(OrcamentoDto orcamento) {
        this.orcamento = orcamento;
    }
}
