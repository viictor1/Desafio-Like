package com.desafiolike.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "produtoOrcamento")
public class ProdutoOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nome;

    @Column
    private float valor;

    @Column
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;


    public ProdutoOrcamento() {
    }

    public ProdutoOrcamento(int id, String nome, float valor, int quantidade, Orcamento orcamento) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.orcamento = orcamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
