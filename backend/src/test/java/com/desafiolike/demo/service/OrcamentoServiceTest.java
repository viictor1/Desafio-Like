package com.desafiolike.demo.service;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.repository.OrcamentoRepository;
import com.desafiolike.demo.utils.DtoFactory;
import com.desafiolike.demo.utils.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class OrcamentoServiceTest {

    @InjectMocks
    private OrcamentoService orcamentoService;

    @Mock
    private OrcamentoRepository orcamentoRepository;

    @Mock
    private ProdutoOrcamentoService produtoOrcamentoService;

    private OrcamentoDto orcamentoDto;
    private List<Orcamento> orcamentosList;

    @BeforeEach
    void setup(){
        orcamentoDto = DtoFactory.createOrcamentoDtoNoId();
        Orcamento orcamentoSalvo = Factory.createOrcamento();
        orcamentosList = Factory.createOrcamentoList();

        when(orcamentoRepository.save(Mockito.any(Orcamento.class)))
                .thenReturn(orcamentoSalvo);

        when(produtoOrcamentoService.saveProdutos(Mockito.any(Orcamento.class)))
                .thenReturn(orcamentoSalvo.getProdutos());

        when(orcamentoRepository.findAll()).thenReturn(orcamentosList);


    }

    @Test
    public void saveOrcamentoTest(){
        OrcamentoDto savedDto = orcamentoService.addOrcamento(orcamentoDto);
        assertNotEquals(savedDto.getId(), 0);

        assertEquals(orcamentoDto.getNomeCliente(), savedDto.getNomeCliente());
        assertEquals(orcamentoDto.getData(), savedDto.getData());
        assertEquals(orcamentoDto.getProdutos().size(), savedDto.getProdutos().size());

        Mockito.verify(orcamentoRepository).save(Mockito.any(Orcamento.class));
    }

    @Test
    public void saveOrcamentoTestAssertNotEqualsWrongValues(){
        OrcamentoDto savedDto = orcamentoService.addOrcamento(orcamentoDto);
        assertNotEquals(savedDto.getId(), 0);

        assertNotEquals(orcamentoDto.getNomeCliente(), savedDto.getNomeCliente().concat("error"));
        assertNotEquals(orcamentoDto.getData(), new Date());
        assertNotEquals(orcamentoDto.getProdutos().size(), savedDto.getProdutos().size() + 1);

    }

    @Test
    public void getAllOrcamentosTest(){
        List<OrcamentoDto> orcamentosDto = orcamentoService.getOrcamentos();

        assertEquals(10, orcamentosDto.size());

        int i = 0;
        for(OrcamentoDto dto: orcamentosDto){
            Orcamento orcamento = orcamentosList.get(i);

            assertEquals(orcamento.getId(), dto.getId());
            assertEquals(orcamento.getNomeCliente(), dto.getNomeCliente());
            assertEquals(orcamento.getData(), dto.getData());

            i++;
        }
    }

}
