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

    public boolean validationClient(String cpf) {
        boolean success = false;
        if (cpf != null && !cpf.isEmpty()) {
            success = true;
        }

        return success;
    }
}
