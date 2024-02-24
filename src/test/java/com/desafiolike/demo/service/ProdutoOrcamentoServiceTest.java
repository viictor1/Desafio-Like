package com.desafiolike.demo.service;

import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;
import com.desafiolike.demo.repository.ProdutoOrcamentoRepository;
import com.desafiolike.demo.utils.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class ProdutoOrcamentoServiceTest {

    @InjectMocks
    private ProdutoOrcamentoService produtoOrcamentoService;
    @Mock
    private ProdutoOrcamentoRepository produtoOrcamentoRepository;

    private ProdutoOrcamento produtoOrcamento;

    private Orcamento orcamento;

    @BeforeEach
    void setup(){
        orcamento = Factory.createOrcamentoNoId();

        Orcamento orcamentoSalvo = Factory.createOrcamento();

        Mockito.when(produtoOrcamentoRepository.saveAll(orcamento.getProdutos()))
                .thenReturn(orcamentoSalvo.getProdutos());
    }

    @Test
    public void saveAllProductsTest(){
        List<ProdutoOrcamento> savedProdutos = produtoOrcamentoService.saveProdutos(orcamento);
        assertEquals(orcamento.getProdutos().size(), savedProdutos.size());

        int i = 0;
        for(ProdutoOrcamento p: savedProdutos){
            ProdutoOrcamento savedProduto = savedProdutos.get(i);
            ProdutoOrcamento originalProduto = orcamento.getProdutos().get(i);

            assertEquals(originalProduto.getNome(), savedProduto.getNome());
            assertEquals(originalProduto.getQuantidade(), savedProduto.getQuantidade());
            assertEquals(originalProduto.getValor(), savedProduto.getValor());
            i++;
        }

        Mockito.verify(produtoOrcamentoRepository).saveAll(orcamento.getProdutos());
    }
}


