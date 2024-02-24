package com.desafiolike.demo.dto;

import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;
import com.desafiolike.demo.utils.DtoFactory;
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
public class ProdutoOrcamentoDtoTest {

    @Mock
    private ProdutoOrcamento produtoOrcamento;

    @InjectMocks
    private ProdutoOrcamentoDto produtoOrcamentoDto;

    @InjectMocks
    private OrcamentoDto orcamento;

    @BeforeEach
    public void setUp() {
        orcamento = DtoFactory.createOrcamentoDto();
        produtoOrcamentoDto = DtoFactory.createProdutoOrcamentoDto(orcamento);
        produtoOrcamento = produtoOrcamentoDto.convertToEntity();
    }

    @Test
    public void convertDtoToProduto() {
        assertEquals(produtoOrcamento.getNome(), produtoOrcamentoDto.getNome());
        assertEquals(produtoOrcamento.getValor(), produtoOrcamentoDto.getValor());
        assertEquals(produtoOrcamento.getQuantidade(), produtoOrcamentoDto.getQuantidade());
    }

    @Test
    public void convertDtoToProdutoNotEqualsWrongValues(){
        assertNotEquals(produtoOrcamento.getNome(), produtoOrcamentoDto.getNome().concat("erro"));
        assertNotEquals(produtoOrcamento.getValor(), produtoOrcamentoDto.getValor() + 1F);
        assertNotEquals(produtoOrcamento.getQuantidade(), produtoOrcamentoDto.getQuantidade() + 1);
    }

}
