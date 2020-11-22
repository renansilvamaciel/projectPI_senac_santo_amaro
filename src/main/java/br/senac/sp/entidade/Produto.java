package br.senac.sp.entidade;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Nailson Nascimento <nailsonbr@gmail.com>
 */
@Getter
@Setter

public class Produto {

    private int id_produto;
    private String nome;
    private String familia;
    private int quantidade;
    private double preco;
    private String descricao;
    private String filial;

    public Produto() {

    }

    public Produto(int id_produto, String nome, String familia, int quantidade, double preco, String descricao, String filial) {
        this.id_produto = id_produto;
        this.nome = nome;
        this.familia = familia;
        this.quantidade = quantidade;
        this.preco = preco;
        this.descricao = descricao;
        this.filial = filial;
    }

    public Produto(String nome, String familia, int quantidade, double preco, String descricao, String filial) {

        this.nome = nome;
        this.familia = familia;
        this.quantidade = quantidade;
        this.preco = preco;
        this.descricao = descricao;
        this.filial = filial;
    }

    public void addProduto() {
        this.quantidade += 1;
    }

    public void removeProduto() {
            this.quantidade -= 1;
    }
    
    

    @Override
    public String toString() {
        return String.format(
                "id_produto: %d <br/> "
                + "nome: %s <br/>"
                + "familia: %s <br/>"
                + "quantidade: %d <br/>"
                + "preço: %.2f <br/>"
                + "descricao: %s </br>  "
                + "filial: %s <hr>  ",
                id_produto, nome, familia, quantidade, preco, descricao, filial);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id_produto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.id_produto != other.id_produto) {
            return false;
        }
        return true;
    }

}
