package com.desafiolike.demo.entity;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.dto.ProdutoOrcamentoDto;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "orcamento")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column
    private Date data;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL)
    private List<ProdutoOrcamento> produtos;

    public OrcamentoDto convertToDto() {
        OrcamentoDto dto = new OrcamentoDto();
        List<ProdutoOrcamentoDto> produtos = this.getProdutos().stream().map(
                        ProdutoOrcamento::convertToDto)
                .collect(Collectors.toList());

        dto.setNomeCliente(this.getNomeCliente());
        dto.setData(this.getData());
        dto.setProdutos(produtos);

        return dto;
    }

    public Orcamento() {
    }

    public Orcamento(int id, String nomeCliente, Date data, List<ProdutoOrcamento> produtos) {
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
