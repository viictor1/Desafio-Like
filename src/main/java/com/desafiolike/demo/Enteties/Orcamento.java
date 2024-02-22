package com.desafiolike.demo.Enteties;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "orcamento")
public class Orcamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nomeCliente;

    @Column
    private Date data;

    public Orcamento() {
    }

    public Orcamento(int id, String nomeCliente, Date data) {
        this.id = id;
        this.nomeCliente = nomeCliente;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
