package com.desafiolike.demo.controller;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.service.OrcamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @Operation(summary = "Adicionar Orcamento", description = "Enviar orcamento para ser salvo no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sucesso",
                    content =  @Content(schema = @Schema(implementation = OrcamentoDto.class))),
            @ApiResponse(responseCode = "500", description = "Erro no sistema",
                    content = @Content(schema = @Schema(implementation = Void.class))),
    })
    @PostMapping
    public ResponseEntity<OrcamentoDto> addOrcamento(@RequestBody OrcamentoDto orcamento){
        orcamento = orcamentoService.addOrcamento(orcamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(orcamento.getId()).toUri();

        return ResponseEntity.created(uri).body(orcamento);
    }

    @Operation(summary = "Selecionar Orcamentos", description = "Retorna todos os orcamentos em formato JSON")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso",
                    content =  @Content(schema = @Schema(implementation = OrcamentoDto.class))),
            @ApiResponse(responseCode = "500", description = "Erro no sistema",
                    content = @Content(schema = @Schema(implementation = Void.class))),
    })
    @GetMapping
    public ResponseEntity<List<OrcamentoDto>> getOrcamentos(){
        List<OrcamentoDto> orcamentos = orcamentoService.getOrcamentos();
        return ResponseEntity.ok().body(orcamentos);
    }

}
