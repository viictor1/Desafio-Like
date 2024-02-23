package com.desafiolike.demo.service;

import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;
import com.desafiolike.demo.repository.ProdutoOrcamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoOrcamentoService {
    @Autowired
    private ProdutoOrcamentoRepository produtoOrcamentoRepository;

    @Transactional
    public List<ProdutoOrcamento> saveProdutos(Orcamento orcamento) {
        List<ProdutoOrcamento> produtos = new ArrayList<>(orcamento.getProdutos());

        for (ProdutoOrcamento produto : produtos) {
            produto.setOrcamento(orcamento);
        }

        return produtoOrcamentoRepository.saveAll(produtos);
    }

}
