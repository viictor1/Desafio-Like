package com.desafiolike.demo.utils;

import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;

import java.util.ArrayList;
import java.util.Date;

public class Factory {

    public static Orcamento createOrcamento(){
        Orcamento orcamento = new Orcamento();

        orcamento.setId(1);
        orcamento.setData(new Date());
        orcamento.setNomeCliente("Cliente Teste");

        orcamento.setProdutos(new ArrayList<>());
        for (int i = 0; i < 2; i++){
            orcamento.getProdutos().add(createProduto(orcamento));
        }

        return orcamento;
    }

    public static Orcamento createOrcamentoNoId(){
        Orcamento orcamento = new Orcamento();

        orcamento.setData(new Date());
        orcamento.setNomeCliente("Cliente Teste");

        orcamento.setProdutos(new ArrayList<>());
        for (int i = 0; i < 2; i++){
            orcamento.getProdutos().add(createProduto(orcamento));
        }

        return orcamento;
    }

    public static ProdutoOrcamento createProduto(Orcamento o){
        ProdutoOrcamento produto = new ProdutoOrcamento();

        produto.setId(1);
        produto.setQuantidade(5);
        produto.setValor(2.5F);
        produto.setOrcamento(o);
        produto.setNome("Produto Teste");

        return produto;
    }

    public static ProdutoOrcamento createProdutoNoId(Orcamento o){
        ProdutoOrcamento produto = new ProdutoOrcamento();

        produto.setQuantidade(5);
        produto.setValor(2.5F);
        produto.setOrcamento(o);
        produto.setNome("Produto Teste");

        return produto;
    }
}
