package com.desafiolike.demo.entity;

import com.desafiolike.demo.dto.ProdutoOrcamentoDto;
import com.desafiolike.demo.utils.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
public class ProdutoOrcamentoTest {

    @InjectMocks
    private ProdutoOrcamento produtoOrcamento;

    @InjectMocks
    private Orcamento orcamento;
    @Mock
    private ProdutoOrcamentoDto produtoOrcamentoDto;

    @BeforeEach
    void setup(){
        orcamento = Factory.createOrcamento();
        produtoOrcamento = Factory.createProduto(orcamento);
        produtoOrcamentoDto = produtoOrcamento.convertToDto();
    }

    @Test
    public void convertProdutoToDto(){
        assertEquals(produtoOrcamento.getNome(), produtoOrcamentoDto.getNome());
        assertEquals(produtoOrcamento.getValor(), produtoOrcamentoDto.getValor());
        assertEquals(produtoOrcamento.getQuantidade(), produtoOrcamentoDto.getQuantidade());
        assertEquals(produtoOrcamento.getOrcamento().getId(), produtoOrcamentoDto.getOrcamentoId());
    }

    @Test
    public void convertProdutoToDtoNotEqualsWrongValues(){
        assertNotEquals(produtoOrcamento.getNome(), produtoOrcamentoDto.getNome().concat("erro"));
        assertNotEquals(produtoOrcamento.getValor(), produtoOrcamentoDto.getValor() + 1F);
        assertNotEquals(produtoOrcamento.getQuantidade(), produtoOrcamentoDto.getQuantidade() + 1);
        assertNotEquals(produtoOrcamento.getOrcamento().getId(), produtoOrcamentoDto.getOrcamentoId() + 1);
    }

}
