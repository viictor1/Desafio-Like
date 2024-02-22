package com.desafiolike.demo.dto;

import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;

import java.util.Date;
import java.util.List;

public class OrcamentoDto {

    private int id;
    private String nomeCliente;
    private Date data;
    private List<ProdutoOrcamento> produtos;

    public Orcamento convertToEntity(){
        Orcamento orcamento = new Orcamento();

        orcamento.setId(this.getId());
        orcamento.setNomeCliente(this.getNomeCliente());
        orcamento.setData(this.getData());
        orcamento.setProdutos(this.getProdutos());

        return orcamento;
    }

    public OrcamentoDto() {
    }

    public OrcamentoDto(int id, String nomeCliente, Date data, List<ProdutoOrcamento> produtos) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.data = data;
        this.produtos = produtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<ProdutoOrcamento> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoOrcamento> produtos) {
        this.produtos = produtos;
    }
}
