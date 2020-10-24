/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Azazel
 */
@Getter
@Setter
public class VendaPlanos {

    private int id_venda;
    private String cpf;
    private int id_vendedor;
    private String assinatura;
    private String tipo_assinatura;
    private int id_filial;
    private double valorTotal;
    private final int mensal = 1;
    private final int semestral = 6;
    private final int anual = 12;
    private final double descontoMensal = 0.10;
    private final double descontoSemestral = 0.15;
    private final double descontoAnual = 0.20;
    private final int valorBasePlanoBronze = 225;
    private final int valorBasePlanoPrata = 99;
    private final int valorBasePlanoOuro = 324;

    public boolean validationClient(String cpf) {
        boolean success = false;
        if (cpf != null && !cpf.isEmpty()) {
            success = true;
        }

        return success;
    }

    public double validarValorPlano(String assinatura, String tipo_assinatura) {
        double valorPlanoEscolhido = 0.0;

        switch (assinatura) {
            case "ouro":

                if (tipo_assinatura.equalsIgnoreCase("mensal")) {
                    valorPlanoEscolhido = (mensal * valorBasePlanoOuro) - ((mensal * valorBasePlanoOuro) * descontoMensal);
                } else if (tipo_assinatura.equalsIgnoreCase("semestral")) {
                    valorPlanoEscolhido = (semestral * valorBasePlanoOuro) - ((semestral * valorBasePlanoOuro) * descontoSemestral);
                } else {
                    valorPlanoEscolhido = (anual * valorBasePlanoOuro) - ((anual * valorBasePlanoOuro) * descontoAnual);
                }
                break;

            case "prata":

                if (tipo_assinatura.equalsIgnoreCase("mensal")) {
                    valorPlanoEscolhido = (mensal * valorBasePlanoPrata) - ((mensal * valorBasePlanoPrata) * descontoMensal);
                } else if (tipo_assinatura.equalsIgnoreCase("semestral")) {
                    valorPlanoEscolhido = (semestral * valorBasePlanoPrata) - ((semestral * valorBasePlanoPrata) * descontoSemestral);
                } else {
                    valorPlanoEscolhido = (anual * valorBasePlanoPrata) - ((anual * valorBasePlanoPrata) * descontoAnual);
                }
                break;

            case "bronze":

                if (tipo_assinatura.equalsIgnoreCase("mensal")) {
                    valorPlanoEscolhido = (mensal * valorBasePlanoBronze) - ((mensal * valorBasePlanoBronze) * descontoMensal);
                } else if (tipo_assinatura.equalsIgnoreCase("semestral")) {
                    valorPlanoEscolhido = (semestral * valorBasePlanoBronze) - ((semestral * valorBasePlanoBronze) * descontoSemestral);
                } else {
                    valorPlanoEscolhido = (anual * valorBasePlanoBronze) - ((anual * valorBasePlanoBronze) * descontoAnual);
                }
                break;

            default:
                break;
        }

        return valorPlanoEscolhido;
    }
}
