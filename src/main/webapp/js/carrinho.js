
let valorTotal = document.querySelector("#total");
//alert(moedaParaFloat(valorTotal.innerHTML));

//conversao de valor em moeda para float
function moedaParaFloat(valor) {
    let textoLimpo = valor.replace("R$", "").replace(",", ".");
    return  parseFloat(textoLimpo);
}

//conversao de float para valor do tipo moeda
function floatParaMoeda(valor) {
    let ValorFormatado = (valor < 1 ? "0" : "") + Math.floor(valor * 100);
    ValorFormatado = "R$ " + ValorFormatado;
    return ValorFormatado.substr(0, ValorFormatado.length - 2) + "," + ValorFormatado.substr(-2);

}

//pega valor total do do carrinho
function retornaTotal() {
    let valorTotal = document.querySelector("#total");
    return moedaParaFloat(valorTotal.innerHTML);
}

//escreve/altera o valor total do carrinho
function escreveTotal(valor) {
    let valorTotal = document.querySelector("#total");
    valorTotal.innerHTML = floatParaMoeda(valor);

}

function calculaTotalProdutos() {
    let todosProdutos = document.querySelectorAll(".totalItem");
    let totalProdutosCarrinho= 0;
    
    for(let posicao = 0; posicao < todosProdutos.length; posicao++){
        let umPreco = moedaParaFloat(todosProdutos[posicao].innerHTML);
        totalProdutosCarrinho += umPreco;
    }
    
    return totalProdutosCarrinho;
}

window.onload = (function(){
    escreveTotal(calculaTotalProdutos());
    
});













                