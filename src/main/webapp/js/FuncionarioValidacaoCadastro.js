var formCadastroFuncionario = document.getElementById('form_cadastroFuncionario');
formCadastroFuncionario.addEventListener("submit", validarCadastroFuncionario);

function validarCadastroFuncionario(evt) {

    var campoNome = document.getElementById('nome');
    var campoSexo = document.getElementById('sexo');
    var campoDataNascimento = document.getElementById('data_nascimento');
    var campoCpf = document.getElementById('cpf');
    var campoRua = document.getElementById('rua');
    var campoCep = document.getElementById('cep');
    var campoNumeroCasa = document.getElementById('numero_casa');
    var campoBairro = document.getElementById('bairro');
    var campoEmail = document.getElementById('email');
    var campoTelefone = document.getElementById('telefone');
    var campoCargo = document.getElementById('cargo');
    var campoSenha = document.getElementById('senha');
    var campoSenhaConfirmar = document.getElementById('senhaConfirmar');

    var msgCampoNome = document.querySelector('.msg-CampoNome');
    var msgCampoSexo = document.querySelector('.msg-CampoSexo');
    var msgCampoDataNascimento = document.querySelector('.msg-CampoDataNascimento');
    var msgCampoCpf = document.querySelector('.msg-CampoCpf');
    var msgCampoRua = document.querySelector('.msg-CampoRua');
    var msgCampoCep = document.querySelector('.msg-CampoCep');
    var msgCampoNumeroCasa = document.querySelector('.msg-CampoNumeroCasa');
    var msgCampoBairro = document.querySelector('.msg-CampoBairro');
    var msgCampoEmail = document.querySelector('.msg-CampoEmail');
    var msgCampoTelefone = document.querySelector('.msg-CampoTelefone');
    var msgCampoCargo = document.querySelector('.msg-CampoCargo');
    var msgCampoSenha = document.querySelector('.msg-CampoSenha');
    var msgCampoSenhaConfirmar = document.querySelector('.msg-CampoSenhaConfirmar');



    var error = false;


    if (campoNome.value === "") {
        msgCampoNome.innerHTML = 'Preencher o campo de nome';
        msgCampoNome.style.display = 'block';
        campoNome.focus();
        error = true;
    } else {
        msgCampoNome.style.display = 'none';
    }

    if (campoSexo.value === "") {
        msgCampoSexo.innerHTML = 'Preencher o campo de sexo';
        msgCampoSexo.style.display = 'block';
        campoSexo.focus();
        error = true;
    } else {
        msgCampoSexo.style.display = 'none';
    }

    if (campoDataNascimento.value === "") {
        msgCampoDataNascimento.innerHTML = 'Preencher o campo de Data';
        msgCampoDataNascimento.style.display = 'block';
        campoDataNascimento.focus();
        error = true;
    } else {
        msgCampoDataNascimento.style.display = 'none';
    }


    if (campoCpf.value === "") {
        msgCampoCpf.innerHTML = 'Preencher o campo de Cpf';
        msgCampoCpf.style.display = 'block';
        campoCpf.focus();
        error = true;
    } else {
        msgCampoCpf.style.display = 'none';
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

    if (campoNumeroCasa.value === "") {
        msgCampoNumeroCasa.innerHTML = 'Preencher o campo de N°Casa';
        msgCampoNumeroCasa.style.display = 'block';
        campoNumeroCasa.focus();
        error = true;
    } else {
        if (campoNumeroCasa.value < 0) {
            msgCampoNumeroCasa.innerHTML = 'Preencher o campo de N°Casa com valor positivo';
            msgCampoNumeroCasa.style.display = 'block';
            campoNumeroCasa.focus();
            error = true;
        } else {
            msgCampoNumeroCasa.style.display = 'none';
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

    if (campoEmail.value === "") {
        msgCampoEmail.innerHTML = 'Preencher o campo de Email';
        msgCampoEmail.style.display = 'block';
        campoEmail.focus();
        error = true;
    } else {
        msgCampoEmail.style.display = 'none';
    }

    if (campoTelefone.value === "") {
        msgCampoTelefone.innerHTML = 'Preencher o campo de Telefone';
        msgCampoTelefone.style.display = 'block';
        campoTelefone.focus();
        error = true;
    } else {
        msgCampoTelefone.style.display = 'none';
    }

    if (campoCargo.value === "") {
        msgCampoCargo.innerHTML = 'Preencher o campo de Cargo';
        msgCampoCargo.style.display = 'block';
        campoCargo.focus();
        error = true;
    } else {
        msgCampoCargo.style.display = 'none';
    }

    if (campoSenha.value === "") {
        msgCampoSenha.innerHTML = 'Preencher o campo de Senha';
        msgCampoSenha.style.display = 'block';
        campoSenha.focus();
        error = true;
    } else {
        msgCampoTelefone.style.display = 'none';
    }

    if (campoSenhaConfirmar.value === "") {
        msgCampoSenhaConfirmar.innerHTML = 'Preencher o campo de Confirmar a senha';
        msgCampoSenhaConfirmar.style.display = 'block';
        campoSenhaConfirmar.focus();
        error = true;
    } else {
        msgCampoTelefone.style.display = 'none';
    }

    if (campoSenha.value !== "" && campoSenhaConfirmar.value !== "") {
        if (campoSenha.value !== campoSenhaConfirmar.value) {
            msgCampoSenha.innerHTML = 'Você digitou sua senha errada em algum dos campos';
            msgCampoSenhaConfirmar.innerHTML = 'Você digitou sua senha errada em algum dos campos';
            msgCampoSenhaConfirmar.style.display = 'block';
            campoSenha.value = "";
            campoSenhaConfirmar.value = "";
            campoSenha.focus();
            error = true;
        } else {
            msgCampoTelefone.style.display = 'none';
        }
    }


    if (error) {
        evt.preventDefault();
    }
}