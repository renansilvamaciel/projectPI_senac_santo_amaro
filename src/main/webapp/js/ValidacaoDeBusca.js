var formBusca = document.getElementById('formBusca');
formBusca.addEventListener("submit", validaBusca);


function validaBusca(evt){
     var campoBusca = document.getElementById('buscaProduto');
     var contErroBusca=0;
    
    var caixa_campoBusca = document.querySelector('.msg-CampoBusca');
    if (campoBusca.value == "") {
        caixa_campoBusca.innerHTML = 'Preencher o campo de busca';
        caixa_campoBusca.style.display = 'block';
        contErroBusca += 1;
        document.getElementById('buscaProduto').focus();
    }  else {
        caixa_campoBusca.style.display = 'none';
    }
    
   
    if (contErroBusca > 0) {
        evt.preventDefault();
    }
    
    console.log("teste");

}