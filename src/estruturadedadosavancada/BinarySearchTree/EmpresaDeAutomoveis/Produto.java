/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.EmpresaDeAutomoveis;

/**
 *
 * @author Matheus Nunes
 */
public class Produto {

    private String nome;
    private int ano;
    private Integer chassi;
    private Categoria categoria;
    private Comprador comprador;

    public Produto(String nome, int ano, Integer chassi, Categoria categoria) {
        this.nome = nome;
        this.ano = ano;
        this.chassi = chassi;
        this.categoria = categoria;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public int getChassi() {
        return chassi;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Comprador getComprador() {
        return comprador;
    }

    @Override
    public String toString() {
        StringBuilder construtor = new StringBuilder();
        construtor.append("-------------------------------------------------------------------------------------------------------------------------------------\n");
        construtor.append("Nome: ").append(this.nome).append("\n");
        construtor.append("Ano: ").append(this.ano).append("\n");
        construtor.append("Chassi: ").append(this.chassi).append("\n");
        construtor.append("Categoria: ").append(this.categoria.getNome()).append("\n");
        if (comprador != null) {
            construtor.append("Comprador: ").append(this.comprador.getNome()).append("\n");
        }else{
            construtor.append("Comprador: O produto nao foi vendido ainda");
        }
        return construtor.toString();
    }

}
