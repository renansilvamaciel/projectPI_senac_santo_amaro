/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Azazel
 */
public class Cliente extends Pessoa {

    private int id_cliente;
    private String assinatura;

    public Cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public boolean validacaoIdade(String data) {
        boolean success = false;

        String ano[] = data.split("-");
        String dataAtual[] = pegarDataAtual().split("/");

        int anoAtual = Integer.parseInt(dataAtual[2]);
        int anoPessoa = Integer.parseInt(ano[0]);
        
        if (anoAtual - anoPessoa >= 18) {
            success = true;
            return success;
        }

        return success;
    }

    private String pegarDataAtual() {
        Date data = new Date();
        String dataAtual = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(data);
        return dataAtual;
    }

}
