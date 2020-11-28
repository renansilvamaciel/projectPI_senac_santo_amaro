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
 * @author Nailson Nascimento <nailsonbr@gmail.com>
 */

@Setter
@Getter
public class Venda {
    private int id_venda;


    private int id_funcionario;
    private int quantidade;
    private double valorFinal;
    private String data;
    private int id_filial;

    public Venda(int id_funcionario, int quantidade, double valorFinal, int id_filial) {
        this.id_funcionario = id_funcionario;
        this.quantidade = quantidade;
        this.valorFinal = valorFinal;
        this.id_filial = id_filial;
    }
    
    
}
