package com.desafiolike.demo.service;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.repository.OrcamentoRepository;
import com.desafiolike.demo.repository.ProdutoOrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrcamentoService {

    @Autowired
    private OrcamentoRepository orcamentoRepository;

    @Autowired
    private ProdutoOrcamentoRepository produtoOrcamentoRepository;

    public OrcamentoDto addOrcamento(OrcamentoDto orcamentoDto){
        Orcamento orcamento = orcamentoDto.convertToEntity();
        orcamento = orcamentoRepository.save(orcamento);

        Orcamento finalOrcamento = orcamento;
        orcamento.getProdutos().forEach(p -> p.setOrcamento(finalOrcamento));

        produtoOrcamentoRepository.saveAll(orcamento.getProdutos());
        return orcamento.convertToDto();
    }

}
