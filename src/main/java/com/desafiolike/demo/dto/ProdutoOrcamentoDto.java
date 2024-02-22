package com.desafiolike.demo.dto;

import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProdutoOrcamentoDto {

    private String nome;
    private float valor;
    private int quantidade;
    private Orcamento orcamento;

    public ProdutoOrcamento convertToEntity(){
        ProdutoOrcamento produtoOrcamento = new ProdutoOrcamento();

        produtoOrcamento.setNome(this.getNome());
        produtoOrcamento.setValor(this.getValor());
        produtoOrcamento.setQuantidade(this.getQuantidade());
        produtoOrcamento.setOrcamento(this.getOrcamento());

        return produtoOrcamento;
    }

    public ProdutoOrcamentoDto() {
    }

    public ProdutoOrcamentoDto(String nome, float valor, int quantidade, Orcamento orcamento) {
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

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }
}
