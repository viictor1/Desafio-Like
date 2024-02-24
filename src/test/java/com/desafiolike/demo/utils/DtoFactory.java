package com.desafiolike.demo.utils;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.dto.ProdutoOrcamentoDto;

import java.util.ArrayList;
import java.util.Date;

public class DtoFactory {

    public static OrcamentoDto createOrcamentoDto() {
        OrcamentoDto orcamentoDto = new OrcamentoDto();

        orcamentoDto.setId((int) (Math.random() * 100));
        orcamentoDto.setData(new Date());
        orcamentoDto.setNomeCliente("Cliente Teste");

        // Initialize the list of produtos
        orcamentoDto.setProdutos(new ArrayList<>());

        // For demonstration purposes, let's add a sample ProdutoOrcamentoDto
        orcamentoDto.getProdutos().add(createProdutoOrcamentoDto());

        return orcamentoDto;
    }

    public static ProdutoOrcamentoDto createProdutoOrcamentoDto() {
        ProdutoOrcamentoDto produtoDto = new ProdutoOrcamentoDto();

        produtoDto.setNome("Produto Teste");
        produtoDto.setQuantidade(5);
        produtoDto.setValor(2.5F);
        produtoDto.setOrcamentoId(1); // Set a sample orcamentoId

        return produtoDto;
    }
}
