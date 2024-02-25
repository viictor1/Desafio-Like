var produtos = []


function adicionarProduto(){
    let nomeProduto = document.querySelector('#nomeProduto').value
    let valor = document.querySelector('#valor').value
    let quantidade = document.querySelector('#quantidade').value

    let produto = {
        nomeProduto: nomeProduto,
        valor: valor,
        quantidade: quantidade
    };

    produtos.push(produto)
    updateHTMLList()
    cleanProdutos()
}

function updateHTMLList(){
    let list = document.querySelector('#productsList');
    list.innerHTML = '';

    produtos.forEach((p, index) => {
        let li = document.createElement('li');
        li.innerHTML = p.nomeProduto + ' Valor: ' + p.valor + ' Quantidade: ' + p.quantidade + '  ';

        const remover = document.createElement('button');
        var img = document.createElement("img");
        img.src = "./assets/remover.svg";
        img.alt = "SVG Icon";

        remover.appendChild(img);
        remover.addEventListener('click', removerProduto)

        li.appendChild(remover);
        list.appendChild(li);
    });

    let totalCount = document.createElement('li');
    totalCount.textContent = 'Produtos Diferentes Totais: ' + produtos.length;
    list.appendChild(totalCount);
}

function removerProduto(index) {
    produtos.splice(index, 1);
    updateHTMLList();
}


function cleanProdutos(){
    document.querySelector('#nomeProduto').value = ''
    document.querySelector('#valor').value = ''
    document.querySelector('#quantidade').value = ''
}

function salvar(){
    if(produtos.length == 0){
        alert('Adicione algum produto')
        return;
    }

    let nomeCliente = document.querySelector('#nomeCliente').value
    let data = document.querySelector('#data').value

    cleanOrcamento()
    emptyProdutos()
}

function cleanOrcamento(){
    document.querySelector('#nomeCliente').value = ''
    document.querySelector('#data').value = ''
}

function emptyProdutos(){
    produtos = []
    let list = document.querySelector('#productsList')
    list.innerText = ''
}