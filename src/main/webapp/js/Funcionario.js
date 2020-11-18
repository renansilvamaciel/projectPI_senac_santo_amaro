function mostrarModalExclusao(cpf, nome) {
    $("#nomeFuncionario").html(nome);
    $("#cpfFuncionario").val(cpf);
    $('#modalExclusao').modal('show');
}

function excluirFuncionario() {
    var cpfFuncionario = $("#cpfFuncionario").val();
    $.get("FuncionarioDeleta?cpf=" + cpfFuncionario, function (resposta) {
        $('#modalExclusao').modal('hide');
        window.location.reload();

    });

}


//função para exibir a modal
function mostrarModalAtualiza(idFuncionario, nome, sexo, dataNascimento, cpf, rua, cep, numeroCasa, bairro, email, telefone, cargo, filial, senha) {

    $("#nomeFuncionarioLabel").html(nome);
    $("#idFuncionarioAtualiza").val(idFuncionario);
    $("#nomeFuncionarioAtualiza").val(nome);
    $("#sexoFuncionarioAtualiza").val(sexo);
    $("#dataNascimentoFuncionarioAtualiza").val(dataNascimento);
    $("#cpfFuncionarioAtualiza").val(cpf);
    $("#ruaFuncionarioAtualiza").val(rua);
    $("#cepFuncionarioAtualiza").val(cep);
    $("#numeroCasaFuncionarioAtualiza").val(numeroCasa);
    $("#bairroFuncionarioAtualiza").val(bairro);
    $("#emailFuncionarioAtualiza").val(email);
    $("#telefoneFuncionarioAtualiza").val(telefone);
    $("#cargoFuncionarioAtualiza").val(cargo);
    $("#filialFuncionarioAtualiza").val(filial);
    $("#senhaFuncionarioAtualiza").val(senha);


    $('#modalAtualiza').modal('show');
}
function atualizarFuncionario() {
   
    var idFuncionario = $("#idFuncionarioAtualiza").val();
    var nome = $("#nomeFuncionarioAtualiza").val();
    var sexo = $("#sexoFuncionarioAtualiza").val();
    var dataNascimento = $("#dataNascimentoFuncionarioAtualiza").val();
    var cpf = $("#cpfFuncionarioAtualiza").val();
    var rua = $("#ruaFuncionarioAtualiza").val();
    var cep = $("#cepFuncionarioAtualiza").val();
    var numeroCasa = $("#numeroCasaFuncionarioAtualiza").val();
    var bairro = $("#bairroFuncionarioAtualiza").val();
    var email = $("#emailFuncionarioAtualiza").val();
    var telefone = $("#telefoneFuncionarioAtualiza").val();
    var cargo = $("#cargoFuncionarioAtualiza").val();
    var filial = $("#filialFuncionarioAtualiza").val();
    var senha = $("#senhaFuncionarioAtualiza").val();

    $.post('FuncionarioAtualiza', {idFuncionario: idFuncionario, nome: nome, sexo: sexo, data_nascimento: dataNascimento,
        cpf: cpf, rua: rua, cep: cep, numero_casa: numeroCasa, bairro: bairro, email: email,
        telefone: telefone, cargo: cargo, filial: filial, senha: senha}, function () {

        $('#modalExclusao').modal('hide');
        window.location.reload();

    });


}
function resetTabela() {
    window.location.href = "FuncionarioServlet";
}

function voltarIndex() {
    window.location.href = "/projectPI_senac_santo_amaro/protegido/index.jsp";
}