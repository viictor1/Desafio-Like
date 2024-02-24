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

        Orcamento orcamento = orcamentoRepository.save(orcamentoDto.convertToEntity());

        orcamento.setProdutos(produtoOrcamentoService.saveProdutos(orcamento));

        return orcamento.convertToDto();
    }

}
