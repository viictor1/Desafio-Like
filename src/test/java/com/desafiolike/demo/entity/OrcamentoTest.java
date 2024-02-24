package com.desafiolike.demo.entity;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.dto.ProdutoOrcamentoDto;
import com.desafiolike.demo.utils.Factory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
public class OrcamentoTest {

    @InjectMocks
    private Orcamento orcamento;

    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testConvertOrcamentoToDto(){
        orcamento = Factory.createOrcamento();

        OrcamentoDto orcamentoDto = orcamento.convertToDto();

        assertEquals(orcamento.getId(), orcamentoDto.getId());
        assertEquals(orcamento.getNomeCliente(), orcamentoDto.getNomeCliente());
        assertEquals(orcamento.getData(), orcamentoDto.getData());

        int i = 0;

        for(ProdutoOrcamento p : orcamento.getProdutos()){
            ProdutoOrcamentoDto dtoP = orcamentoDto.getProdutos().get(i);

            assertEquals(p.getNome(), dtoP.getNome());
            assertEquals(p.getQuantidade(), dtoP.getQuantidade());
            assertEquals(p.getValor(), dtoP.getValor());
            assertEquals(p.getOrcamento().getId(), dtoP.getOrcamentoId());

            i++;
        }
    }

    @Test
    public void testConvertToDtoNotEqualsWrongValues(){
        orcamento = Factory.createOrcamento();

        OrcamentoDto orcamentoDto = orcamento.convertToDto();

        assertNotEquals(orcamento.getId(), orcamentoDto.getId() + 1);
        assertNotEquals(orcamento.getNomeCliente(), orcamentoDto.getNomeCliente().concat("erro"));
        assertNotEquals(orcamento.getData(), new Date(1920));

        int i = 0;

        for(ProdutoOrcamento p : orcamento.getProdutos()){
            ProdutoOrcamentoDto dtoP = orcamentoDto.getProdutos().get(i);

            assertNotEquals(p.getNome(), dtoP.getNome().concat("erro"));
            assertNotEquals(p.getQuantidade(), dtoP.getQuantidade() + 1);
            assertNotEquals(p.getValor(), dtoP.getValor() + 1F);
            assertNotEquals(p.getOrcamento().getId(), dtoP.getOrcamentoId() + 1);

            i++;
        }

    }
}
