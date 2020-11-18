var formLogin = document.getElementById('formLoginFuncionario');
formLogin.addEventListener("submit", validarLogin);

function validarLogin(evt) {
   
    var campoCpf = document.getElementById('login');
    var campoSenha = document.getElementById('senha');
    var msgCampoCpf = document.querySelector('.msg-CampoCpf');
    var msgCampoSenha = document.querySelector('.msg-CampoSenha');
    
    var error = false;
    if (campoCpf.value === "") {
        msgCampoCpf.innerHTML = 'Preencher o campo de cpf';
        msgCampoCpf.style.display = 'block';
        error = true;
        document.getElementById('login').focus();
    } else {
        msgCampoCpf.style.display = 'none';
    }
    
    if (campoSenha.value === "") {
        msgCampoSenha.innerHTML = 'Preencher o campo de senha';
        msgCampoSenha.style.display = 'block';
        error = true;
        document.getElementById('senha').focus();
    } else {
        msgCampoSenha.style.display = 'none';
    }
    
    if (error) {
        evt.preventDefault();
    }

}

