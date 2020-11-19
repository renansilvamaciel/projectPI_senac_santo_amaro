var formCadastroPlano = document.getElementById('form_cadastroPlano');
formCadastroPlano.addEventListener("submit", validarCadastroPlano);

function validarCadastroPlano(evt) {

    var campoNome = document.getElementById('nome');
    var campoDescricao = document.getElementById('descricao');
    var campoValor = document.getElementById('valor');

    var msgCampoNome = document.querySelector('.msg-CampoNome');
    var msgCampoDescricao = document.querySelector('.msg-CampoDescricao');
    var msgCampoValor = document.querySelector('.msg-CampoValor');


    var error = false;


    if (campoNome.value === "") {
        msgCampoNome.innerHTML = 'Preencher o campo de Nome';
        msgCampoNome.style.display = 'block';
        campoNome.focus();
        error = true;
    } else {
        msgCampoNome.style.display = 'none';
    }

    if (campoDescricao.value === "") {
        msgCampoDescricao.innerHTML = 'Preencher o campo de Descrição';
        msgCampoDescricao.style.display = 'block';
        campoDescricao.focus();
        error = true;
    } else {
        msgCampoDescricao.style.display = 'none';
    }

    if (campoValor.value === "") {
        msgCampoValor.innerHTML = 'Preencher o campo de valor';
        msgCampoValor.style.display = 'block';
        campoValor.focus();
        error = true;
    } else {
        if (campoValor.value < 0) {
            msgCampoValor.innerHTML = 'Preencher o campo de valor com valor positivo';
            msgCampoValor.style.display = 'block';
            campoValor.focus();
            error = true;
        } else {
            msgCampoValor.style.display = 'none';
        }

    }


    if (error) {
        evt.preventDefault();
    }
}