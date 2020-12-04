/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.entidade;

import at.favre.lib.crypto.bcrypt.BCrypt;
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
    private String senha;
    private String cargo;
    private int venda;
    private int quantidade;

    public String codificarSenha(String senha) {
        return BCrypt.withDefaults().hashToString(12, senha.toCharArray());
    }
    
    public boolean validarSenha(String senha){
        BCrypt.Result response = BCrypt.verifyer().verify(senha.toCharArray(), this.senha);
        return response.verified;
    }

    public Funcionario() {

    }

}
