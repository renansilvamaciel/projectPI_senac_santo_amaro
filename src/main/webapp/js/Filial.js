function mostrarModalExclusao(cnpj, nome) {
    $("#nomeFilial").html(nome);
    $("#cnpjFilial").val(cnpj);
    $('#modalExclusao').modal('show');
}

function excluirFilial() {
    var cnpjFilial = $("#cnpjFilial").val();
    $.get("FilialDeleta?cnpj=" + cnpjFilial, function (resposta) {
        $('#modalExclusao').modal('hide');
        window.location.reload();

    });

}


//função para exibir a modal
function mostrarModalAtualiza(idFilial, nome, cnpj, estado, rua, cep, numero, bairro) {

    $("#nomeFilialLabel").html(nome);
    $("#idFilialAtualiza").val(idFilial);
    $("#nomeFilialAtualiza").val(nome);
    $("#cnpjFilialAtualiza").val(cnpj);
    $("#estadoFilialAtualiza").val(estado);
    $("#ruaFilialAtualiza").val(rua);
    $("#cepFilialAtualiza").val(cep);
    $("#numeroFilialAtualiza").val(numero);
    $("#bairroFilialAtualiza").val(bairro);
    


    $('#modalAtualiza').modal('show');
}

function atualizarFilial() {

    var idFilial = $("#idFilialAtualiza").val();
    var nome = $("#nomeFilialAtualiza").val();
    var cnpj = $("#cnpjFilialAtualiza").val();
    var estado = $("#estadoFilialAtualiza").val();
    var rua = $("#ruaFilialAtualiza").val();
    var cep = $("#cepFilialAtualiza").val();
    var numero = $("#numeroFilialAtualiza").val();
    var bairro = $("#bairroFilialAtualiza").val();
    

    $.post('FilialAtualiza', {idFilial: idFilial, nome: nome, cnpj: cnpj, estado: estado,
         rua: rua, cep: cep, numero: numero, bairro: bairro}, function () {

        $('#modalExclusao').modal('hide');
        window.location.reload();

    });


}
function resetTabela() {
    window.location.href = "FilialServlet";
}

function voltarIndex() {
    window.location.href = "index.jsp";
}