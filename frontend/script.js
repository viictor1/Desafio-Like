var produtos = []


function adicionarProduto(){
    let nomeProduto = document.querySelector('#nomeProduto').value
    let valor = document.querySelector('#valor').value
    let quantidade = document.querySelector('#quantidade').value

    let produto = {
        nome: nomeProduto,
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
        li.innerHTML = p.nome + ' Valor: ' + p.valor + ' Quantidade: ' + p.quantidade + '  ';

        const remover = document.createElement('button');
        remover.addEventListener('click', removerProduto)

        var img = document.createElement("img");
        img.src = "./assets/remover.svg";
        img.alt = "SVG Icon";
        remover.appendChild(img);

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

    const apiURL = 'http://localhost:8080/orcamento'
    const dados = {
        nomeCliente: nomeCliente,
        data: data,
        produtos: produtos
    }

    sendRequest(apiURL, dados)
    cleanOrcamento()
    emptyProdutos()
}

function sendRequest(apiURL, dados){

    const requestOptions = {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(dados),
    };

    fetch(apiURL, requestOptions)
    .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok')
        }
        return response.json()
      })
      .catch(error => {
        console.error('Error:', error)
      });

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