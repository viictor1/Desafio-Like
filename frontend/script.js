var produtos = []
const apiURL = 'http://localhost:8080/orcamento'


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

    const dados = {
        nomeCliente: nomeCliente,
        data: data,
        produtos: produtos
    }

    sendRequest(dados)
    cleanOrcamento()
    emptyProdutos()
}

function sendRequest(dados){

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

function loadOrcamentos(){
    const outputElement = document.querySelector('#orcamentosList');
    outputElement.innerHTML = ''

    const requestOptions = {
        method: 'GET',
    };

    fetch(apiURL, requestOptions)
    .then(response => {
        if (!response.ok) {
        throw new Error('Network response was not ok');
        }
        return response.json();
    })
    .then(data => {
        data.forEach(entry => {
            addOrcamentoToList(entry, outputElement)
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });

}

function addOrcamentoToList(entry, outputElement){
    
    const li = document.createElement('li');
    const clientName = document.createElement('p');
    const date = document.createElement('p');
    const productList = document.createElement('ul');

    clientName.textContent = `Nome do Cliente: ${entry.nomeCliente}`;
    date.textContent = `Data: ${entry.data}`;
    
    entry.produtos.forEach(product => {
        const productItem = document.createElement('li');
        productItem.textContent = `Produto: ${product.nome}, Valor: ${product.valor}, Quantidade: ${product.quantidade}`;
        productList.appendChild(productItem);
    });

    li.appendChild(clientName);
    li.appendChild(date);
    li.appendChild(productList);
    li.classList.add('list-group-item')

    li.addEventListener('mouseover', () =>{
        li.classList.add('active')
    })

    li.addEventListener('mouseleave', () =>{
        li.classList.remove('active')
    })

    outputElement.appendChild(li);
}