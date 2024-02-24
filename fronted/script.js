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
    let list = document.querySelector('#productsList')
    list.innerText = ''
    produtos.forEach( (p) => {
        let li = document.createElement('li');
        li.innerText = p.nomeProduto + ' Valor: ' + p.valor + ' Quantidade: ' + p.quantidade;
        list.appendChild(li);
    })
    list.innerText += '\n\nProdutos Diferentes Totais: ' + produtos.length
}

function cleanProdutos(){
    document.querySelector('#nomeProduto').value = ''
    document.querySelector('#valor').value = ''
    document.querySelector('#quantidade').value = ''
}