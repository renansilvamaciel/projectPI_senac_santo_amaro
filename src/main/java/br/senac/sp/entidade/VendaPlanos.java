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
                    valorPlanoEscolhido = valorBasePlanoOuro - valorBasePlanoOuro * descontoMensal;
                } else if (tipo_assinatura.equalsIgnoreCase("semestral")) {
                    valorPlanoEscolhido = valorBasePlanoOuro - valorBasePlanoOuro * descontoSemestral;
                } else {
                    valorPlanoEscolhido = valorBasePlanoOuro - valorBasePlanoOuro * descontoAnual;
                }
                break;

            case "prata":

                if (tipo_assinatura.equalsIgnoreCase("mensal")) {
                    valorPlanoEscolhido = valorBasePlanoPrata - valorBasePlanoPrata * descontoMensal;
                } else if (tipo_assinatura.equalsIgnoreCase("semestral")) {
                    valorPlanoEscolhido = valorBasePlanoPrata - valorBasePlanoPrata * descontoSemestral;
                } else {
                    valorPlanoEscolhido = valorBasePlanoPrata - valorBasePlanoPrata * descontoAnual;
                }
                break;

            case "bronze":

                if (tipo_assinatura.equalsIgnoreCase("mensal")) {
                    valorPlanoEscolhido = valorBasePlanoBronze - valorBasePlanoBronze * descontoMensal;
                } else if (tipo_assinatura.equalsIgnoreCase("semestral")) {
                    valorPlanoEscolhido = valorBasePlanoBronze - valorBasePlanoBronze * descontoSemestral;
                } else {
                    valorPlanoEscolhido = valorBasePlanoBronze - valorBasePlanoBronze * descontoAnual;
                }
                break;

            default:
                break;
        }

        return valorPlanoEscolhido;
    }
}
