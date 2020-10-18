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
 * @author Juliano
 */
@Getter
@Setter
public class Relatorio {

    private int id_venda;
    private int id_vendedor;
    private String nome_produto;
    private int quantidade;
    private double valor;
    private String data;
    private int filial;
    
    public Relatorio(){
        
    }

    public Relatorio(int id_venda, int id_vendedor, String nome_produto, int quantidade, double valor, String data, int filial) {
        this.id_venda = id_venda;
        this.id_vendedor = id_vendedor;
        this.nome_produto = nome_produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.data = data;
        this.filial = filial;
    }

}
