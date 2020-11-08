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
    window.location.href = "index.jsp";
}

function validacaoVendaPlanos(evt) {
    var campoNome = document.getElementById('nome');
    var campoCpf = document.getElementById('cpf');
    var msgCampoBusca = document.querySelector('.msg-CampoBusca');
    var error = false;
    if (campoCpf === null && campoNome === null) {
        alert("Cliente deve estar Cadastrado para poder efetuar uma venda de Planos");
        msgCampoBusca.innerHTML = 'Pesquise o cliente aqui para prosseguir a venda do plano!';
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


//REGRA DE NEGOCIO FOI ALTERADA PARA AQUI PARA FICAR MAIS DINAMICA E SIMPLES


function valorTotalPlano() {
    
    var mensal = 1;
    var semestral = 6;
    var anual = 12;
    var descontoMensal = 0.10;
    var descontoSemestral = 0.15;
    var descontoAnual = 0.20;
    var valorBasePlanoBronze = 225;
    var valorBasePlanoPrata = 99;
    var valorBasePlanoOuro = 324;

    var assinatura = document.getElementById('assinatura').value;
    var tipo_assinatura = document.getElementById('tipo_assinatura').value;

    var valorPlanoEscolhido = 0.0;
    switch (assinatura) {
        case "ouro":

            if (tipo_assinatura === "mensal") {
                valorPlanoEscolhido = (mensal * valorBasePlanoOuro) - ((mensal * valorBasePlanoOuro) * descontoMensal);
            } else if (tipo_assinatura === "semestral") {
                valorPlanoEscolhido = (semestral * valorBasePlanoOuro) - ((semestral * valorBasePlanoOuro) * descontoSemestral);
            } else {
                valorPlanoEscolhido = (anual * valorBasePlanoOuro) - ((anual * valorBasePlanoOuro) * descontoAnual);
            }
            break;
        case "prata":

            if (tipo_assinatura === "mensal") {
                valorPlanoEscolhido = (mensal * valorBasePlanoPrata) - ((mensal * valorBasePlanoPrata) * descontoMensal);
            } else if (tipo_assinatura === "semestral") {
                valorPlanoEscolhido = (semestral * valorBasePlanoPrata) - ((semestral * valorBasePlanoPrata) * descontoSemestral);
            } else {
                valorPlanoEscolhido = (anual * valorBasePlanoPrata) - ((anual * valorBasePlanoPrata) * descontoAnual);
            }
            break;
        case "bronze":

            if (tipo_assinatura === "mensal") {
                valorPlanoEscolhido = (mensal * valorBasePlanoBronze) - ((mensal * valorBasePlanoBronze) * descontoMensal);
            } else if (tipo_assinatura === "semestral") {
                valorPlanoEscolhido = (semestral * valorBasePlanoBronze) - ((semestral * valorBasePlanoBronze) * descontoSemestral);
            } else {
                valorPlanoEscolhido = (anual * valorBasePlanoBronze) - ((anual * valorBasePlanoBronze) * descontoAnual);
            }
            break;
        default:
            break;
    }

    var campoValorTotalPlano = document.getElementById('valorPlanoEscolhido');
    campoValorTotalPlano.value = valorPlanoEscolhido.toFixed(2);
    var valorFinalPlano = document.getElementById('valorFinalPlano');
    valorFinalPlano.value = valorPlanoEscolhido.toFixed(2);
    

}

    