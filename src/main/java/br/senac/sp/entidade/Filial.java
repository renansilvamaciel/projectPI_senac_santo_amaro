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
public class Filial {

    private int id_filial;
    private String nome;
    private String cnpj;
    private String estado;
    private String rua;
    private String cep;
    private int numero;
    private String bairro;

    public Filial() {
    }

}
