var form = document.getElementById('form_cadastroProduto');
form.addEventListener("submit", validaCadastro);


function validaCadastro(evt) {
    var nome = document.getElementById('nome');
    var familia = document.getElementById('familia');
    var filial = document.getElementById('filial');
    var preco = document.getElementById('preco');
    var quantidade = document.getElementById('quantidade');
    var descricao = document.getElementById('descricao');
    var filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
    var contErro = 0;

    //valida nome validações (campo vazio, tamanho min, tamanho max.)
    var caixa_nome = document.querySelector('.msg-nome');
    if (nome.value == "") {
        caixa_nome.innerHTML = 'Preencher o nome do Produto';
        caixa_nome.style.display = 'block';
        contErro += 1;
        document.getElementById('nome').focus();
    } else if (nome.value.length < 3) {
        caixa_nome.innerHTML = 'Mínimo de 3 caracteres';
        caixa_nome.style.display = 'block';
        contErro += 1;
        document.getElementById('nome').focus();
    } else if (nome.value.length > 45) {
        caixa_nome.innerHTML = 'Máximo de 45 caracteres';
        caixa_nome.style.display = 'block';
        contErro += 1;
        document.getElementById('nome').focus();
    } else {
        caixa_nome.style.display = 'none';
    }

    //valida familia validações (Seleção)
    var caixa_familia = document.querySelector('.msg-familia');
    if (familia.value == "0") {
        caixa_familia.innerHTML = 'Selecione a famimília';
        caixa_familia.style.display = 'block';
        contErro += 1;
        document.getElementById('familia').focus();
    } else {
        caixa_familia.style.display = 'none';
    }

    //valida filial validações (Seleção)
    var caixa_filial = document.querySelector('.msg-filial');
    if (filial.value == "0") {
        caixa_filial.innerHTML = 'Selecione a filial';
        caixa_filial.style.display = 'block';
        contErro += 1;
        document.getElementById('filial').focus();
    } else {
        caixa_filial.style.display = 'none';
    }

    //valida preco
    var caixa_preco = document.querySelector('.msg-preco');
    if (preco.value == "") {
        caixa_preco.style.display = 'block';
        caixa_preco.innerHTML = 'Insira um preço';
        contErro += 1;
        document.getElementById('preco').focus();

    } else {

        if (Number.parseFloat(preco.value)) {


            var valorOginal = preco.value;

            const regex = /,/g;
            var valorSemVirgula = valorOginal.replace(regex, '.');
            console.log(valorSemVirgula);
            document.getElementById('preco').value = valorSemVirgula;



            console.log("consegui converte");
            console.log(preco.value);
            caixa_preco.style.display = 'none';
        } else {
            console.log("não consegui converte");
            console.log(preco.value);

            caixa_preco.style.display = 'block';
            caixa_preco.innerHTML = 'Insira um valor inteiro ou com virgula';
            contErro += 1;
            document.getElementById('preco').focus();

        }
    }

    //valida quantidade
    var caixa_quantidade = document.querySelector('.msg-quantidade');
    if (quantidade.value == "") {
        caixa_quantidade.style.display = 'block';
        caixa_quantidade.innerHTML = 'Insira uma quantidade';
        contErro += 1;
        document.getElementById('quantidade').focus();

    } else {

        if (Number.parseInt(quantidade.value)) {


            var teste = Number.parseInt(quantidade.value);

            document.getElementById('quantidade').value = teste;


            console.log("consegui converte para inteiro");
            console.log(quantidade.value);
            console.log(teste);
            caixa_quantidade.style.display = 'none';
        } else {
            console.log("não consegui converte para inteiro");
            console.log(quantidade.value);

            caixa_quantidade.style.display = 'block';
            caixa_quantidade.innerHTML = 'Insira um valor inteiro';
            contErro += 1;
            document.getElementById('quantidade').focus();

        }
    }
    
    //valida descricao
    var caixa_descricao = document.querySelector('.msg-descricao');
    if (descricao.value == "") {
        caixa_descricao.style.display = 'block';
        caixa_descricao.innerHTML = 'Insira uma descrição';
        contErro += 1;
        document.getElementById('descricao').focus();

    } else if (descricao.value.length > 100) {
        caixa_descricao.style.display = 'block';
        caixa_descricao.innerHTML = 'Só pode conter 100 caracteres';
        contErro += 1;
        document.getElementById('descricao').focus();

    } else {
        caixa_descricao.style.display = 'none';
    }

    if (contErro > 0) {
        evt.preventDefault();
    }


}

