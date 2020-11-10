var formCadastroFilial = document.getElementById('form_cadastroFilial');
formCadastroFilial.addEventListener("submit", validarCadastroFilial);

function validarCadastroFilial(evt) {

    var campoNome = document.getElementById('nome');
    var campoCnpj = document.getElementById('cnpj');
    var campoEstado = document.getElementById('estado');
    var campoRua = document.getElementById('rua');
    var campoCep = document.getElementById('cep');
    var campoNumero = document.getElementById('numero');
    var campoBairro = document.getElementById('bairro');


    var msgCampoNome = document.querySelector('.msg-CampoNome');
    var msgCampoCnpj = document.querySelector('.msg-CampoCnpj');
    var msgCampoEstado = document.querySelector('.msg-CampoEstado');
    var msgCampoRua = document.querySelector('.msg-CampoRua');
    var msgCampoCep = document.querySelector('.msg-CampoCep');
    var msgCampoNumero = document.querySelector('.msg-CampoNumero');
    var msgCampoBairro = document.querySelector('.msg-CampoBairro');

    var error = false;


    if (campoNome.value === "") {
        msgCampoNome.innerHTML = 'Preencher o campo de Nome';
        msgCampoNome.style.display = 'block';
        campoNome.focus();
        error = true;
    } else {
        msgCampoNome.style.display = 'none';
    }

    if (campoCnpj.value === "") {
        msgCampoCnpj.innerHTML = 'Preencher o campo de Cnpj';
        msgCampoCnpj.style.display = 'block';
        campoCnpj.focus();
        error = true;
    } else {
        msgCampoCpf.style.display = 'none';
    }

    if (campoEstado.value === "") {
        msgCampoEstado.innerHTML = 'Preencher o campo de Estado';
        msgCampoEstado.style.display = 'block';
        campoEstado.focus();
        error = true;
    } else {
        msgCampoEstado.style.display = 'none';
    }

    if (campoRua.value === "") {
        msgCampoRua.innerHTML = 'Preencher o campo de Rua';
        msgCampoRua.style.display = 'block';
        campoRua.focus();
        error = true;
    } else {
        msgCampoRua.style.display = 'none';
    }

    if (campoCep.value === "") {
        msgCampoCep.innerHTML = 'Preencher o campo de Cep';
        msgCampoCep.style.display = 'block';
        campoCep.focus();
        error = true;
    } else {
        msgCampoCep.style.display = 'none';
    }

    if (campoNumero.value === "") {
        msgCampoNumero.innerHTML = 'Preencher o campo de N°Casa';
        msgCampoNumero.style.display = 'block';
        campoNumero.focus();
        error = true;
    } else {
        if (campoNumero.value < 0) {
            msgCampoNumero.innerHTML = 'Preencher o campo de N° Filial com valor positivo';
            msgCampoNumero.style.display = 'block';
            campoNumero.focus();
            error = true;
        } else {
            msgCampoNumero.style.display = 'none';
        }

    }

    if (campoBairro.value === "") {
        msgCampoBairro.innerHTML = 'Preencher o campo de Bairro';
        msgCampoBairro.style.display = 'block';
        campoBairro.focus();
        error = true;
    } else {
        msgCampoBairro.style.display = 'none';
    }


    if (error) {
        evt.preventDefault();
    }
}