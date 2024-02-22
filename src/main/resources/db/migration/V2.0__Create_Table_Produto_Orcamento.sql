create table produtoOrcamento(
    id INT PRIMARY KEY,
    orcamento_id int,
    nome VARCHAR(45),
    valor float,
    quantidade int
    FOREIGN KEY(orcamento_id) REFERENCES orcamento(id)
)