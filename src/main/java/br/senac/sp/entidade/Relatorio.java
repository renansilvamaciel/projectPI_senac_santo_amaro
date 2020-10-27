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
    private double valor_total;
    private String data_hoje;
    private int id_filial;
    private String nome;
    
    public Relatorio(){
        
    }

    public Relatorio(int id_venda, int id_vendedor, String nome_produto, int quantidade, double valor_total, String data_hoje, int id_filial, String nome) {
        this.id_venda = id_venda;
        this.id_vendedor = id_vendedor;
        this.nome_produto = nome_produto;
        this.quantidade = quantidade;
        this.valor_total = valor_total;
        this.data_hoje = data_hoje;
        this.id_filial = id_filial;
        this.nome = nome;
    }
    
    
}
