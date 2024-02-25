package com.desafiolike.demo.controller;

import com.desafiolike.demo.dto.OrcamentoDto;
import com.desafiolike.demo.service.OrcamentoService;
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

    @PostMapping
    public ResponseEntity<OrcamentoDto> addOrcamento(@RequestBody OrcamentoDto orcamento){
        orcamento = orcamentoService.addOrcamento(orcamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(orcamento.getId()).toUri();

        return ResponseEntity.created(uri).body(orcamento);
    }

    @GetMapping
    public ResponseEntity<List<OrcamentoDto>> getOrcamentos(){
        List<OrcamentoDto> orcamentos = orcamentoService.getOrcamentos();
        return ResponseEntity.ok().body(orcamentos);
    }

}
