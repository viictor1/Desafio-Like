package com.desafiolike.demo.dto;

import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.entity.ProdutoOrcamento;
import com.desafiolike.demo.utils.DtoFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@ExtendWith(SpringExtension.class)
public class OrcamentoDtoTest {

    @Mock
    private Orcamento orcamento;

    @InjectMocks
    private OrcamentoDto orcamentoDto;

    @BeforeEach
    public void setUp() {
        orcamentoDto = DtoFactory.createOrcamentoDto();
        orcamento = orcamentoDto.convertToEntity();
    }

    @Test
    public void testConvertDtoToOrcamento(){

        assertEquals(orcamento.getNomeCliente(), orcamentoDto.getNomeCliente());
        assertEquals(orcamento.getData(), orcamentoDto.getData());

        int i = 0;

        for(ProdutoOrcamento p : orcamento.getProdutos()){
            ProdutoOrcamentoDto dtoP = orcamentoDto.getProdutos().get(i);

            assertEquals(p.getNome(), dtoP.getNome());
            assertEquals(p.getQuantidade(), dtoP.getQuantidade());
            assertEquals(p.getValor(), dtoP.getValor());

            i++;
        }
    }

    @Test
    public void testConvertDtoToOrcamentoNotEqualsWrongValues(){

        assertNotEquals(orcamento.getNomeCliente(), orcamentoDto.getNomeCliente().concat("erro"));
        assertNotEquals(orcamento.getData(), new Date(1920));

        int i = 0;

        for(ProdutoOrcamento p : orcamento.getProdutos()){
            ProdutoOrcamentoDto dtoP = orcamentoDto.getProdutos().get(i);

            assertNotEquals(p.getNome(), dtoP.getNome().concat("erro"));
            assertNotEquals(p.getQuantidade(), dtoP.getQuantidade() + 1);
            assertNotEquals(p.getValor(), dtoP.getValor() + 1F);

            i++;
        }

    }
}
