/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

/**
 *
 * @author Juliano
 */
public class Relatorio {

    private int id_venda;
    private int id_vendedor;
    private String modelo;
    private int quantidade;
    private double valor;
    private String data;
    private int filial;

    public Relatorio(int id_venda, int id_vendedor, String modelo, int quantidade, double valor, String data, int filial) {
        this.id_venda = id_venda;
        this.id_vendedor = id_vendedor;
        this.modelo = modelo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.data = data;
        this.filial = filial;
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQauntidade() {
        return quantidade;
    }

    public void setQauntidade(int qauntidade) {
        this.quantidade = qauntidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getFilial() {
        return filial;
    }

    public void setFilial(int filial) {
        this.filial = filial;
    }
}
