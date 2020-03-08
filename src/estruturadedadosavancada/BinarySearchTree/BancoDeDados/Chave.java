/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruturadedadosavancada.BinarySearchTree.BancoDeDados;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 *
 * @author Matheus Nunes
 */
public class Chave<E> implements Comparable<Chave<E>>{
    private String tipo;
    private String nome;
    private E elemento;
    
    public Chave(String tipo,String nome){
        this.tipo = tipo;
        this.nome = nome;
    }
    
    public Chave(String tipo,E elemento) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException{
        Class<?> element_class = elemento.getClass();
        
        //Caso nao exista um atributo com nome igual ao tipo informado, sera lançada uma excessao
        Field f = element_class.getDeclaredField(tipo);
        f.setAccessible(true);
        
        //Retornando o valor do atributo em string
        String valor = f.get(elemento).toString();
        this.tipo = tipo;
        this.nome = valor;
        this.elemento = elemento;
    }
        
    public String getTipo() {
        return this.tipo;
    }

    public String getNome() {
        return this.nome;
    }

    public E getElemento() {
        return elemento;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    @Override
    public int compareTo(Chave o) {
        return this.nome.compareTo(o.getNome());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.tipo);
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
        final Chave other = (Chave) obj;
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
}
