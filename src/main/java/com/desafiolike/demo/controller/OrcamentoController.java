package com.desafiolike.demo.controller;

import com.desafiolike.demo.entity.Orcamento;
import com.desafiolike.demo.service.OrcamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/orcamento")
public class OrcamentoController {

    @Autowired
    private OrcamentoService orcamentoService;

    @PostMapping
    public void addOrcamento(Orcamento orcamento){
        orcamentoService.addOrcamento(orcamento);
    }

}
