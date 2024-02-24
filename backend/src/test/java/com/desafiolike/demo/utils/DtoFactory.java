package com.desafiolike.demo.utils;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.dto.ProdutoOrcamentoDto;

import java.util.ArrayList;
import java.util.Date;

public class DtoFactory {

    public static OrcamentoDto createOrcamentoDto() {
        OrcamentoDto orcamentoDto = new OrcamentoDto();

        orcamentoDto.setId((int) (Math.random() * 100));
        orcamentoDto.setData(new Date(2024, 02, 24));
        orcamentoDto.setNomeCliente("Cliente Teste");

        orcamentoDto.setProdutos(new ArrayList<>());

        for (int i = 0; i < 2; i++) {
            orcamentoDto.getProdutos().add(createProdutoOrcamentoDto(orcamentoDto));
        }

        return orcamentoDto;
    }

    public static OrcamentoDto createOrcamentoDtoNoId() {
        OrcamentoDto orcamentoDto = new OrcamentoDto();

        orcamentoDto.setData(new Date(2024, 02, 24));
        orcamentoDto.setNomeCliente("Cliente Teste");

        orcamentoDto.setProdutos(new ArrayList<>());

        for (int i = 0; i < 2; i++) {
            orcamentoDto.getProdutos().add(createProdutoOrcamentoDtoNoId());
        }
        return orcamentoDto;
    }

    public static ProdutoOrcamentoDto createProdutoOrcamentoDtoNoId() {
        ProdutoOrcamentoDto produtoDto = new ProdutoOrcamentoDto();

        produtoDto.setNome("Produto Teste");
        produtoDto.setQuantidade(5);
        produtoDto.setValor(2.5F);

        return produtoDto;
    }

    public static ProdutoOrcamentoDto createProdutoOrcamentoDto(OrcamentoDto dto) {
        ProdutoOrcamentoDto produtoDto = new ProdutoOrcamentoDto();

        produtoDto.setNome("Produto Teste");
        produtoDto.setQuantidade(5);
        produtoDto.setValor(2.5F);
        produtoDto.setOrcamentoId(dto.getId());

        return produtoDto;
    }
}
