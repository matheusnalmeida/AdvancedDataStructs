/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.GenericTree.GenericTreePatternsApplication.DirectoryPattern;

/**
 *
 * @author Matheus Nunes
 */
public class Arquivo {

    private String nome;
    private float tamanho;

    public Arquivo(String nome, float tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public float getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
