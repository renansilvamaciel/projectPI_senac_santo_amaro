var formBusca = document.getElementById('formBusca');
formBusca.addEventListener("submit", validarBusca);

function validarBusca(evt) {
    var campoBusca = document.getElementById('valorBusca');
    var msgCampoBusca = document.querySelector('.msg-CampoBusca');
    var error = false;
    if (campoBusca.value === "") {
        msgCampoBusca.innerHTML = 'Preencher o campo de busca';
        msgCampoBusca.style.display = 'block';
        error = true;
        document.getElementById('valorBusca').focus();
    } else {
        msgCampoBusca.style.display = 'none';
    }
    if (error) {
        evt.preventDefault();
    }

}