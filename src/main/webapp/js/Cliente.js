function mostrarModalExclusao(cpf, nome) {
    $("#nomeCliente").html(nome);
    $("#cpfCliente").val(cpf);
    $('#modalExclusao').modal('show');
}

function excluirCliente() {
    var cpfCliente = $("#cpfCliente").val();
    $.get("ClienteDeleta?cpf=" + cpfCliente, function (resposta) {
        $('#modalExclusao').modal('hide');
        window.location.reload();

    });

}


//função para exibir a modal
function mostrarModalAtualiza(idCliente, nome, sexo, dataNascimento, cpf, rua, cep, numeroCasa, bairro, email, telefone) {

    $("#nomeClienteLabel").html(nome);
    $("#idClienteAtualiza").val(idCliente);
    $("#nomeClienteAtualiza").val(nome);
    $("#sexoClienteAtualiza").val(sexo);
    $("#dataNascimentoClienteAtualiza").val(dataNascimento);
    $("#cpfClienteAtualiza").val(cpf);
    $("#ruaClienteAtualiza").val(rua);
    $("#cepClienteAtualiza").val(cep);
    $("#numeroCasaClienteAtualiza").val(numeroCasa);
    $("#bairroClienteAtualiza").val(bairro);
    $("#emailClienteAtualiza").val(email);
    $("#telefoneClienteAtualiza").val(telefone);


    $('#modalAtualiza').modal('show');
}

function atualizarCliente() {

    var idCliente = $("#idClienteAtualiza").val();
    var nome = $("#nomeClienteAtualiza").val();
    var sexo = $("#sexoClienteAtualiza").val();
    var dataNascimento = $("#dataNascimentoClienteAtualiza").val();
    var cpf = $("#cpfClienteAtualiza").val();
    var rua = $("#ruaClienteAtualiza").val();
    var cep = $("#cepClienteAtualiza").val();
    var numeroCasa = $("#numeroCasaClienteAtualiza").val();
    var bairro = $("#bairroClienteAtualiza").val();
    var email = $("#emailClienteAtualiza").val();
    var telefone = $("#telefoneClienteAtualiza").val();   

    $.post('ClienteAtualiza', {idCliente: idCliente, nome: nome, sexo: sexo, data_nascimento: dataNascimento,
        cpf: cpf, rua: rua, cep: cep, numero_casa: numeroCasa, bairro: bairro, email: email,
        telefone: telefone}, function () {

        $('#modalExclusao').modal('hide');
        window.location.reload();

    });


}
function resetTabela() {
    window.location.href = "ClienteServlet";
}

function voltarIndex() {
    window.location.href = "/projectPI_senac_santo_amaro/protegido/index.jsp";
}