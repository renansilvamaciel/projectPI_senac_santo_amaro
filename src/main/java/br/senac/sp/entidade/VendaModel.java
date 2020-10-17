/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

/**
 *
 * @author Marcos Vinicius Santos Souza
 */
public class VendaModel {

    private int id_venda;
    private String cpf;
    private int id_vendedor;
    private int quantidade;
    private double valor_total;
    private String data_hoje;
    private int id_filial;

    public VendaModel() {
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor_total() {
        return valor_total;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public String getData_hoje() {
        return data_hoje;
    }

    public void setData_hoje(String data_hoje) {
        this.data_hoje = data_hoje;
    }

    public int getId_filial() {
        return id_filial;
    }

    public void setId_filial(int id_filial) {
        this.id_filial = id_filial;
    }

}
