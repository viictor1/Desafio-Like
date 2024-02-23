package com.desafiolike.demo.service;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;
import com.desafiolike.demo.repository.OrcamentoRepository;
import com.desafiolike.demo.repository.ProdutoOrcamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private ProdutoOrcamentoRepository produtoOrcamentoRepository;

    @Transactional(rollbackOn = Exception.class)
    public OrcamentoDto addOrcamento(OrcamentoDto orcamentoDto){
        try {
            Orcamento orcamento = orcamentoDto.convertToEntity();
            orcamento = orcamentoRepository.save(orcamento);

            List<ProdutoOrcamento> produtos = new ArrayList<>(orcamento.getProdutos());

            for (ProdutoOrcamento produto : produtos) {
                produto.setOrcamento(orcamento);
            }

            produtos = produtoOrcamentoRepository.saveAll(produtos);
            orcamento.setProdutos(produtos);

            return orcamento.convertToDto();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            e.printStackTrace();
        }

        return null;
    }

}
