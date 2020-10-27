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
 * @author diego
 */
@Getter
@Setter
public class Funcionario extends Pessoa {

    private int id_funcionario;
    private int filial;
    private int venda;
    private int quantidade;

    public Funcionario() {

    }

}
