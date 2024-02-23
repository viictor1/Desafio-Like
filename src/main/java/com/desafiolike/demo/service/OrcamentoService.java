package com.desafiolike.demo.service;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;
import com.desafiolike.demo.repository.OrcamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private ProdutoOrcamentoService produtoOrcamentoService;

    @Transactional(rollbackOn = Exception.class)
    public OrcamentoDto addOrcamento(OrcamentoDto orcamentoDto){
        try {

            Orcamento orcamento = orcamentoRepository.save(orcamentoDto.convertToEntity());

            List<ProdutoOrcamento> produtos = produtoOrcamentoService.saveProdutos(orcamento);
            orcamento.setProdutos(produtos);

            return orcamento.convertToDto();

        } catch (Exception e) {
            rollbackAndPrint(e);
        }

        return null;
    }

    private void rollbackAndPrint(Exception e){
        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        e.printStackTrace();
    }

}
