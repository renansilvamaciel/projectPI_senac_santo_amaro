var formVendaPlanos = document.getElementById('formaVendaPlanos');
formVendaPlanos.addEventListener("submit", validacaoVendaPlanos);
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

function voltarIndex() {
    window.location.href = "/projectPI_senac_santo_amaro/protegido/index.jsp";
}

function validacaoVendaPlanos(evt) {
    var campoNome = document.getElementById('nome');
    var campoCpf = document.getElementById('cpf');
    var msgCampoBusca = document.querySelector('.msg-CampoBusca');
    var error = false;
    if (campoCpf === null && campoNome === null) {
        alert("Cliente deve estar Cadastrado para poder efetuar uma venda para Assinantes");
        msgCampoBusca.innerHTML = 'Pesquise o cliente aqui para prosseguir a venda!';
        msgCampoBusca.style.display = 'block';
        error = true;
        document.getElementById('valorBusca').focus();
    } else {
        msgCampoBusca.style.display = 'nome';
    }

    if (error) {
        evt.preventDefault();
    }

}