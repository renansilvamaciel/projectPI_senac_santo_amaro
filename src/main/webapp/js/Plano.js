
function mostrarModalExclusao(nome) {
    $("#nomePlano").html(nome);
    $("#nomePlano").val(nome);
    $('#modalExclusao').modal('show');
}

function excluirPlano() {
    var nomePlano = $("#nomePlano").val();
    $.get("PlanoDeleta?nome=" + nomePlano, function (resposta) {
        $('#modalExclusao').modal('hide');
        window.location.reload();

    });

}


//função para exibir a modal
function mostrarModalAtualiza(nome, descricao, valor) {

    $("#nomePlanoLabel").html(nome);
    $("#nomePlanoAtualiza").val(nome);
    $("#descricaoPlanoAtualiza").val(descricao);
    $("#valorPlanoAtualiza").val(valor);


    $('#modalAtualiza').modal('show');
}

function atualizarPlano() {

    var nome = $("#nomePlanoAtualiza").val();
    var descricao = $("#descricaoPlanoAtualiza").val();
    var valor = $("#valorPlanoAtualiza").val();



    $.post('PlanoAtualiza', {nome: nome, descricao: descricao, valor: valor}, function () {

        $('#modalExclusao').modal('hide');
        window.location.reload();

    });


}
function resetTabela() {
    window.location.href = "PlanoServlet";
}

function voltarIndex() {
    window.location.href = "/projectPI_senac_santo_amaro/protegido/index.jsp";
}